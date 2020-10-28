package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Routine {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "routine_id")
  private long Id;

}
