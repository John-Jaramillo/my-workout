package edu.cnm.deepdive.myworkout.model.entity;

import io.reactivex.annotations.NonNull;
import java.util.Date;
import java.util.UUID;

public class Weight {

  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "weight_id", nullable = false, updatable = false,
      columnDefinition = "CHAR(16) FOR BIT DATA")
  private UUID id;

  // TODO Many to One

  @NonNull
  private float weight;

  @NonNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date date;

}
