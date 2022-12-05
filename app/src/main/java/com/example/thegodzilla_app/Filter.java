package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.example.fragment.SearchFragment;

    public class Filter extends AppCompatActivity {
        ImageButton imbBackFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_filters);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

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
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case android.R.id.home:
                    this.finish();
                    return true;
            };
            return super.onOptionsItemSelected(item);
        }
    }