package com.masudinn.pam_2087.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.masudinn.pam_2087.Db.DatabaseHelper;
import com.masudinn.pam_2087.local.room.dao.FavoriteDao;
import com.masudinn.pam_2087.local.room.dao.SportDao;
import com.masudinn.pam_2087.local.room.dao.TeamDao;
import com.masudinn.pam_2087.local.room.models.DataFavoriteEntity;
import com.masudinn.pam_2087.local.room.models.SportEntity;
import com.masudinn.pam_2087.local.room.models.TeamsEntity;

@Database(
        entities = {DataFavoriteEntity.class, SportEntity.class, TeamsEntity.class},
        version = DatabaseHelper.DATABASE_VERSION,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase db;
    public static AppDatabase newInstance(Context context){
        if (db == null){
            db = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    DatabaseHelper.DATABASE_NAME
            )
                    .allowMainThreadQueries()
                    .build();
        }

        return db;
    }

    public abstract FavoriteDao getFavoriteDao();
    public abstract SportDao getSportDao();
    public abstract TeamDao getTeamDao();

}
