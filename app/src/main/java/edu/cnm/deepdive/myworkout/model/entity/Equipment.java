package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import io.reactivex.annotations.NonNull;

@Entity
public class Equipment {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "equipment_id")
  private long Id;

  @NonNull
  private String name;

}
