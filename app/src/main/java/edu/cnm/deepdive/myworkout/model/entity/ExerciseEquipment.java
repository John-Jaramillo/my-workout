package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = {
        @Index(value = {"exercise_id", "equipment_id"}, unique = true)
    },
    foreignKeys = {
        @ForeignKey(entity = Exercise.class, parentColumns = {"exercise_id"}, childColumns = {"exercise_id"},
            onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Equipment.class, parentColumns = {"equipment_id"}, childColumns = {"equipment_id"},
            onDelete = ForeignKey.CASCADE)
    }
)
public class ExerciseEquipment {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "exercise_equipment_id")
  private long Id;

  @ColumnInfo(name = "exercise_id", index = true)
  private long exerciseId;

  @ColumnInfo(name = "equipment_id", index = true)
  private long equipmentId;


  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  public long getExerciseId() {
    return exerciseId;
  }

  public void setExerciseId(long exerciseId) {
    this.exerciseId = exerciseId;
  }

  public long getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(long equipmentId) {
    this.equipmentId = equipmentId;
  }
}
