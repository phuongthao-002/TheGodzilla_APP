package com.example.thegodzilla_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.adapter.NotifiAdapter;
import com.example.models.Notifi;
import com.example.thegodzilla_app.databinding.ActivityNotificationBinding;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {

    ActivityNotificationBinding binding;
    NotifiAdapter adapter;
    ArrayList<Notifi> notifiArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_notification);

        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        notifiArrayList = new ArrayList<>();
        notifiArrayList.add(new Notifi(R.drawable.mint, "Your order #28072002 has been confirmed"));
        notifiArrayList.add(new Notifi(R.drawable.airjordan, "Your order 09102002 has been confirmed"));
        adapter = new NotifiAdapter(Notification.this,R.layout.item_notification, notifiArrayList);
        binding.lvNoti.setAdapter(adapter);
    }

}