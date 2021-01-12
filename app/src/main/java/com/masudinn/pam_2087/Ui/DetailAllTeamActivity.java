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
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.masudinn.pam_2087.Db.ScheduleContract;
import com.masudinn.pam_2087.Model.AllSport.DataAllSport;
import com.masudinn.pam_2087.Model.AllTeam.DataTeamsItem;
import com.masudinn.pam_2087.R;
import com.masudinn.pam_2087.local.room.AppDatabase;
import com.masudinn.pam_2087.local.room.dao.FavoriteDao;
import com.masudinn.pam_2087.local.room.models.DataFavoriteEntity;
import com.squareup.picasso.Picasso;

public class DetailAllTeamActivity extends AppCompatActivity {

    private static final String TAG = DetailAllTeamActivity.class.getSimpleName();
    private boolean isFavorite;
    String id, title, image, desc, category;
    private Context context;
    private TextView tvTeam, tvCountry, tvLeague, tvWeb, tvDesTeam;
    private ImageView imgView;
    private Button btn1, btn2;
    private DataTeamsItem dataTeamsItem;
    private Toolbar toolbar;
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "channel_01";
    private static final CharSequence CHANNEL_NAME = "mychannel";
    private AppDatabase roomDatabase;
    private FavoriteDao favoriteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_all_team);

        roomDatabase = AppDatabase.newInstance(getApplicationContext());
        favoriteDao = roomDatabase.getFavoriteDao();
        Gson gson = new Gson();
        dataTeamsItem = gson.fromJson(getIntent().getStringExtra("allteam"), DataTeamsItem.class);

//        if (isFavo(id)) {
//            isFavorite = true;
//            imgbtn1.setVisibility(View.VISIBLE);
//            imgbtn2.setVisibility(View.GONE);
//        }
        startInit();
    }

//    private boolean isFavo(String id) {
//            Uri uri = ScheduleContract.CONTENT_URI.buildUpon().appendPath(id).build();
//            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
//            return cursor.moveToFirst();
//
//    }

    private void startInit() {
        initUi();
        initEvent();
        initToolbar();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbardetailteam);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(dataTeamsItem.getStrTeam());
    }

    private void initEvent() {
        tvTeam.setText(dataTeamsItem.getStrTeam());
        tvCountry.setText(dataTeamsItem.getStrCountry());
        tvLeague.setText(dataTeamsItem.getStrLeague());
        tvWeb.setText(dataTeamsItem.getStrWebsite());
        tvDesTeam.setText(dataTeamsItem.getStrDescriptionEN());
        Picasso.get().load(dataTeamsItem.getStrTeamBadge()).placeholder(R.drawable.ic_baseline_loop_24).into(imgView);
    }

    private void initUi() {
        tvTeam = findViewById(R.id.title_detailteam);
        tvLeague = findViewById(R.id.league);
        tvCountry = findViewById(R.id.country_team);
        tvWeb = findViewById(R.id.category_webteam);
        tvDesTeam = findViewById(R.id.desc_detailteam);
        imgView = findViewById(R.id.img_detailteam);
        btn1 = findViewById(R.id.btnfav1);
        btn2 = findViewById(R.id.btnfav2);
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


    public void imgbtnclick(View view) {
        if (!isFavorite) {
            isFavorite = true;
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.GONE);
            Snackbar.make(view, "This movie has been add to your favorite", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        } else {
            isFavorite = false;
            btn2.setVisibility(View.VISIBLE);
            btn1.setVisibility(View.GONE);
            Snackbar.make(view, "This movie has been remove from your favorite", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
//        saveInFavorite();
        saveToFavoriteRoom();
    }

    private void saveInFavorite() {
        if (isFavorite) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ScheduleContract.ScheduleColumns.Schedule_ID, id);
            contentValues.put(ScheduleContract.ScheduleColumns.Schedule_TITLE, title);
            contentValues.put(ScheduleContract.ScheduleColumns.Schedule_IMAGE, image);
            Uri uri = getContentResolver().insert(ScheduleContract.CONTENT_URI, contentValues);
            if (uri != null) {
                Log.d(TAG, "Uri " + uri);
            }
        } else {
            Uri uri = ScheduleContract.CONTENT_URI.buildUpon().appendPath(id).build();
            getContentResolver().delete(uri, null, null);
        }
    }

    private void saveToFavoriteRoom() {
        Log.e(TAG, "onClick: Data Teams = " + dataTeamsItem.toString());
        DataFavoriteEntity favorite = new DataFavoriteEntity(
                dataTeamsItem.getIdTeam(),
                dataTeamsItem.getStrSport(),
                dataTeamsItem.getStrTeamBadge(),
                dataTeamsItem.getStrDescriptionEN(),
                dataTeamsItem.getStrTeamShort()
        );
        favoriteDao.insertFavorite(favorite);
    }
}