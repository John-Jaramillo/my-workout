package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import io.reactivex.annotations.NonNull;
import java.util.Date;

@Entity
public class Weight {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "weight_id")
  private long Id;

  // TODO Many to One
  //  Foreign Key

  private float weight;

  @NonNull
  private Date date;

}
