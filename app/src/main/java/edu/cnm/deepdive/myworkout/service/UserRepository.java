package edu.cnm.deepdive.myworkout.service;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import edu.cnm.deepdive.myworkout.model.dao.UserDao;
import edu.cnm.deepdive.myworkout.model.entity.User;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class UserRepository {

  private final Context context;
  private final UserDao userDao;
  private final GoogleSignInService signInService;

  public UserRepository(Context context) {
    this.context = context;
    userDao = MyWorkoutDatabase.getInstance().getUserDao();
    signInService = GoogleSignInService.getInstance();
  }

  public Single<User> getOrCreate(@NonNull GoogleSignInAccount account) {
    return userDao.selectByOauthKey(account.getId())
        .switchIfEmpty((SingleSource<User>) observer -> {
            User user = new User();
            user.setName(account.getDisplayName());
            user.setOauthKey(account.getId());
            userDao.insert(user)
                .map((id) -> {
                  user.setId(id);
                  return user;
                })
                .subscribe(observer);
        })
        .subscribeOn(Schedulers.io());
  }

  public Completable delete(User user) {
    return (user.getId() == 0)
        ? Completable.complete()
        : userDao.delete(user).ignoreElement();
  }

  public LiveData<User> getUserById(long userId) {
    return userDao.selectById(userId);
  }

  public LiveData<List<User>> getAll() {
    return userDao.selectAll();
  }
}
