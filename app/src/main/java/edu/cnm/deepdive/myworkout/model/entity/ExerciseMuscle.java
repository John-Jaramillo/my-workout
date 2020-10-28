package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ExerciseMuscle {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "exercise_muscle_id")
  private long Id;

  // TODO ManyToOne
  // TODO 2nd ManyToOne

}