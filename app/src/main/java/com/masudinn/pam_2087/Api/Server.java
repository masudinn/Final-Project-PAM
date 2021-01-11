package com.masudinn.pam_2087.Api;

import com.masudinn.pam_2087.Model.AllSport.ResponseAllSport;
import com.masudinn.pam_2087.Model.AllTeam.ResponseAllTeam;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Server {

    @GET("all_sports.php")
    Call<ResponseAllSport> getDataSport();

    @GET("search_all_teams.php?l=English Premier League")
    Call<ResponseAllTeam> getTeam();
}
