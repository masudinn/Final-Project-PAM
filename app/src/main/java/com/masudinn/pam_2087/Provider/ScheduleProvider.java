package com.masudinn.pam_2087.Provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.masudinn.pam_2087.Db.ScheduleContract;
import com.masudinn.pam_2087.Db.ScheduleHelper;

import java.util.Objects;

import static com.masudinn.pam_2087.Db.ScheduleContract.AUTHORITY;
import static com.masudinn.pam_2087.Db.ScheduleContract.CONTENT_URI;

public class ScheduleProvider extends ContentProvider {

    private static final int SCHEDULE = 100;
    private static final int SCHEDULE_ID = 101;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private ScheduleHelper scheduleHelper;

    static {

        sUriMatcher.addURI(AUTHORITY,
                ScheduleContract.ScheduleColumns.TABLE_Schedule, SCHEDULE);

        sUriMatcher.addURI(AUTHORITY,
                ScheduleContract.ScheduleColumns.TABLE_Schedule+ "/#",
                SCHEDULE_ID);
    }
    @Override
    public boolean onCreate() {
        scheduleHelper = new ScheduleHelper(getContext());
//        scheduleHelper.open();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor;
        int match = sUriMatcher.match(uri);
        Log.v("ScheduleDetail", ""+match);
        Log.v("ScheduleDetail", ""+uri);
        Log.v("ScheduleDetail", ""+uri.getLastPathSegment());
        switch(match){
            case SCHEDULE:
                cursor = scheduleHelper.queryProvider();
                break;
            case SCHEDULE_ID:
                cursor = scheduleHelper.queryByIdProvider(uri.getLastPathSegment());
                break;
            default:
                cursor = null;
                break;
        }

        if (cursor != null){
            cursor.setNotificationUri(getContext().getContentResolver(),uri);
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long added ;

        switch (sUriMatcher.match(uri)){
            case SCHEDULE:
                added = scheduleHelper.insertProvider(values);
                break;
            default:
                added = 0;
                break;
        }

        if (added > 0) {
            Objects.requireNonNull(getContext()).getContentResolver().notifyChange(uri, null);
        }
        return Uri.parse(CONTENT_URI + "/" + added);    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int movieDeleted;

        Log.v("ScheduleDetail", ""+uri);
        int match = sUriMatcher.match(uri);
        Log.v("ScheduleDetail", ""+match);
        switch (match) {
            case SCHEDULE_ID:
                movieDeleted =  scheduleHelper.deleteProvider(uri.getLastPathSegment());
                Log.v("ScheduleDetail", ""+movieDeleted);
                break;
            default:
                movieDeleted = 0;
                break;
        }

        if (movieDeleted > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return movieDeleted;    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int movieUpdated ;
        switch (sUriMatcher.match(uri)) {
            case SCHEDULE_ID:
                movieUpdated =  scheduleHelper.updateProvider(uri.getLastPathSegment(),values);
                break;
            default:
                movieUpdated = 0;
                break;
        }

        if (movieUpdated > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return movieUpdated;    }
}
