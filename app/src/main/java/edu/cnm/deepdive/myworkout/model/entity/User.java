package edu.cnm.deepdive.myworkout.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long Id;

  @NonNull
  private String name;

  @NonNull
  @ColumnInfo(name = "oauth_key")
  private String oauthKey;

  @NonNull
  private Long height;


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
  public String getOauthKey() {
    return oauthKey;
  }

  public void setOauthKey(@NonNull String oauthKey) {
    this.oauthKey = oauthKey;
  }

  @NonNull
  public Long getHeight() {
    return height;
  }

  public void setHeight(@NonNull Long height) {
    this.height = height;
  }
}