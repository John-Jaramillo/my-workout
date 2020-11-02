package edu.cnm.deepdive.myworkout.model.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.myworkout.model.entity.Equipment;
import edu.cnm.deepdive.myworkout.model.entity.Exercise;
import edu.cnm.deepdive.myworkout.model.entity.ExerciseEquipment;
import edu.cnm.deepdive.myworkout.model.entity.ExerciseMuscle;
import edu.cnm.deepdive.myworkout.model.entity.Muscle;
import edu.cnm.deepdive.myworkout.model.entity.Progress;
import edu.cnm.deepdive.myworkout.model.entity.Routine;
import edu.cnm.deepdive.myworkout.model.entity.User;
import edu.cnm.deepdive.myworkout.model.entity.Weight;
import edu.cnm.deepdive.myworkout.model.service.MyWorkoutDatabase.Converters;
import java.util.Date;

@Database(entities = {Equipment.class, Exercise.class, ExerciseEquipment.class, ExerciseMuscle.class,
    Muscle.class, Progress.class, Routine.class, User.class, Weight.class},
    version = 1,
    exportSchema = true
)

@TypeConverters({Converters.class, Exercise.ExerciseType.class, Muscle.Area.class, Routine.Day.class})
public abstract class MyWorkoutDatabase extends RoomDatabase {

  private static final String DB_NAME = "myworkout_db";

  private static Application context;

  public static void setContext(Application context) {
    MyWorkoutDatabase.context = context;
  }

  public static MyWorkoutDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final MyWorkoutDatabase INSTANCE =
        Room.databaseBuilder(context, MyWorkoutDatabase.class, DB_NAME)
            .build();

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
