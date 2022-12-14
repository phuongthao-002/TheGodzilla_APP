package com.example.thegodzilla_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    Button btnSignUp, btnLogin1;
    CheckBox cbAccept;
    EditText edtLastname, edtFirstname, edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ActionBar actionBar =getSupportActionBar();
        actionBar.hide();

        LinkView();
        AddEvents();

    }
    private void LinkView() {
        cbAccept = findViewById(R.id.checkboxAccept);
        btnSignUp = findViewById(R.id.btn_signup);
        edtFirstname = findViewById(R.id.edt_firstname);
        edtLastname = findViewById(R.id.edt_lastname);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin1 = findViewById(R.id.btn_login_1);


    }

    private void AddEvents() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtEmail.getText().length() == 0 || edtFirstname.getText().length() == 0 || edtLastname.getText().length() == 0 || edtPassword.getText().length() == 0)
                    Toast.makeText(SignUp.this, "You must fill in all the information to signing up!", Toast.LENGTH_SHORT).show();
                else if(!cbAccept.isChecked())
                    Toast.makeText(SignUp.this, "You have to accept terms of use to signing up!", Toast.LENGTH_SHORT).show();
                else startActivity(new Intent(SignUp.this, Navigation.class));
            }
        });

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, LogIn.class));
            }
        });
    }


}