package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(entity = Exercise.class, parentColumns = {"exercise_id"}, childColumns = {"exercise_id"},
            onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Muscle.class, parentColumns = {"muscle_id"}, childColumns = {"muscle_id"},
            onDelete = ForeignKey.CASCADE)
    }
)
public class ExerciseMuscle {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "exercise_muscle_id")
  private long id;

  @ColumnInfo(name = "exercise_id", index = true)
  private long exerciseId;

  @ColumnInfo(name = "muscle_id", index = true)
  private long muscleId;

  private boolean primary;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getExerciseId() {
    return exerciseId;
  }

  public void setExerciseId(long exerciseId) {
    this.exerciseId = exerciseId;
  }

  public long getMuscleId() {
    return muscleId;
  }

  public void setMuscleId(long muscleId) {
    this.muscleId = muscleId;
  }

  public boolean isPrimary() {
    return primary;
  }

  public void setPrimary(boolean primary) {
    this.primary = primary;
  }
}