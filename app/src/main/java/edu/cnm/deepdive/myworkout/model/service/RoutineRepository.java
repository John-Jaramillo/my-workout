package edu.cnm.deepdive.myworkout.model.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.myworkout.model.dao.ExerciseDao;
import edu.cnm.deepdive.myworkout.model.dao.RoutineDao;
import edu.cnm.deepdive.myworkout.model.entity.Exercise;
import edu.cnm.deepdive.myworkout.model.entity.Muscle;
import edu.cnm.deepdive.myworkout.model.entity.Routine;
import io.reactivex.Completable;
import java.util.List;

public class RoutineRepository {

  private final Context context;
  private final RoutineDao routineDao;

  public RoutineRepository(Context context) {
    this.context = context;
    routineDao = MyWorkoutDatabase.getInstance().getRoutineDao();
  }

  public Completable save(Routine routine) {
    return (routine.getId() == 0)
        ? routineDao.insert(routine).doAfterSuccess(routine::setId).ignoreElement()
        : routineDao.update(routine).ignoreElement();
  }

  public Completable delete(Routine routine) {
    return (routine.getId() == 0)
        ? Completable.complete()
        : routineDao.delete(routine).ignoreElement();
  }

  public LiveData<Routine> getRoutineById(long routineId) {
    return routineDao.select(routineId);
  }

  public LiveData<List<Routine>> getRoutinesByUser(long userId) {
    return routineDao.selectByUserId(userId);
  }
}
