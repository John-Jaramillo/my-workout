package edu.cnm.deepdive.myworkout.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    foreignKeys = {
        @ForeignKey(entity = User.class, parentColumns = {"user_id"}, childColumns = {"user_id"},
            onDelete = ForeignKey.CASCADE)
    }
)
public class Weight {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "weight_id")
  private long Id;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  private float weight;

  @NonNull
  private Date date;


  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }
}
