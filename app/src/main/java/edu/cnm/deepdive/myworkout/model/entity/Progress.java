package edu.cnm.deepdive.myworkout.model.entity;

import io.reactivex.annotations.NonNull;
import java.util.Date;
import java.util.UUID;

public class Progress {

  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "progress_id", nullable = false, updatable = false,
      columnDefinition = "CHAR(16) FOR BIT DATA")
  private UUID id;

  @NonNull
  private Date date;

  private int duration;

  private float distance;

  private int heartrate;

  private int sets;

  private int repititions;

  private long weight;
}
