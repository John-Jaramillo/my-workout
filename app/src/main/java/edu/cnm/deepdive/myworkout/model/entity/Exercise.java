package edu.cnm.deepdive.myworkout.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exercise {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "exercise_id")
  private long Id;

  @NonNull
  private String name;

  @NonNull
  private ExerciseType exerciseType;

  @NonNull
  private String description;


  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public ExerciseType getExerciseType() {
    return exerciseType;
  }

  public void setExerciseType(@NonNull ExerciseType exerciseType) {
    this.exerciseType = exerciseType;
  }

  @NonNull
  public String getDescription() {
    return description;
  }

  public void setDescription(@NonNull String description) {
    this.description = description;
  }

  private enum ExerciseType {
    AEROBIC, STRENGTH
  }
}
