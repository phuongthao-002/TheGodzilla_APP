package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.Interface.adapter.payadapter;
import com.example.models.pay;
import com.example.thegodzilla_app.databinding.ActivityPaymentmethodBinding;

import java.util.ArrayList;

public class paymentmethod extends AppCompatActivity {
    ActivityPaymentmethodBinding binding;
    com.example.Interface.adapter.payadapter payadapter;
    ArrayList<pay> payArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_paymentmethod);
        binding = ActivityPaymentmethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_paymentmethod);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void loadData() {
        payArrayList = new ArrayList<>();
        payArrayList.add(new pay(R.drawable.cash, "COD"));
        payArrayList.add(new pay(R.drawable.momo, "Momo"));
        payArrayList.add(new pay(R.drawable.zalopay, "Zalopay"));
        payArrayList.add(new pay(R.drawable.credit_card, "Credit/Debit cart"));
        payadapter = new payadapter(paymentmethod.this, R.layout.payment_options, payArrayList);
        binding.lvPayMethod.setAdapter(payadapter);
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