package com.example.thegodzilla_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mytest.fragments.SearchFragment;

    public class Filter extends AppCompatActivity {
        ImageButton imbBackFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        addEvent();
        linkView();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_filter,new SearchFragment()).commit();
    }

        private void linkView() {
        }

        private void addEvent() {

//            imbBackFilter.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    finish();
//                }
//            });
        }
    }