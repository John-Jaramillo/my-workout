package edu.cnm.deepdive.myworkout.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.myworkout.model.entity.Muscle;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface MuscleDao {

  @Insert
  Single<Long> insert(Muscle muscle);

  @Insert
  Single<List<Long>> insert(Muscle... muscles);

  @Insert
  Single<List<Long>> insert(Collection<Muscle> muscles);

  @Update
  Single<Integer> update(Muscle muscle);

  @Update
  Single<Integer> update(Muscle... muscles);

  @Update
  Single<Integer> update(Collection<Muscle> muscles);

  @Delete
  Single<Integer> delete(Muscle muscle);

  @Delete
  Single<Integer> delete(Muscle... muscles);

  @Delete
  Single<Integer> delete(Collection<Muscle> muscles);


  @Query("SELECT * FROM Muscle WHERE muscle_id = :id")
  LiveData<Muscle> select(long id);

  @Query("SELECT * FROM Muscle WHERE name = :name")
  LiveData<Muscle> selectByName(String name);

  @Query("SELECT * FROM Muscle ORDER BY area, name")
  LiveData<List<Muscle>> selectAllOrderByArea();

  @Query("SELECT * FROM Muscle WHERE area = :area ORDER BY name")
  LiveData<List<Muscle>> selectMusclesByArea(Muscle.Area area);
}
