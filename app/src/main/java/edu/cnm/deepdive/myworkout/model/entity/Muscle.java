package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import io.reactivex.annotations.NonNull;

@Entity
public class Muscle {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "muscle_id")
  private long Id;

  @NonNull
  private String name;

  @NonNull
  @ColumnInfo(name = "muscle_group")
  private MuscleGroup muscleGroup;


  private enum MuscleGroup {
    CHEST, UPPER_BACK, LOWER_BACK, UPPER_ARM, LOWER_ARM, ABS, SHOULDERS,
        NECK, UPPER_LEG, LOWER_LEG
  }

}
