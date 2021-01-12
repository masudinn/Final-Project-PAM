package com.masudinn.pam_2087.Ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.masudinn.pam_2087.Adapter.AdapterSports;
import com.masudinn.pam_2087.Api.Client;
import com.masudinn.pam_2087.Api.Server;
import com.masudinn.pam_2087.Db.ScheduleContract;
import com.masudinn.pam_2087.Model.AllSport.DataAllSport;
import com.masudinn.pam_2087.Model.AllTeam.DataTeamsItem;
import com.masudinn.pam_2087.Model.AllTeam.ResponseAllTeam;
import com.masudinn.pam_2087.Model.Favorite.DataFavorite;
import com.masudinn.pam_2087.R;
import com.masudinn.pam_2087.local.room.AppDatabase;
import com.masudinn.pam_2087.local.room.dao.FavoriteDao;
import com.masudinn.pam_2087.local.room.dao.SportDao;
import com.masudinn.pam_2087.local.room.mapper.DataFavoriteEntityMapper;
import com.masudinn.pam_2087.local.room.mapper.SportEntityMapper;
import com.masudinn.pam_2087.local.room.models.DataFavoriteEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;


public class FavoriteFragment extends Fragment {

    private static final String TAG = "FavoriteFragment";

    View rootView;
    RecyclerView recyclerViewFav;
    Server server;
    AdapterSports adapterSports;
    Call<ResponseAllTeam>  responseAllTeamCall;
    Call<DataTeamsItem> dataTeamsItemCall;
    List<DataTeamsItem> dataTeamsItemList;
    DataTeamsItem dataTeamsItem;
    private AppDatabase roomDatabase;
    private FavoriteDao favoriteDao;
    private SportDao sportDao;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        roomDatabase = AppDatabase.newInstance(requireContext());
        favoriteDao = roomDatabase.getFavoriteDao();
        sportDao = roomDatabase.getSportDao();

        adapterSports = new AdapterSports(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_favorite, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewFav = view.findViewById(R.id.recyclerview_fav);
        
        setupRecyclerView();
        getFavFromRoom();
    }

    private void setupRecyclerView() {
        recyclerViewFav.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false));
        recyclerViewFav.setHasFixedSize(true);
        recyclerViewFav.setAdapter(adapterSports);
    }

    private void getFavData() {
        ArrayList<DataFavorite> dataFavorites = null;
//        for(DataFavorite df : dataFavorites){
//        }
    }

    private void getFavFromRoom(){
        List<DataAllSport> favorites = SportEntityMapper.fromEntityList(sportDao.getAllFavorite());
        adapterSports.setDataAllSportList(favorites);
    }
}