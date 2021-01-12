package com.masudinn.pam_2087.Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.masudinn.pam_2087.Model.AllSport.DataAllSport;
import com.masudinn.pam_2087.R;
import com.masudinn.pam_2087.local.room.AppDatabase;
import com.masudinn.pam_2087.local.room.dao.FavoriteDao;
import com.masudinn.pam_2087.local.room.dao.SportDao;
import com.masudinn.pam_2087.local.room.mapper.SportEntityMapper;
import com.masudinn.pam_2087.local.room.models.DataFavoriteEntity;
import com.masudinn.pam_2087.local.room.models.SportEntity;
import com.squareup.picasso.Picasso;

public class DetailMainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "DetailMainActivity";

    private TextView tvTitle, tvCategory, tvdesc;
    private ImageView imgView;
    private DataAllSport dataAllSport;
    private Toolbar toolbar;
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "channel_01";
    private static final CharSequence CHANNEL_NAME = "mychannel";
    private AppDatabase roomDatabase;
    private SportDao sportDao;
    private ImageButton imgFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_main);

        roomDatabase = AppDatabase.newInstance(getApplicationContext());
        sportDao = roomDatabase.getSportDao();
        Gson gson = new Gson();
        dataAllSport = gson.fromJson(getIntent().getStringExtra("sport"), DataAllSport.class);
        startInit();
    }

    private void startInit() {
        initUi();
        initEvent();
        initToolbar();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbardetail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(dataAllSport.getStrSport());
    }

    private void initEvent() {
        imgFav.setOnClickListener(this);
        tvTitle.setText(dataAllSport.getStrSport());
        tvCategory.setText(dataAllSport.getStrFormat());
        tvdesc.setText(dataAllSport.getStrSportDescription());
        Picasso.get().load(dataAllSport.getStrSportThumb()).placeholder(R.drawable.ic_baseline_loop_24).into(imgView);
    }

    private void initUi() {
        tvTitle = findViewById(R.id.title_detail);
        tvdesc = findViewById(R.id.desc_detail);
        tvCategory = findViewById(R.id.category_detail);
        imgView = findViewById(R.id.img_detail);
        imgFav = findViewById(R.id.imgbtn_fav);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notif:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/masudinn/"));
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_baseline_notifications_24))
                        .setContentTitle(getResources().getString(R.string.content_title))
                        .setContentText(getResources().getString(R.string.content_text))
                        .setSubText(getResources().getString(R.string.subtext))
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent);

                Notification notification = mBuilder.build();
                if (mNotificationManager != null) {
                    mNotificationManager.notify(NOTIFICATION_ID, notification);

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
                    channel.setDescription(CHANNEL_NAME.toString());
                    mBuilder.setChannelId(CHANNEL_ID);
                    if (mNotificationManager != null) {
                        mNotificationManager.createNotificationChannel(channel);
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgbtn_fav:
                SportEntity sportEntity = SportEntityMapper.toEntity(dataAllSport);
                SportEntity favorite = sportDao.getSport(sportEntity.getIdSport());
                if(favorite == null) {
                    sportDao.insertFavorite(sportEntity);
                }else {
                    sportDao.deleteFavorite(sportEntity);
                }
                break;

        }
    }

}