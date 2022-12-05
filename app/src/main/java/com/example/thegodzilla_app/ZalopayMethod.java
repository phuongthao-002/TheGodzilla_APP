package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thegodzilla_app.databinding.ActivityZalopaymethodBinding;

public class ZalopayMethod extends AppCompatActivity {
    ActivityZalopaymethodBinding binding;
    Button btn_Continue_Zalopay;
    EditText edt_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zalopaymethod);
        binding = ActivityZalopaymethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_zalo);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        linkView();
        addEvent();


    }

    private void linkView() {
        edt_number = findViewById(R.id.edt_zalo_num);
        btn_Continue_Zalopay = findViewById(R.id.btn_zalo_continue);
    }

    private void addEvent() {
        btn_Continue_Zalopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_number.getText().length() == 0)
                    Toast.makeText(ZalopayMethod.this, "You must fill in all the information to continue!", Toast.LENGTH_SHORT).show();
                else startActivity(new Intent(ZalopayMethod.this, CheckOut.class));
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