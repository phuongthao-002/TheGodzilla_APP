package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.adapter.NotifiAdapter;

import com.example.models.Notifi;
import com.example.thegodzilla_app.R;

import java.util.ArrayList;

public class notification extends Fragment {
    ListView lv_notifi;
    NotifiAdapter adapter;
    ArrayList<Notifi> notifiArrayList;

    public static notification newInstance() {
        notification fragment = new notification();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        lv_notifi = view.findViewById(R.id.lv_Notification);
        notifiArrayList = new ArrayList<>();

        notifiArrayList.add(new Notifi(R.drawable.mint, "Your order #28072002 has been confirmed"));
        notifiArrayList.add(new Notifi(R.drawable.airjordan, "Your order 09102002 has been confirmed"));

        adapter = new NotifiAdapter(getContext(),R.layout.item_notification, notifiArrayList);
        lv_notifi.setAdapter(adapter);
        return view;
    }
}