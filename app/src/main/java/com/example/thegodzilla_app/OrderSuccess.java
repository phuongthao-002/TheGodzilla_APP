package com.example.thegodzilla_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderSuccess extends AppCompatActivity {
    Button btnCheckOrder, btnBacktoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordersuccess);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_ordersuccess);
        
        linkView();
        addEvent();
    }

    private void addEvent() {
        btnCheckOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderSuccess.this, MyPurchase.class));
            }
        });
        btnBacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderSuccess.this, Navigation.class));
            }
        });
    }

    private void linkView() {
        btnCheckOrder = findViewById(R.id.btn_ordersuccess_check);
        btnBacktoHome = findViewById(R.id.btn_ordersuccess_tohome);
    }
}