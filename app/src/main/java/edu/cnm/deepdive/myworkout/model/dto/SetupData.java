package edu.cnm.deepdive.myworkout.model.dto;

import com.google.gson.annotations.Expose;
import edu.cnm.deepdive.myworkout.model.entity.Exercise;
import edu.cnm.deepdive.myworkout.model.entity.Muscle;
import java.util.List;

public class SetupData {

  @Expose
  private List<Muscle> muscles;

  @Expose
  private List<Exercise> exercises;

  public List<Muscle> getMuscles() {
    return muscles;
  }

  public void setMuscles(List<Muscle> muscles) {
    this.muscles = muscles;
  }

  public List<Exercise> getExercises() {
    return exercises;
  }

  public void setExercises(List<Exercise> exercises) {
    this.exercises = exercises;
  }
}
