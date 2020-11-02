package edu.cnm.deepdive.myworkout.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.myworkout.model.entity.Routine;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface RoutineDao {

  @Insert
  Single<Long> insert(Routine routine);

  @Insert
  Single<List<Long>> insert(Routine... routines);

  @Insert
  Single<List<Long>> insert(Collection<Routine> routines);

  @Update
  Single<Integer> update(Routine routine);

  @Update
  Single<Integer> update(Routine... routines);

  @Update
  Single<Integer> update(Collection<Routine> routines);

  @Delete
  Single<Integer> delete(Routine routine);

  @Delete
  Single<Integer> delete(Routine... routines);

  @Delete
  Single<Integer> delete(Collection<Routine> routines);


  @Query("SELECT * FROM Routine WHERE routine_id = :id")
  LiveData<Routine> select(long id);
}
