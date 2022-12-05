package com.example.thegodzilla_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Forgot_pwd extends AppCompatActivity {

    EditText edtEmailorPhone;
    Button btnResetPwd;
    TextView txtBackto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);

        ActionBar actionBar =getSupportActionBar();
        actionBar.hide();

        LinkViews();
        AddEvents();
    }
    private void LinkViews() {
        edtEmailorPhone = findViewById(R.id.edt_emailorphone);
        btnResetPwd = findViewById(R.id.btn_resetPwd);
        txtBackto = findViewById(R.id.txt_BackTo);
    }
    private void AddEvents() {
        btnResetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (edtEmailorPhone.getText().length() == 0)
//                    Toast.makeText(forgot_pwd.this, "You must fill in all the information to signing up!", Toast.LENGTH_SHORT).show();
//                else
                startActivity(new Intent(Forgot_pwd.this, ConfirmOPT.class));
            }
        });
        txtBackto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}