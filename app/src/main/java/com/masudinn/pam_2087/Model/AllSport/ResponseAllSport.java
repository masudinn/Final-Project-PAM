package com.masudinn.pam_2087.Model.AllSport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResponseAllSport {

    @SerializedName("sports")
    @Expose
    private List<DataAllSport> sports = null;

    public List<DataAllSport> getAllSports() {
        return sports;
    }
}
