package com.example.thegodzilla_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mytest.ui.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvent();
        linkView();
    }

    private void linkView() {
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }


    private void addEvent() {
//        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemReselectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

    }
//    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemReselectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment selectedFragment = null;
//            switch (item.getItemId())
//            {
//                case R.id.navigation_home:
//                    selectedFragment = new HomeFragment();
//                    break;
//                case R.id.navigation_search:
//                    selectedFragment = new SearchFragment();
//                    break;
//                case R.id.navigation_notifications:
//                    selectedFragment = new NotificationsFragment();
//                    break;
//                case R.id.navigation_more:
//                    selectedFragment = new MoreFragment();
//                    break;
//            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
//            return true;
//        }
//    };
////
//
//    @Override
//    public void messclick(Messages m) {
//        bottomNavigationView.setVisibility(View.GONE);
//
//    }
}