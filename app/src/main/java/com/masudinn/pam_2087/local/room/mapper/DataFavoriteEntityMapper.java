package com.masudinn.pam_2087.local.room.mapper;

import com.masudinn.pam_2087.Model.Favorite.DataFavorite;
import com.masudinn.pam_2087.local.room.models.DataFavoriteEntity;

import java.util.ArrayList;
import java.util.List;

public class DataFavoriteEntityMapper {

    public static DataFavoriteEntity toEntity(DataFavorite favorite){
        return new DataFavoriteEntity(
                favorite.getId(),
                favorite.getTitle(),
                favorite.getImage(),
                favorite.getDesc(),
                favorite.getCategory()
        );
    }

    public static DataFavorite fromEntity(DataFavoriteEntity favorite){
        return new DataFavorite(
                favorite.getId(),
                favorite.getTitle(),
                favorite.getImage(),
                favorite.getDesc(),
                favorite.getCategory()
        );
    }

    public static List<DataFavorite> fromEntityList(List<DataFavoriteEntity> entityList) {
        List<DataFavorite> favorites = new ArrayList<>();
        for (DataFavoriteEntity entity : entityList){
            favorites.add(fromEntity(entity));
        }
        
        return favorites;
    }
}
