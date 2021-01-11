package com.masudinn.pam_2087.Db;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import static com.masudinn.pam_2087.Db.ScheduleContract.ScheduleColumns.TABLE_Schedule;

public class ScheduleContract {

    public static final class ScheduleColumns implements BaseColumns {

        public static final String TABLE_Schedule = "tb_schedule";
        public static String Schedule_ID = "schedule_id";
        public static String Schedule_TITLE = "title";
        public static String Schedule_IMAGE = "image";
    }
        public static final String AUTHORITY = "com.masudinn.pam_2087";

        public static final Uri CONTENT_URI = new Uri.Builder().scheme("content")
                .authority(AUTHORITY)
                .appendPath(TABLE_Schedule)
                .build();

        public static String getColumnString(Cursor cursor, String columnName) {
            return cursor.getString(cursor.getColumnIndex(columnName));
        }

        public static int getColumnInt(Cursor cursor, String columnName) {
            return cursor.getInt(cursor.getColumnIndex(columnName));
        }

        public static long getColumnLong(Cursor cursor, String columnName) {
            return cursor.getLong(cursor.getColumnIndex(columnName));
        }
    }

