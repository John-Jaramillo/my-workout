package edu.cnm.deepdive.myworkout.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.myworkout.model.entity.Equipment;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface EquipmentDao {

  @Insert
  Single<Long> insert(Equipment equipment);

  @Insert
  Single<List<Long>> insert(Equipment... equipments);

  @Insert
  Single<List<Long>> insert(Collection<Equipment> equipments);

  @Update
  Single<Integer> update(Equipment equipment);

  @Update
  Single<Integer> update(Equipment... equipments);

  @Update
  Single<Integer> update(Collection<Equipment> equipments);

  @Delete
  Single<Integer> delete(Equipment equipment);

  @Delete
  Single<Integer> delete(Equipment... equipments);

  @Delete
  Single<Integer> delete(Collection<Equipment> equipments);


  @Query("SELECT * FROM Equipment WHERE equipment_id = :id")
  LiveData<Equipment> select(long id);
}
