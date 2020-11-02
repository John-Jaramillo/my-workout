package edu.cnm.deepdive.myworkout.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import edu.cnm.deepdive.myworkout.model.entity.Exercise.ExerciseType;

@Entity
public class Muscle {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "muscle_id")
  private long Id;

  @NonNull
  private String name;

  @NonNull
  @ColumnInfo(index = true)
  private Area area;


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
  public Area getArea() {
    return area;
  }

  public void setArea(@NonNull Area area) {
    this.area = area;
  }

  public enum Area {
    CHEST, UPPER_BACK, LOWER_BACK, UPPER_ARM, LOWER_ARM, ABS, SHOULDERS,
        NECK, UPPER_LEG, LOWER_LEG;

    @TypeConverter
    public static Integer areaToInteger(Area value) {
      return (value != null) ? value.ordinal() : null;
    }

    @TypeConverter
    public static Area integerToArea(Integer value) {
      return (value != null) ? Area.values()[value] : null;
    }
  }
  
}
