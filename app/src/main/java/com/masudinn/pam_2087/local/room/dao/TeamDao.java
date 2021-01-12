package com.masudinn.pam_2087.local.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.masudinn.pam_2087.local.room.models.DataFavoriteEntity;

import java.util.List;

@Dao
public interface TeamDao {

    @Query("Select * From DataFavoriteEntity")
    public List<DataFavoriteEntity> getAllFavorite();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertFavorite(DataFavoriteEntity favoriteEntity);

    @Delete
    public void deleteFavorite(DataFavoriteEntity favoriteEntity);

}
