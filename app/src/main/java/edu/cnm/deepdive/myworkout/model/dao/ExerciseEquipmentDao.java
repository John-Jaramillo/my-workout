package edu.cnm.deepdive.myworkout.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.myworkout.model.entity.ExerciseEquipment;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ExerciseEquipmentDao {

  @Insert
  Single<Long> insert(ExerciseEquipment exerciseEquipment);

  @Insert
  Single<List<Long>> insert(ExerciseEquipment... exerciseEquipments);

  @Insert
  Single<List<Long>> insert(Collection<ExerciseEquipment> exerciseEquipments);

  @Update
  Single<Integer> update(ExerciseEquipment exerciseEquipment);

  @Update
  Single<Integer> update(ExerciseEquipment... exerciseEquipments);

  @Update
  Single<Integer> update(Collection<ExerciseEquipment> exerciseEquipments);

  @Delete
  Single<Integer> delete(ExerciseEquipment exerciseEquipment);

  @Delete
  Single<Integer> delete(ExerciseEquipment... exerciseEquipments);

  @Delete
  Single<Integer> delete(Collection<ExerciseEquipment> exerciseEquipments);


  @Query("SELECT * FROM ExerciseEquipment WHERE exercise_equipment_id = :id")
  LiveData<ExerciseEquipment> select(long id);
}
