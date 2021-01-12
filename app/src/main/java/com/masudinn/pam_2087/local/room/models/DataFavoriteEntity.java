package com.masudinn.pam_2087.local.room.models;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.masudinn.pam_2087.Db.ScheduleContract.ScheduleColumns.Schedule_ID;
import static com.masudinn.pam_2087.Db.ScheduleContract.ScheduleColumns.Schedule_IMAGE;
import static com.masudinn.pam_2087.Db.ScheduleContract.ScheduleColumns.Schedule_TITLE;
import static com.masudinn.pam_2087.Db.ScheduleContract.getColumnString;

@Entity
public class DataFavoriteEntity {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String id = "";

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "desc")
    private String desc;

    @ColumnInfo(name = "category")
    private String category;

    public DataFavoriteEntity(@NonNull String id, String title, String image, String desc, String category) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.desc = desc;
        this.category = category;
    }

    public DataFavoriteEntity() {
    }

    public DataFavoriteEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public DataFavoriteEntity(Cursor cursor) {
        this.id = getColumnString(cursor,Schedule_ID);
        this.title = getColumnString(cursor, Schedule_TITLE);
        this.image = getColumnString(cursor, Schedule_IMAGE);
    }


}
