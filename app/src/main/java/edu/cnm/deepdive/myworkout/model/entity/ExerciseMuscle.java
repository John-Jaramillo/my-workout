package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = {
        @Index(value = {"exercise_id", "muscle_id"}, unique = true)
    },
    foreignKeys = {
        @ForeignKey(entity = User.class, parentColumns = {"exercise_id"}, childColumns = {"exercise_id"},
            onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Exercise.class, parentColumns = {"muscle_id"}, childColumns = {"muscle_id"},
            onDelete = ForeignKey.CASCADE)
    }
)
public class ExerciseMuscle {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "exercise_muscle_id")
  private long Id;

  @ColumnInfo(name = "exercise_id", index = true)
  private long exerciseId;

  @ColumnInfo(name = "muscle_id", index = true)
  private long muscleId;

  private boolean primary;

}