package edu.cnm.deepdive.myworkout.model.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.myworkout.model.dao.WeightDao;
import edu.cnm.deepdive.myworkout.model.entity.Weight;
import io.reactivex.Completable;
import java.util.List;

public class WeightRepository {

  private final Context context;
  private final WeightDao weightDao;

  public WeightRepository(Context context) {
    this.context = context;
    weightDao = MyWorkoutDatabase.getInstance().getWeightDao();
  }

  public Completable save(Weight weight) {
    return (weight.getId() == 0)
        ? weightDao.insert(weight).doAfterSuccess(weight::setId).ignoreElement()
        : weightDao.update(weight).ignoreElement();
  }

  public Completable delete(Weight weight) {
    return (weight.getId() == 0)
        ? Completable.complete()
        : weightDao.delete(weight).ignoreElement();
  }

  public LiveData<Weight> getWeightById(long weightId) {
    return weightDao.select(weightId);
  }

  public LiveData<List<Weight>> getWeightByUser(long user) {
    return weightDao.selectWeightByUser(user);
  }
}
