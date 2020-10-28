package edu.cnm.deepdive.myworkout.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import io.reactivex.annotations.NonNull;
import java.util.Date;

@Entity
public class Progress {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "progress_id")
  private long Id;

  // TODO ManyToOne
  // TODO 2nd ManyToOne

  @NonNull
  private Date date;

  private int duration;

  private float distance;

  private int heartrate;

  private int sets;

  private int repititions;

  private long weight;
}
