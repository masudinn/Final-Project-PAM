package com.masudinn.pam_2087.Ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.masudinn.pam_2087.Adapter.AdapterSports;
import com.masudinn.pam_2087.Api.Client;
import com.masudinn.pam_2087.Api.Server;
import com.masudinn.pam_2087.Db.ScheduleContract;
import com.masudinn.pam_2087.Model.AllTeam.DataTeamsItem;
import com.masudinn.pam_2087.Model.AllTeam.ResponseAllTeam;
import com.masudinn.pam_2087.Model.Favorite.DataFavorite;
import com.masudinn.pam_2087.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;


public class FavoriteFragment extends Fragment {

    View rootView;
    RecyclerView recyclerViewFav;
    Server server;
    AdapterSports adapterSports;
    Call<ResponseAllTeam>  responseAllTeamCall;
    Call<DataTeamsItem> dataTeamsItemCall;
    List<DataTeamsItem> dataTeamsItemList;
    DataTeamsItem dataTeamsItem;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_favorite, container, false);
        getFavData();

        return rootView;
    }

    private void getFavData() {
        recyclerViewFav.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerViewFav.setHasFixedSize(true);
        ArrayList<DataFavorite> dataFavorites = null;
        for(DataFavorite df : dataFavorites){
        }
    }



}