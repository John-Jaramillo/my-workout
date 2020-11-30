package edu.cnm.deepdive.myworkout.controller.ui.routine;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RoutineViewModel extends ViewModel{
  private MutableLiveData<String> mText;

  public RoutineViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is routine fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }

}
