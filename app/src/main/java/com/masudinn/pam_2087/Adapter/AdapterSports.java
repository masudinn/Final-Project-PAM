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
import com.masudinn.pam_2087.R;
import com.masudinn.pam_2087.Ui.DetailMainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterSports extends RecyclerView.Adapter<AdapterSports.ViewHolder> {

    private List<DataAllSport> dataAllSportList;
    private Context mContext;
    DataAllSport dataAllSport;
    private View mView;

    public AdapterSports(List<DataAllSport> dataAllSportList) {
        this.dataAllSportList = dataAllSportList;
    }

    public AdapterSports(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterSports.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSports.ViewHolder holder, int position) {
        holder.bindItem(dataAllSportList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataAllSportList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tittle;
        private TextView desc;
        private ImageView img_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tittle = itemView.findViewById(R.id.title_item);
            desc = itemView.findViewById(R.id.desc_item);
            img_item = itemView.findViewById(R.id.img_item);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Gson gson = new Gson();
                    String camera = gson.toJson(dataAllSportList.get(getAdapterPosition()));
                    Intent i=new Intent(v.getContext(), DetailMainActivity.class);
                    i.putExtra("sport", camera);
                    v.getContext().startActivity(i);
                }
            });
        }

        public void bindItem(DataAllSport dataAllSport) {
            tittle.setText(dataAllSport.getStrSport());
            desc.setText(dataAllSport.getStrFormat());
            Picasso.get().load(dataAllSport.getStrSportThumb()).placeholder(R.drawable.ic_baseline_loop_24).into(img_item);
        }
    }
}
