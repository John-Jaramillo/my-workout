package edu.cnm.deepdive.myworkout.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.myworkout.model.entity.ExerciseMuscle;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ExerciseMuscleDao {

  @Insert
  Single<Long> insert(ExerciseMuscle exerciseMuscle);

  @Insert
  Single<List<Long>> insert(ExerciseMuscle... exerciseMuscles);

  @Insert
  Single<List<Long>> insert(Collection<ExerciseMuscle> exerciseMuscles);

  @Update
  Single<Integer> update(ExerciseMuscle exerciseMuscle);

  @Update
  Single<Integer> update(ExerciseMuscle... exerciseMuscles);

  @Update
  Single<Integer> update(Collection<ExerciseMuscle> exerciseMuscles);

  @Delete
  Single<Integer> delete(ExerciseMuscle exerciseMuscle);

  @Delete
  Single<Integer> delete(ExerciseMuscle... exerciseMuscles);

  @Delete
  Single<Integer> delete(Collection<ExerciseMuscle> exerciseMuscles);


  @Query("SELECT * FROM ExerciseMuscle WHERE exercise_muscle_id = :id")
  LiveData<ExerciseMuscle> select(long id);

  @Query("SELECT * FROM ExerciseMuscle ORDER BY muscle_id ASC, `primary`")
  LiveData<List<ExerciseMuscle>> selectAll();
}
