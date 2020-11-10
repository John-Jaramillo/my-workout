package edu.cnm.deepdive.myworkout.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

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
  private long id;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @ColumnInfo(name = "exercise_id", index = true)
  private long exerciseId;

  @NonNull
  private Day day;

  private int order;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
  public Day getDay() {
    return day;
  }

  public void setDay(@NonNull Day day) {
    this.day = day;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }


  public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    @TypeConverter
    public static Integer dayToInteger(Day value) {
      return (value != null) ? value.ordinal() : null;
    }

    @TypeConverter
    public static Day integerToDay(Integer value) {
      return (value != null) ? Day.values()[value] : null;
    }
  }
}
