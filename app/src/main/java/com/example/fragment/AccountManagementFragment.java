package com.example.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.thegodzilla_app.LogIn;
import com.example.thegodzilla_app.R;
import com.example.thegodzilla_app.Wishlist;
import com.example.thegodzilla_app.Chat;
import com.example.thegodzilla_app.EditAccount;
import com.example.thegodzilla_app.MyPurchase;

public class AccountManagementFragment extends Fragment {
    Button btnLogOut, btnMyPurchase,btnNoti, btnWishList, btnChat;
    ImageButton imbEdit;
    TextView txt_name, txt_mail;
    View.OnClickListener OpenEditAccount, OpenMyPurchase, OpenNotification, OpenWishlist, OpenChat, Logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        imbEdit = view.findViewById(R.id.imb_edit_account);
        btnLogOut = view.findViewById(R.id.btn_LogOut);
        btnMyPurchase = view.findViewById(R.id.btn_MyPurchase);
        btnNoti = view.findViewById(R.id.btn_Notification);
        btnWishList = view.findViewById(R.id.btn_Wishlist);
        txt_name = view.findViewById(R.id.txt_account_name);
        txt_mail = view.findViewById(R.id.txt_account_mail);
        btnChat = view.findViewById(R.id.btn_Chat);

        OpenEditAccount = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), EditAccount.class));
            }
        };
        imbEdit.setOnClickListener(OpenEditAccount);

        OpenMyPurchase = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MyPurchase.class));
            }
        };
        btnMyPurchase.setOnClickListener(OpenMyPurchase);

        OpenWishlist = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Wishlist.class));
            }
        };
        btnWishList.setOnClickListener(OpenWishlist);

//        btnChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(account.this, chat.class));
//            }
//        });
        OpenChat = new View.OnClickListener() {
            @Override
            public void onClick(View v) {startActivity(new Intent(getContext(), Chat.class));}
        };
        btnChat.setOnClickListener(OpenChat);


        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Confirm exit");
//                builder.setIcon();
                builder.setIcon(R.drawable.ic_baseline_info_24);
                builder.setMessage("Do you want to sign out?");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getContext(), LogIn.class));
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });


                Dialog dialog = builder.create();
                dialog.show();
            }
        });

//        Logout = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(account.this);
//                builder.setTitle("Xác nhận thoát");
////                builder.setIcon();
//                builder.setIcon(android.R.drawable.ic_dialog_info);
//                builder.setMessage("Bạn có muốn thoát ko");
//
//
//                Dialog dialog = builder.create();
//                dialog.show();
//                if(btnLogOut.getText() == "Log Out" ){
//                    btnLogOut.setText("Log In");
//                    btnLogOut.setTag("in");
//                    txt_name.setText("Thổ bùi");
//                    txt_mail.setText("nguyena@gmail.com");
//                } else {
//                    if (btnLogOut.getText() == "Log In") {
//                        startActivity(new Intent(getContext(), LogIn.class));
//                    }
//                }


//                btnLogOut.setText("Log Out");
//                btnLogOut.setTag("out");
                //                    || binding.btnLogOut.getText().equals("out")
//            }
//        };
//        btnLogOut.setOnClickListener(Logout);

        OpenNotification = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnNoti.getText() == "Notification-Off" || btnNoti.getText().equals("off")){
                    btnNoti.setText("Notification-On");
                    btnNoti.setTag("on");
                } else {
                    btnNoti.setText("Notification-Off");
                    btnNoti.setTag("off");
                }
            }
        };
        btnNoti.setOnClickListener(OpenNotification);

        return view;

    }
}