package com.example.thegodzilla_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.thegodzilla_app.databinding.ActivityAccountManagementBinding;

public class AccountManagement extends Activity {
//    Button btnLogOut, btnMyPurchase,btnNoti, btnWishList, btnChat;
//    ImageButton imbEdit;
//    ActivityAccountManagementBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);
//        binding = ActivityAccountManagementBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());


//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.action_bar_account_management);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

//        linkViews();
//        addEvents();
    }

//    private void addEvents() {
//
//        btnLogOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(binding.btnLogOut.getText() == "Log Out" ){
//                    binding.btnLogOut.setText("Log In");
//                    binding.btnLogOut.setTag("in");
//                    binding.txtAccountName.setText("Thổ bùi");
//                    binding.txtAccountMail.setText("VAN@gmail.com");
////                } else {
//////                    || binding.btnLogOut.getText().equals("out")
////                    binding.btnLogOut.setText("Log Out");
////                    binding.btnLogOut.setTag("out");
////
////                    startActivity(new Intent(AccountManagement.this, LogIn.class ));
//                }
//            }
//        });
//
//        btnNoti.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(binding.btnNotification.getText() == "Notification-On" || binding.btnLogOut.getText().equals("on")){
//                    binding.btnNotification.setText("Notification-Off");
//                    binding.btnNotification.setTag("off");
//                } else {
//                    binding.btnNotification.setText("Notification-On");
//                    binding.btnNotification.setTag("on");
//                }
//            }
//        });
//        btnChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(AccountManagement.this, chat.class ));
//            }
//        });
//
//        btnWishList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(AccountManagement.this, Wishlist.class));
//            }
//        });
//
//
//        btnMyPurchase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(AccountManagement.this, mypurchase.class));
//            }
//        });
//        imbEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(AccountManagement.this, editaccount.class));
//            }
//        });
//
//
//    }
//
//    private void linkViews() {
//        imbEdit = findViewById(R.id.imb_edit_account);
//        btnLogOut = findViewById(R.id.btn_LogOut);
//        btnMyPurchase = findViewById(R.id.btn_MyPurchase);
//        btnNoti = findViewById(R.id.btn_Notification);
//        btnWishList = findViewById(R.id.btn_Wishlist);
//        btnChat = findViewById(R.id.btn_Chat);
//    }


}