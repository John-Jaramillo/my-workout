package edu.cnm.deepdive.myworkout.model.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.myworkout.model.dao.ProgressDao;
import edu.cnm.deepdive.myworkout.model.entity.Progress;
import io.reactivex.Completable;
import java.util.List;

public class ProgressRepository {

  private final Context context;
  private final ProgressDao progressDao;

  public ProgressRepository(Context context) {
    this.context = context;
    progressDao = MyWorkoutDatabase.getInstance().getProgressDao();
  }

  public Completable save(Progress progress) {
    return (progress.getId() == 0)
        ? progressDao.insert(progress).doAfterSuccess(progress::setId).ignoreElement()
        : progressDao.update(progress).ignoreElement();
  }

  public Completable delete(Progress progress) {
    return (progress.getId() == 0)
        ? Completable.complete()
        : progressDao.delete(progress).ignoreElement();
  }

  public LiveData<Progress> getProgressById(long progressId) {
    return progressDao.select(progressId);
  }

  public LiveData<List<Progress>> getProgressByUser(long userId) {
    return progressDao.selectByUser(userId);
  }

  public LiveData<List<Progress>> getAll() {
    return progressDao.selectAll();
  }
}
