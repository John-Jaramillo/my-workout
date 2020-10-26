package edu.cnm.deepdive.myworkout.model.entity;

import io.reactivex.annotations.NonNull;
import java.util.UUID;

public class Muscle {

  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "muscle_id", nullable = false, updatable = false,
      columnDefinition = "CHAR(16) FOR BIT DATA")
  private UUID id;

  @NonNull
  private String name;

  @NonNull
  @Column(nullable = false, updatable = false)
  private MuscleGroup muscleGroup;


  private enum MuscleGroup {
    CHEST, UPPER_BACK, LOWER_BACK, UPPER_ARM, LOWER_ARM, ABS, SHOULDERS,
        NECK, UPPER_LEG, LOWER_LEG
  }

}
