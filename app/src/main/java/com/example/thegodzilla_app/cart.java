package com.example.thegodzilla_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.adapter.cart_adapter;
import com.example.models.Productcart;
import com.example.thegodzilla_app.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class cart extends AppCompatActivity
{
    ActivityCartBinding binding;
    cart_adapter adapter;
    ArrayList<Productcart> productcarts;
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvent();

    }

    private void addEvent()
    {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cart.this,checkout.class);
                startActivity(intent);

            }
        });
        binding.imvTickAll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (i%2==0)
                {
                    binding.imvTickAll.setImageResource(R.drawable.ic_baseline_check_box_outline_blank_24);
                    binding.txtTotal.setText("Total: 0$");
                }
                else
                {
                    binding.imvTickAll.setImageResource(R.drawable.ic_baseline_check_box_24);
                    binding.txtTotal.setText("Total: 2000$");
                }
                i=i+1;

            }
        });


    }



    private void loadData()
    {
        productcarts = new ArrayList<>();
        productcarts.add(new Productcart(R.drawable.puma,"Puma"));
        productcarts.add(new Productcart(R.drawable.logoconverse,"Converse"));

        //init adapter
        adapter =new cart_adapter(cart.this,R.layout.item_cart_list,productcarts);
        binding.lvProductCart.setAdapter(adapter);
    }
}