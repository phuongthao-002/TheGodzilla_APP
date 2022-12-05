package com.example.thegodzilla_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.thegodzilla_app.databinding.ActivityChangepasswordBinding;

public class ChangePassword extends AppCompatActivity {
    ActivityChangepasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_changepassword);
        binding = ActivityChangepasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvent();

    }

    private void addEvent()
    {
        binding.btnChangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(ChangePassword.this, "Change password successfully", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnBackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}