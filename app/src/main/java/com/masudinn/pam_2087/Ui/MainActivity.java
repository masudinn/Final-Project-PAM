package com.masudinn.pam_2087.Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.masudinn.pam_2087.Db.ScheduleContract;
import com.masudinn.pam_2087.Model.Favorite.DataFavorite;
import com.masudinn.pam_2087.R;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new AllSportFragment());// inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);// beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.item_all_sport:
                Toasty.info(this, "All Sports", Toast.LENGTH_SHORT, true).show();
                fragment = new AllSportFragment();
                break;

            case R.id.allTeam:
                Toasty.info(this, "All Team", Toast.LENGTH_SHORT, true).show();
                fragment = new AllTeamFragment();
                break;

            case R.id.item_fav:
                Toasty.info(this, "Favorite", Toast.LENGTH_SHORT, true).show();
                fragment = new FavoriteFragment();
                DataFavorite dataFavorite;
                Cursor cursor = null;
                ArrayList<DataFavorite> scheduleFavoriteArrayList = new ArrayList<>();
                do{
                    dataFavorite = new DataFavorite(cursor.getString(cursor.getColumnIndexOrThrow(
                            ScheduleContract.ScheduleColumns.Schedule_ID)));
                    scheduleFavoriteArrayList.add(dataFavorite);
                    cursor.moveToNext();
                } while (!cursor.isAfterLast());
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}