package edu.cnm.deepdive.myworkout.model.entity;

import io.reactivex.annotations.NonNull;
import java.util.UUID;

public class ExerciseEquipment {

  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "exercise_equipment_id", nullable = false, updatable = false,
      columnDefinition = "CHAR(16) FOR BIT DATA")
  private UUID id;


}
