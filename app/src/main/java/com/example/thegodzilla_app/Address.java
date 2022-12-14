package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.models.TranInf;
import com.example.thegodzilla_app.databinding.ActivityAddressBinding;

public class Address extends AppCompatActivity {
    ActivityAddressBinding binding;
//    ActivityResultLauncher<Intent> laucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_address);
        binding = ActivityAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnAddressDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Address.this, CheckOut.class);
                String Inf1 = binding.edtAddressName.getText().toString().trim();
                String Inf2 = binding.edtAddressPhone.getText().toString().trim();
                String Inf3 = binding.edtAddressWard.getText().toString().trim();
                String Inf4 = binding.edtAddressStreet.getText().toString().trim();

                TranInf.AddressInf = Inf1 + ", " + Inf2 + ", " + Inf3 + ", " + Inf4;
////
//                i.putExtra("name", binding.edtAddressName.getText().toString());
//                i.putExtra("phone", binding.edtAddressPhone.getText().toString());
//                i.putExtra("ward", binding.edtAddressWard.getText().toString());
//                i.putExtra("street", binding.edtAddressWard.getText().toString());
//                i.putExtra("type", binding.btnAddressHomeOffice.getText().toString());
//                laucher.launch(i);
                startActivity(i);
            }
        });

        binding.imbAddressTron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.txtAddressOnOff.getText() == null || binding.txtAddressOnOff.getText().equals("ON")){
                    binding.txtAddressOnOff.setText("OFF");
                    binding.txtAddressOnOff.setTag("OFF");
                } else {
                    binding.txtAddressOnOff.setText("ON");
                    binding.txtAddressOnOff.setTag("ON");
                }
            }
        });
        binding.btnAddressHomeOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.btnAddressHomeOffice.getText() == "Office" || binding.btnAddressHomeOffice.getText().equals("Office")){
                    binding.btnAddressHomeOffice.setText("Home");
                    binding.btnAddressHomeOffice.setTag("Home");
                } else {
                    binding.btnAddressHomeOffice.setText("Office");
                    binding.btnAddressHomeOffice.setTag("Offcie");
                }
            }
        });

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_address);
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