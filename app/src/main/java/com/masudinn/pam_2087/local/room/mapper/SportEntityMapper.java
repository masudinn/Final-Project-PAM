package com.masudinn.pam_2087.local.room.mapper;

import com.masudinn.pam_2087.Model.AllSport.DataAllSport;
import com.masudinn.pam_2087.Model.Favorite.DataFavorite;
import com.masudinn.pam_2087.local.room.models.DataFavoriteEntity;
import com.masudinn.pam_2087.local.room.models.SportEntity;

import java.util.ArrayList;
import java.util.List;

public class SportEntityMapper {

    public static SportEntity toEntity(DataAllSport allSport){
        return new SportEntity(
                allSport.getIdSport(),
                allSport.getStrSport(),
                allSport.getStrFormat(),
                allSport.getStrSportThumb(),
                allSport.getStrSportThumbGreen(),
                allSport.getStrSportDescription()
        );
    }

    public static DataAllSport fromEntity(SportEntity allSport){
        return new DataAllSport(
                allSport.getIdSport(),
                allSport.getStrSport(),
                allSport.getStrFormat(),
                allSport.getStrSportThumb(),
                allSport.getStrSportThumbGreen(),
                allSport.getStrSportDescription()
        );
    }

    public static List<DataAllSport> fromEntityList(List<SportEntity> entityList) {
        List<DataAllSport> favorites = new ArrayList<>();
        for (SportEntity entity : entityList){
            favorites.add(fromEntity(entity));
        }
        
        return favorites;
    }
}
