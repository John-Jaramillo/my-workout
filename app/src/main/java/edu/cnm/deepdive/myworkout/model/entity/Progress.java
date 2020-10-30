package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import io.reactivex.annotations.NonNull;
import java.util.Date;

@Entity(
    indices = {
        @Index(value = {"date"}, unique = true)
    },
    foreignKeys = {
        @ForeignKey(entity = User.class, parentColumns = {"user_id"}, childColumns = {"user_id"},
            onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Exercise.class, parentColumns = {"exercise_id"}, childColumns = {"exercise_id"},
            onDelete = ForeignKey.CASCADE)
    }
)
public class Progress {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "progress_id")
  private long Id;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @ColumnInfo(name = "exercise_id", index = true)
  private long exerciseId;

  @NonNull
  private Date date;

  private Integer duration;

  private Float distance;

  private Integer heartrate;

  private Integer sets;

  private Integer repititions;

  private Long weight;


  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getExerciseId() {
    return exerciseId;
  }

  public void setExerciseId(long exerciseId) {
    this.exerciseId = exerciseId;
  }

  @NonNull
  public Date getDate() {
    return date;
  }

  public void setDate(@NonNull Date date) {
    this.date = date;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Float getDistance() {
    return distance;
  }

  public void setDistance(Float distance) {
    this.distance = distance;
  }

  public Integer getHeartrate() {
    return heartrate;
  }

  public void setHeartrate(Integer heartrate) {
    this.heartrate = heartrate;
  }

  public Integer getSets() {
    return sets;
  }

  public void setSets(Integer sets) {
    this.sets = sets;
  }

  public Integer getRepititions() {
    return repititions;
  }

  public void setRepititions(Integer repititions) {
    this.repititions = repititions;
  }

  public Long getWeight() {
    return weight;
  }

  public void setWeight(Long weight) {
    this.weight = weight;
  }
}
