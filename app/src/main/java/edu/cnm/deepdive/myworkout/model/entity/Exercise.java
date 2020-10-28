package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import io.reactivex.annotations.NonNull;

@Entity
public class Exercise {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "exercise_id")
  private long Id;

  @NonNull
  private String name;

  @NonNull
  private Type type;

  @NonNull
  private String description;


  private enum Type {
    AEROBIC, STRENGTH
  }
}
