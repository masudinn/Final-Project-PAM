package com.masudinn.pam_2087.Ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.masudinn.pam_2087.Adapter.AdapterSports;
import com.masudinn.pam_2087.Api.Client;
import com.masudinn.pam_2087.Model.AllSport.DataAllSport;
import com.masudinn.pam_2087.Model.AllSport.ResponseAllSport;
import com.masudinn.pam_2087.R;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AllSportFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerViewSport;
    //Declate Activity Context
    Context mContext;

    //Declare Object Cars
    ResponseAllSport responseAllSport;
    List<DataAllSport> listAllSport = new ArrayList<>();
    ProgressBar progressBar;

    //Declare Adapter
    private AdapterSports mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_all_sport, container, false);
        getSport();
        initUi();
        setAdapter();
        return rootView;
    }

    private void setAdapter() {
        mAdapter = new AdapterSports(listAllSport);
        recyclerViewSport.setHasFixedSize(true);
        recyclerViewSport.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewSport.setAdapter(mAdapter);
    }

    private void initUi() {
        recyclerViewSport = rootView.findViewById(R.id.recyclerview_lastmatch);
        progressBar = rootView.findViewById(R.id.mainProgressBarAll);
    }

    private void getSport() {
        final Call<ResponseAllSport> res = Client.getApi().getDataSport();
        res.enqueue(new Callback<ResponseAllSport>() {
            @Override
            public void onResponse(Call<ResponseAllSport> call, Response<ResponseAllSport> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    responseAllSport = response.body();
                    listAllSport.clear();
                    listAllSport.addAll(responseAllSport.getAllSports());
                    mAdapter.notifyDataSetChanged();

                } else {
                    Toasty.error(mContext, "error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAllSport> call, Throwable t) {
                Toasty.error(mContext, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}