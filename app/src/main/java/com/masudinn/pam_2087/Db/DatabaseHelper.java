package com.masudinn.pam_2087.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "db_pam2087";

    public static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_MOVIE = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL",
            ScheduleContract.ScheduleColumns.TABLE_Schedule,
            ScheduleContract.ScheduleColumns._ID,
            ScheduleContract.ScheduleColumns.Schedule_ID,
            ScheduleContract.ScheduleColumns.Schedule_IMAGE,
            ScheduleContract.ScheduleColumns.Schedule_TITLE
    );

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_MOVIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ScheduleContract.ScheduleColumns.TABLE_Schedule);
        onCreate(db);
    }
}