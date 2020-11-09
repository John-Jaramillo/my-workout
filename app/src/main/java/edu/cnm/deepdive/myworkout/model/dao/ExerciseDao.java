package edu.cnm.deepdive.myworkout.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.myworkout.model.entity.Exercise;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ExerciseDao {

  @Insert
  Single<Long> insert(Exercise exercise);

  @Insert
  Single<List<Long>> insert(Exercise... exercises);

  @Insert
  Single<List<Long>> insert(Collection<Exercise> exercises);

  @Update
  Single<Integer> update(Exercise exercise);

  @Update
  Single<Integer> update(Exercise... exercises);

  @Update
  Single<Integer> update(Collection<Exercise> exercises);

  @Delete
  Single<Integer> delete(Exercise exercise);

  @Delete
  Single<Integer> delete(Exercise... exercises);

  @Delete
  Single<Integer> delete(Collection<Exercise> exercises);


  @Query("SELECT * FROM Exercise WHERE exercise_id = :id")
  LiveData<Exercise> select(long id);

}
