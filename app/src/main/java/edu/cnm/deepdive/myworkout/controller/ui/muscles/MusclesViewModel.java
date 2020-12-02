package edu.cnm.deepdive.myworkout.controller.ui.muscles;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.myworkout.model.entity.Muscle;
import edu.cnm.deepdive.myworkout.service.MuscleRepository;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class MusclesViewModel extends AndroidViewModel {

  private final MuscleRepository muscleRepository;
  private final LiveData<List<Muscle>> muscles;
  private final MutableLiveData<Boolean> front;
  private final MutableLiveData<Throwable> throwable;

  public MusclesViewModel(
      @NonNull Application application) {
    super(application);
    muscleRepository = new MuscleRepository(application);
    front = new MutableLiveData<>(true);
    muscles = Transformations.switchMap(front, muscleRepository::getAllByFront);
    throwable = new MutableLiveData<>();
  }

  public LiveData<List<Muscle>> getMuscles() {
    return muscles;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void setFront (boolean front) {
    this.front.setValue(front);
  }
}
