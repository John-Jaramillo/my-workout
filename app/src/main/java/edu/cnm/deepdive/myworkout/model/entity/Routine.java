package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(entity = User.class, parentColumns = {"user_id"}, childColumns = {"user_id"},
            onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Exercise.class, parentColumns = {"exercise_id"}, childColumns = {"exercise_id"},
            onDelete = ForeignKey.CASCADE)
    }
)
public class Routine {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "routine_id")
  private long Id;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @ColumnInfo(name = "exercise_id", index = true)
  private long exerciseId;

  private Day day;

  private int order;


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

  public Day getDay() {
    return day;
  }

  public void setDay(Day day) {
    this.day = day;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }


  private enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
  }
}
