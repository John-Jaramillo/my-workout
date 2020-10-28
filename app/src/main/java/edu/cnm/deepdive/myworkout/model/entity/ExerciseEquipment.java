package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ExerciseEquipment {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "exercise_equipment_id")
  private long Id;

  // TODO ManyToOne
  // TODO 2nd ManyToOne
}
