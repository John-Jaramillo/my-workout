package edu.cnm.deepdive.myworkout;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class MyWorkoutApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }
}
