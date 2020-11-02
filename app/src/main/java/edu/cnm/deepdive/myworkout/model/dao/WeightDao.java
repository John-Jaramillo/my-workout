package edu.cnm.deepdive.myworkout.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.myworkout.model.entity.Weight;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface WeightDao {

  @Insert
  Single<Long> insert(Weight weight);

  @Insert
  Single<List<Long>> insert(Weight... weights);

  @Insert
  Single<List<Long>> insert(Collection<Weight> weights);

  @Delete
  Single<Integer> delete(Weight weight);

  @Delete
  Single<Integer> delete(Weight... weights);

  @Delete
  Single<Integer> delete(Collection<Weight> weights);

  @Query("SELECT * FROM Weight WHERE weight_id = :id")
  LiveData<Weight> select(long id);
}
