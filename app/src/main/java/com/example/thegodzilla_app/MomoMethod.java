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

public class MomoMethod extends AppCompatActivity {
    Button btnContinueMomo;
    EditText edt_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_momomethod);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_momo);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        linkView();
        addEvent();
    }

    private void addEvent() {
        btnContinueMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_num.getText().length() == 0)
                    Toast.makeText(MomoMethod.this, "You must fill in all the information to continue!", Toast.LENGTH_SHORT).show();
                else startActivity(new Intent(MomoMethod.this, CheckOut.class));
//                startActivity(new Intent(momomethod.this, checkout.class));
            }
        });
    }

    private void linkView() {
        edt_num = findViewById(R.id.edt_momo_num);
        btnContinueMomo = findViewById(R.id.btn_momo_continue);

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