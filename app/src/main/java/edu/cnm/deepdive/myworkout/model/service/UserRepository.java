package edu.cnm.deepdive.myworkout.model.service;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import edu.cnm.deepdive.myworkout.model.dao.UserDao;
import edu.cnm.deepdive.myworkout.model.entity.User;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;

public class UserRepository {

  private final Context context;
  private final UserDao userDao;
  private final GoogleSignInService signInService;

  public UserRepository(Context context) {
    this.context = context;
    userDao = MyWorkoutDatabase.getInstance().getUserDao();
    signInService = GoogleSignInService.getInstance();
  }

  public Single<User> createUser(@NonNull GoogleSignInAccount account) {
    return Single.fromCallable(() -> {
      User user = new User();
      user.setName(account.getDisplayName());
      user.setOauthKey(account.getId());
      return user;
    })
        .flatMap((user) ->
            userDao.insert(user)
                .map((id) -> {
                  if (id > 0) {
                    user.setId(id);
                  }
                  return user;
                })
        )
        .subscribeOn(Schedulers.io());
  }
}
