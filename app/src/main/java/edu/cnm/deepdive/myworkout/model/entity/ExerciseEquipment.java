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
        @ForeignKey(entity = User.class, parentColumns = {"exercise_id"}, childColumns = {"exercise_id"},
            onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Exercise.class, parentColumns = {"equipment_id"}, childColumns = {"equipment_id"},
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
}
