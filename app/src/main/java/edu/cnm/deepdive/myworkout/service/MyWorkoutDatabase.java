package edu.cnm.deepdive.myworkout.service;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.myworkout.R;
import edu.cnm.deepdive.myworkout.model.dao.ExerciseDao;
import edu.cnm.deepdive.myworkout.model.dao.ExerciseMuscleDao;
import edu.cnm.deepdive.myworkout.model.dao.MuscleDao;
import edu.cnm.deepdive.myworkout.model.dao.ProgressDao;
import edu.cnm.deepdive.myworkout.model.dao.RoutineDao;
import edu.cnm.deepdive.myworkout.model.dao.UserDao;
import edu.cnm.deepdive.myworkout.model.dao.WeightDao;
import edu.cnm.deepdive.myworkout.model.dto.SetupData;
import edu.cnm.deepdive.myworkout.model.entity.Exercise;
import edu.cnm.deepdive.myworkout.model.entity.ExerciseMuscle;
import edu.cnm.deepdive.myworkout.model.entity.Muscle;
import edu.cnm.deepdive.myworkout.model.entity.Progress;
import edu.cnm.deepdive.myworkout.model.entity.Routine;
import edu.cnm.deepdive.myworkout.model.entity.User;
import edu.cnm.deepdive.myworkout.model.entity.Weight;
import edu.cnm.deepdive.myworkout.service.MyWorkoutDatabase.Converters;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

@Database(entities = {Exercise.class, ExerciseMuscle.class, Muscle.class, Progress.class,
    Routine.class, User.class, Weight.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class, Muscle.Area.class, Routine.Day.class})
public abstract class MyWorkoutDatabase extends RoomDatabase {

  private static final String DB_NAME = "myworkout_db";

  private static Application context;

  public static void setContext(Application context) {
    MyWorkoutDatabase.context = context;
  }

  public static MyWorkoutDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract UserDao getUserDao();

  public abstract MuscleDao getMuscleDao();

  public abstract WeightDao getWeightDao();

  public abstract ExerciseDao getExerciseDao();

  public abstract ProgressDao getProgressDao();

  public abstract RoutineDao getRoutineDao();

  public abstract ExerciseMuscleDao getExerciseMuscleDao();

  private static class InstanceHolder {

    private static final MyWorkoutDatabase INSTANCE =
        Room.databaseBuilder(context, MyWorkoutDatabase.class, DB_NAME)
            .addCallback(new Callback())
            .build();

  }

  private static class Callback extends RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .create();
      try (
          InputStream input = context.getResources().openRawResource(R.raw.exercises);
          Reader reader = new InputStreamReader(input)
      ) {
        SetupData data = gson.fromJson(reader, SetupData.class);
        Map<String, Muscle> muscleMap = data.getMuscles().stream()
            .collect(Collectors.toMap(Muscle::getName, (muscle) -> muscle));
        List<Exercise> exercises = data.getExercises();
        MuscleDao muscleDao = InstanceHolder.INSTANCE.getMuscleDao();
        ExerciseDao exerciseDao = InstanceHolder.INSTANCE.getExerciseDao();
        ExerciseMuscleDao exerciseMuscleDao = InstanceHolder.INSTANCE.getExerciseMuscleDao();
        Collection<Muscle> muscles = muscleMap.values();
        muscleDao.insert(muscles)
            .map((ids) -> {
              Iterator<Long> idIterator = ids.iterator();
              Iterator<Muscle> muscleIterator = muscles.iterator();
              while (idIterator.hasNext()) {
                muscleIterator.next().setId(idIterator.next());
              }
              return muscles;
            })
            .flatMap((m) -> exerciseDao.insert(exercises))
            .map((ids) -> {
              Iterator<Long> idIterator = ids.iterator();
              Iterator<Exercise> exerciseIterator = exercises.iterator();
              while (idIterator.hasNext()) {
                exerciseIterator.next().setId(idIterator.next());
              }
              return exercises;
            })
            .flatMap((exer) -> {
              List<ExerciseMuscle> exerciseMuscles = new LinkedList<>();
              for (Exercise exercise : exercises) {
                for (String muscleName : exercise.getPrimaryMuscles()) {
                  if (muscleMap.containsKey(muscleName)) {
                    ExerciseMuscle exerciseMuscle = new ExerciseMuscle();
                    exerciseMuscle.setExerciseId(exercise.getId());
                    exerciseMuscle.setMuscleId(muscleMap.get(muscleName).getId());
                    exerciseMuscle.setPrimary(true);
                    exerciseMuscles.add(exerciseMuscle);
                  }
                }
                for (String muscleName : exercise.getSecondaryMuscles()) {
                  if (muscleMap.containsKey(muscleName)) {
                    ExerciseMuscle exerciseMuscle = new ExerciseMuscle();
                    exerciseMuscle.setExerciseId(exercise.getId());
                    exerciseMuscle.setMuscleId(muscleMap.get(muscleName).getId());
                    exerciseMuscle.setPrimary(false);
                    exerciseMuscles.add(exerciseMuscle);
                  }
                }
              }
              return exerciseMuscleDao.insert(exerciseMuscles);
            })
            .subscribeOn(Schedulers.io())
            .subscribe();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }

  }

}
