package edu.cnm.deepdive.myworkout.model.entity;

import io.reactivex.annotations.NonNull;
import java.util.UUID;

public class User {

  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "user_id", nullable = false, updatable = false,
      columnDefinition = "CHAR(16) FOR BIT DATA")
  private UUID id;

  @NonNull
  @Column
  private String name;

  @NonNull
  @Column(nullable = false, updatable = false, unique = true)
  private String oauthKey;

  private Long height;
}
