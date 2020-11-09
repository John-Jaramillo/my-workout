package edu.cnm.deepdive.myworkout;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.myworkout.model.service.MyWorkoutDatabase;
import io.reactivex.schedulers.Schedulers;

public class MyWorkoutApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
//    GoogleSignInService.setContext(this);
    MyWorkoutDatabase.setContext(this);
    MyWorkoutDatabase.getInstance().getUserDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }
}
