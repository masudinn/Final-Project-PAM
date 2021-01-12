package com.masudinn.pam_2087.local.room.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SportEntity {

    @PrimaryKey
    @NonNull
    private String idSport;

    private String strSport;

    private String strFormat;

    private String strSportThumb;

    private String strSportThumbGreen;

    private String strSportDescription;

    public SportEntity(@NonNull String idSport, String strSport, String strFormat, String strSportThumb, String strSportThumbGreen, String strSportDescription) {
        this.idSport = idSport;
        this.strSport = strSport;
        this.strFormat = strFormat;
        this.strSportThumb = strSportThumb;
        this.strSportThumbGreen = strSportThumbGreen;
        this.strSportDescription = strSportDescription;
    }

    @NonNull
    public String getIdSport() {
        return idSport;
    }

    public void setIdSport(String idSport) {
        this.idSport = idSport;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrFormat() {
        return strFormat;
    }

    public void setStrFormat(String strFormat) {
        this.strFormat = strFormat;
    }

    public String getStrSportThumb() {
        return strSportThumb;
    }

    public void setStrSportThumb(String strSportThumb) {
        this.strSportThumb = strSportThumb;
    }

    public String getStrSportThumbGreen() {
        return strSportThumbGreen;
    }

    public void setStrSportThumbGreen(String strSportThumbGreen) {
        this.strSportThumbGreen = strSportThumbGreen;
    }

    public String getStrSportDescription() {
        return strSportDescription;
    }

    public void setStrSportDescription(String strSportDescription) {
        this.strSportDescription = strSportDescription;
    }
}
