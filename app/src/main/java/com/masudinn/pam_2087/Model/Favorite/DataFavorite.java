package com.masudinn.pam_2087.Model.Favorite;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import static com.masudinn.pam_2087.Db.ScheduleContract.ScheduleColumns.Schedule_ID;
import static com.masudinn.pam_2087.Db.ScheduleContract.ScheduleColumns.Schedule_IMAGE;
import static com.masudinn.pam_2087.Db.ScheduleContract.ScheduleColumns.Schedule_TITLE;
import static com.masudinn.pam_2087.Db.ScheduleContract.getColumnString;

public class DataFavorite implements Parcelable {
    private String id;
    private String title;
    private String image;
    private String desc;
    private String category;

    public DataFavorite(String id, String title, String image, String desc, String category) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.desc = desc;
        this.category = category;
    }

    public DataFavorite(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    protected DataFavorite(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.image = in.readString();
        this.desc = in.readString();
        this.category = in.readString();
    }

    public static final Creator<DataFavorite> CREATOR = new Creator<DataFavorite>() {
        @Override
        public DataFavorite createFromParcel(Parcel in) {
            return new DataFavorite(in);
        }

        @Override
        public DataFavorite[] newArray(int size) {
            return new DataFavorite[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.image);
        dest.writeString(this.desc);
        dest.writeString(this.category);

    }

    public DataFavorite (Cursor cursor) {
        this.id = getColumnString(cursor,Schedule_ID);
        this.title = getColumnString(cursor, Schedule_TITLE);
        this.image = getColumnString(cursor, Schedule_IMAGE);
    }


}
