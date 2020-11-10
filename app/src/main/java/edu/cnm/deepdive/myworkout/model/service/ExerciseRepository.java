package edu.cnm.deepdive.myworkout.model.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.myworkout.model.dao.ExerciseDao;
import edu.cnm.deepdive.myworkout.model.entity.Exercise;
import edu.cnm.deepdive.myworkout.model.entity.Muscle;
import io.reactivex.Completable;
import java.util.List;

public class ExerciseRepository {

  private final Context context;
  private final ExerciseDao exerciseDao;

  public ExerciseRepository(Context context) {
    this.context = context;
    exerciseDao = MyWorkoutDatabase.getInstance().getExerciseDao();
  }

  public Completable save(Exercise exercise) {
    return (exercise.getId() == 0)
        ? exerciseDao.insert(exercise).doAfterSuccess(exercise::setId).ignoreElement()
        : exerciseDao.update(exercise).ignoreElement();
  }

  public Completable delete(Exercise exercise) {
    return (exercise.getId() == 0)
        ? Completable.complete()
        : exerciseDao.delete(exercise).ignoreElement();
  }

  public LiveData<Exercise> getExerciseById(long exerciseId) {
    return exerciseDao.select(exerciseId);
  }

  public LiveData<List<Exercise>> getAllExercises() {
    return exerciseDao.selectAll();
  }

  public LiveData<List<Exercise>> getExercisesByArea(Muscle.Area area) {
    return exerciseDao.selectByMuscleArea(area);
  }
}
