package com.example.thegodzilla_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmOPT extends AppCompatActivity {

    EditText edtOTP, edtPassword, edtConfirm;
    Button btnLogIn;
    TextView txtBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_opt);

        ActionBar actionBar =getSupportActionBar();
        actionBar.hide();

        LinkViews();
        AddEvents();
    }
    private void LinkViews() {
        edtOTP = findViewById(R.id.edt_OTP);
        edtPassword = findViewById(R.id.edt_password);
        edtConfirm = findViewById(R.id.edt_ConfirmPwd);
        btnLogIn = findViewById(R.id.btn_login);
        txtBack = findViewById(R.id.txt_Back);
    }

    private void AddEvents() {
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtOTP.getText().length() == 0 || edtPassword.getText().length() == 0 || edtConfirm.getText().length() == 0) Toast.makeText(ConfirmOPT.this, "You must fill in all the information to signing up!", Toast.LENGTH_SHORT).show();
                else startActivity(new Intent(ConfirmOPT.this,LogIn.class));
            }
        });
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}