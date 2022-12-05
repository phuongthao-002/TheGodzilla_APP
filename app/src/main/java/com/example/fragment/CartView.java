package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.cart_adapter;
import com.example.models.Productcart;
import com.example.thegodzilla_app.R;
import com.example.thegodzilla_app.checkout;

import java.util.ArrayList;

public class CartView extends Fragment {
    Button btnCheckout;
    ListView lv_product;
    cart_adapter adapter;
    ArrayList<Productcart> productcarts;
    View.OnClickListener OpenCheckout, Opentick;
    ImageView imvTickall;
    TextView txtTotal;
    int i=1;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        lv_product = view.findViewById(R.id.lv_productCart);
        btnCheckout = view.findViewById(R.id.btn_checkout);
        txtTotal = view.findViewById(R.id.txtTotal);
        imvTickall = view.findViewById(R.id.imvTickAll);


        productcarts = new ArrayList<>();
        productcarts.add(new Productcart(R.drawable.puma,"Puma"));
        productcarts.add(new Productcart(R.drawable.logoconverse,"Converse"));

        //init adapter
        adapter =new cart_adapter(getContext(),R.layout.item_cart_list,productcarts);
        lv_product.setAdapter(adapter);

        OpenCheckout = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), checkout.class));
            }
        };
        btnCheckout.setOnClickListener(OpenCheckout);

        Opentick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i%2!=0)
                {
                    imvTickall.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
                    txtTotal.setText("Total: $2000");
                }
                else
                {
                    imvTickall.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
                    txtTotal.setText("Total: $0");
                }
                i=i+1;
            }
        };
        imvTickall.setOnClickListener(Opentick);

//        imvTickall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (i%2!=0)
//                {
//                    imvTickall.setBackgroundResource(R.drawable.ic_baseline_check_box_24);
//                    txtTotal.setText("Total: $2000");
//                }
//                else
//                {
//                    imvTickall.setBackgroundResource(R.drawable.ic_baseline_check_box_outline_blank_24);
//                    txtTotal.setText("Total: $0");
//                }
//                i=i+1;
//
//            }
//        });

        return view;
    }


//    private void addEvent() {
//        OpenAllProducts = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getContext(), checkout.class));
//            }
//        };
//        btnCheckout.setOnClickListener(OpenAllProducts);
//    }



}