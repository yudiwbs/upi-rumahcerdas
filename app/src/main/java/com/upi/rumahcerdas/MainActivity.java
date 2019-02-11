package com.upi.rumahcerdas;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExploreFragment.OnFragmentInteractionListener, SearchFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        final TextView actionBarTitle = findViewById(R.id.action_bar_title);
        actionBarTitle.setText(R.string.menu_explore);

        final Fragment fragmentExplore = new ExploreFragment();
        final Fragment fragmentSearch = new SearchFragment();
        final Fragment fragmentProfile = new ProfileFragment();

        /*
         * Menambahkan navigasi utama
         */
        BottomNavigationView mainMenu = findViewById(R.id.main_menu);
        mainMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_explore:
                        loadFragment(fragmentExplore);
                        actionBarTitle.setText(R.string.menu_explore);
                        return true;
                    case R.id.menu_search:
                        loadFragment(fragmentSearch);
                        actionBarTitle.setText(R.string.menu_search);
                        return true;
                    case R.id.menu_profile:
                        loadFragment(fragmentProfile);
                        actionBarTitle.setText(R.string.menu_profile);
                        return true;
                }
                menuItem.setChecked(true);
                return false;
            }
        });

        loadFragment(fragmentExplore);


    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
