package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.thegodzilla_app.databinding.ActivityPaymentmethodBinding;

public class Paymentmethod extends AppCompatActivity {
    ActivityPaymentmethodBinding binding;
//    com.example.adapter.payadapter payadapter;
//    ArrayList<pay> payArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_paymentmethod);
        binding = ActivityPaymentmethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvent();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_paymentmethod);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void addEvent() {
        binding.btnSelectCod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Paymentmethod.this, CheckOut.class));
            }
        });
        binding.btnSelectMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Paymentmethod.this, MomoMethod.class));
            }
        });
        binding.btnSelectZalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Paymentmethod.this, ZalopayMethod.class));
            }
        });
        binding.btnSelectCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Paymentmethod.this, CreditDebitCard.class));
            }
        });
    }

    private void loadData() {
//        payArrayList = new ArrayList<>();
//        payArrayList.add(new pay(R.drawable.cash, "COD"));
//        payArrayList.add(new pay(R.drawable.momo, "Momo"));
//        payArrayList.add(new pay(R.drawable.zalopay, "Zalopay"));
//        payArrayList.add(new pay(R.drawable.credit_card, "Credit/Debit cart"));
//        payadapter = new payadapter(paymentmethod.this, R.layout.payment_options, payArrayList);
//        binding.lvPayMethod.setAdapter(payadapter);
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