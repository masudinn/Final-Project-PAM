package com.masudinn.pam_2087.local.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.masudinn.pam_2087.local.room.models.DataFavoriteEntity;
import com.masudinn.pam_2087.local.room.models.SportEntity;

import java.util.List;

@Dao
public interface SportDao {

    @Query("Select * From SportEntity")
    public List<SportEntity> getAllFavorite();

    @Query("Select * From SportEntity where idSport = :id")
    SportEntity getSport(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertFavorite(SportEntity favoriteEntity);

    @Delete
    public void deleteFavorite(SportEntity favoriteEntity);
}
