package edu.cnm.deepdive.myworkout.controller.ui.exercises;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import edu.cnm.deepdive.myworkout.model.entity.Exercise;
import edu.cnm.deepdive.myworkout.model.entity.Muscle.Area;
import edu.cnm.deepdive.myworkout.service.ExerciseRepository;
import java.util.List;

public class ExercisesViewModel extends AndroidViewModel {

  private final ExerciseRepository exerciseRepository;
  private final LiveData<List<Exercise>> exercises;
  private final MutableLiveData<Area> area;
  private final MutableLiveData<Throwable> throwable;

  public ExercisesViewModel(@NonNull Application application) {
    super(application);
    exerciseRepository = new ExerciseRepository(application);
    area = new MutableLiveData<>(Area.CHEST);
    exercises = Transformations.switchMap(area, exerciseRepository::getExercisesByArea);
    throwable = new MutableLiveData<>();
  }

  public LiveData<List<Exercise>> getExercises() {
    return exercises;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void setArea (Area area) {
    this.area.setValue(area);
  }

}
