package edu.cnm.deepdive.myworkout.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.myworkout.model.entity.Progress;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ProgressDao {

  @Insert
  Single<Long> insert(Progress progress);

  @Insert
  Single<List<Long>> insert(Progress... progresses);

  @Insert
  Single<List<Long>> insert(Collection<Progress> progresses);

  @Update
  Single<Integer> update(Progress progress);

  @Update
  Single<Integer> update(Progress... progresses);

  @Update
  Single<Integer> update(Collection<Progress> progresses);

  @Delete
  Single<Integer> delete(Progress progress);

  @Delete
  Single<Integer> delete(Progress... progresses);

  @Delete
  Single<Integer> delete(Collection<Progress> progresses);


  @Query("SELECT * FROM Progress WHERE progress_id = :id")
  LiveData<Progress> select(long id);

  @Query("SELECT * FROM Progress WHERE user_id = :id ORDER BY date ASC, exercise_id ASC, `set` ASC")
  LiveData<List<Progress>> selectByUser(long id);

}
