package com.fti.apipikobar.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.fti.apipikobar.R;
import com.fti.apipikobar.view.fragment.FasilitasKesehatanFragment;
import com.fti.apipikobar.view.fragment.KasusHarianFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new KasusHarianFragment();

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.activitymain_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment){
        if (selectedFragment !=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_fragmentContainer,selectedFragment)
                    .commit();
            return  true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_bottomnav_harian:
                selectedFragment = new KasusHarianFragment();
                break;
            case R.id.menu_bottomnav_faskes:
                selectedFragment = new FasilitasKesehatanFragment();
                break;
        }
        return loadFragment(selectedFragment);
    }
}