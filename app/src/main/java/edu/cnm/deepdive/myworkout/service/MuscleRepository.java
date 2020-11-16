package edu.cnm.deepdive.myworkout.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.myworkout.model.dao.MuscleDao;
import edu.cnm.deepdive.myworkout.model.entity.Muscle;
import io.reactivex.Completable;
import java.util.List;

public class MuscleRepository {

  private final Context context;
  private final MuscleDao muscleDao;

  public MuscleRepository(Context context) {
    this.context = context;
    muscleDao = MyWorkoutDatabase.getInstance().getMuscleDao();
  }

  public Completable save(Muscle muscle) {
    return (muscle.getId() == 0)
        ? muscleDao.insert(muscle).doAfterSuccess(muscle::setId).ignoreElement()
        : muscleDao.update(muscle).ignoreElement();
  }

  public Completable delete(Muscle muscle) {
    return (muscle.getId() == 0)
        ? Completable.complete()
        : muscleDao.delete(muscle).ignoreElement();
  }

  public LiveData<Muscle> getMuscleById(long muscleId) {
    return muscleDao.select(muscleId);
  }

  public LiveData<Muscle> getMuscleByName(String name) {
    return muscleDao.selectByName(name);
  }

  public LiveData<List<Muscle>> getAllMuscles() {
    return muscleDao.selectAllOrderByArea();
  }

  public LiveData<List<Muscle>> getMusclesByArea(Muscle.Area area) {
    return muscleDao.selectMusclesByArea(area);
  }
}
