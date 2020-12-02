package edu.cnm.deepdive.myworkout.controller.ui.muscles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MusclesViewModel {
  private MutableLiveData<String> mText;

  public MusclesViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is muscles fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}
