package com.example.thegodzilla_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountManagement extends Activity {
    Button btnLogOut, btnMyPurchase,btnNoti, btnWishList, btnChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);

        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountManagement.this, LogIn.class ));
            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountManagement.this, chat.class ));
            }
        });

        btnWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountManagement.this, Wishlist.class));
            }
        });

        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountManagement.this, Notification.class));
            }
        });

        btnMyPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountManagement.this, mypurchase.class));
            }
        });


    }

    private void linkViews() {
        btnLogOut = findViewById(R.id.btn_LogOut);
        btnMyPurchase = findViewById(R.id.btn_MyPurchase);
        btnNoti = findViewById(R.id.btn_Notification);
        btnWishList = findViewById(R.id.btn_Wishlist);
        btnChat = findViewById(R.id.btn_Chat);
    }
}