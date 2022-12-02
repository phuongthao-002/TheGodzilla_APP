package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class credit_debit_card extends AppCompatActivity {
    String[] items = {"BIDV", "CAKE", "Techcombank", "Vietinbank"};
    AutoCompleteTextView autoSelectBank;
    ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_debit_card);

        autoSelectBank = findViewById(R.id.auto_select_bank);
        adapterItems = new ArrayAdapter<String>(this,R.layout.iterm_card, items);
        autoSelectBank.setAdapter(adapterItems);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_card);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
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