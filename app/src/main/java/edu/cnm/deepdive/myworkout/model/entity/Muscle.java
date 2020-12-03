package edu.cnm.deepdive.myworkout.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
public class Muscle {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "muscle_id")
  private long id;

  @NonNull
  @Expose
  private String name;

  @NonNull
  @Expose
  @ColumnInfo(index = true)
  private Area area;

  @Expose
  private boolean front;

  @Expose
  private String drawable;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public boolean isFront() {
    return front;
  }

  public void setFront(boolean front) {
    this.front = front;
  }

  public String getDrawable() {
    return drawable;
  }

  public void setDrawable(String drawable) {
    this.drawable = drawable;
  }

  @NonNull
  @Override
  public String toString() {
    return name;
  }

  public enum Area {
    @SerializedName("Chest")
    CHEST,
    @SerializedName("Back")
    BACK,
    @SerializedName("Abs")
    ABS,
    @SerializedName("Shoulders")
    SHOULDERS,
    @SerializedName("Arms")
    ARMS,
    @SerializedName("Lower Body")
    LOWER_BODY;



    @TypeConverter
    public static Integer areaToInteger(Area value) {
      return (value != null) ? value.ordinal() : null;
    }

    @TypeConverter
    public static Area integerToArea(Integer value) {
      return (value != null) ? Area.values()[value] : null;
    }

    @NonNull
    @Override
    public String toString() {
      return Arrays.stream(name().toLowerCase().split("_"))
          .map(String::toCharArray)
          .peek((chars) -> chars[0] = Character.toUpperCase(chars[0]))
          .map(String::new)
          .collect(Collectors.joining(" "));
    }
  }
  
}
