package edu.cnm.deepdive.myworkout.model.entity;

import io.reactivex.annotations.NonNull;
import java.util.UUID;

public class Exercise {

  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "exercise_id", nullable = false, updatable = false,
      columnDefinition = "CHAR(16) FOR BIT DATA")
  private UUID id;

  @NonNull
  private String name;

  @NonNull
  private Type type;

  @NonNull
  private String description;


  private enum Type {
    AEROBIC, STRENGTH
  }
}
