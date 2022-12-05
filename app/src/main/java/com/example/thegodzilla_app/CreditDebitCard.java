package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.thegodzilla_app.databinding.ActivityCreditDebitCardBinding;

public class CreditDebitCard extends AppCompatActivity {
    String[] items = {"BIDV", "CAKE", "Techcombank", "Vietinbank"};
    AutoCompleteTextView autoSelectBank;
    ArrayAdapter<String> adapterItems;
    ActivityCreditDebitCardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_debit_card);
        binding = ActivityCreditDebitCardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        autoSelectBank = findViewById(R.id.auto_select_bank);
        adapterItems = new ArrayAdapter<String>(this,R.layout.iterm_card, items);
        autoSelectBank.setAdapter(adapterItems);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_card);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        addEvent();
    }

    private void addEvent() {
        binding.btnCartConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edtCartName.getText().length() == 0 || binding.edtCartNumber.getText().length() == 0 || binding.edtCartDate.getText().length() == 0 )
                    Toast.makeText(CreditDebitCard.this, "You must fill in all the information to continue!", Toast.LENGTH_SHORT).show();
                else startActivity(new Intent(CreditDebitCard.this, CheckOut.class));
//                startActivity(new Intent(momomethod.this, checkout.class));
            
            }
        });
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