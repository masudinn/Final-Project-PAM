package com.masudinn.pam_2087.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.masudinn.pam_2087.Model.AllSport.DataAllSport;
import com.masudinn.pam_2087.Model.AllTeam.DataTeamsItem;
import com.masudinn.pam_2087.R;
import com.masudinn.pam_2087.Ui.DetailAllTeamActivity;
import com.masudinn.pam_2087.Ui.DetailMainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterAllTeam extends RecyclerView.Adapter<AdapterAllTeam.ViewHolder> {

    private List<DataTeamsItem> dataAllTeamList;
    private Context mContext;
    DataTeamsItem dataTeamsItem;
    private View mView;

    public AdapterAllTeam(List<DataTeamsItem> dataAllTeamList) {
        this.dataAllTeamList = dataAllTeamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_team, parent, false);
        return new AdapterAllTeam.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindItem(dataAllTeamList.get(position));

    }

    @Override
    public int getItemCount() {
        return dataAllTeamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTeam,tvLocation,tvweb;
        private ImageView imgTeam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeam = itemView.findViewById(R.id.team_item);
            tvLocation = itemView.findViewById(R.id.team_country_item);
            tvweb = itemView.findViewById(R.id.team_web_item);
            imgTeam = itemView.findViewById(R.id.imgteam_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Gson gson = new Gson();
                    String camera = gson.toJson(dataAllTeamList.get(getAdapterPosition()));
                    Intent i=new Intent(v.getContext(), DetailAllTeamActivity.class);
                    i.putExtra("allteam", camera);
                    v.getContext().startActivity(i);
                }
            });
        }

        public void bindItem(DataTeamsItem dataTeamsItem) {
            tvTeam.setText(dataTeamsItem.getStrTeam());
            tvLocation.setText(dataTeamsItem.getStrStadiumLocation());
            tvweb.setText(dataTeamsItem.getStrWebsite());
            Picasso.get().load(dataTeamsItem.getStrTeamBadge()).placeholder(R.drawable.ic_baseline_loop_24).into(imgTeam);

        }
    }
}
