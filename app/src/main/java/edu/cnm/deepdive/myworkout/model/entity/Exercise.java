package edu.cnm.deepdive.myworkout.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

@Entity
public class Exercise {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "exercise_id")
  private long id;

  @NonNull
  @Expose
  private String name;

  @NonNull
  @Expose
  private String description;

  @Expose
  @SerializedName("primary muscles")
  @Ignore
  private List<String> primaryMuscles;

  @Expose
  @SerializedName("secondary muscles")
  @Ignore
  private List<String> secondaryMuscles;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public String getDescription() {
    return description;
  }

  public void setDescription(@NonNull String description) {
    this.description = description;
  }

  public List<String> getPrimaryMuscles() {
    return primaryMuscles;
  }

  public void setPrimaryMuscles(List<String> primaryMuscles) {
    this.primaryMuscles = primaryMuscles;
  }

  public List<String> getSecondaryMuscles() {
    return secondaryMuscles;
  }

  public void setSecondaryMuscles(List<String> secondaryMuscles) {
    this.secondaryMuscles = secondaryMuscles;
  }

  @NonNull
  @Override
  public String toString() {
    return name;
  }
}
