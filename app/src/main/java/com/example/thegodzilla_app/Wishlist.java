package com.example.thegodzilla_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.adapter.Wishlist_Product;
import com.example.models.Wishlist_models;
import com.example.thegodzilla_app.databinding.ActivityWishlistBinding;

import java.util.ArrayList;

public class Wishlist extends AppCompatActivity {

    ActivityWishlistBinding binding;

    GridView gvProducts;
    ArrayList<Wishlist_models> wishlistArrayList;
    Wishlist_Product adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_wishlist);

        binding = ActivityWishlistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }
    private void loadData() {
        wishlistArrayList = new ArrayList<>();
        wishlistArrayList.add(new Wishlist_models(R.drawable.adidas_woman, "Adidas", "$400", "1000 Sold" ));


        adapter = new Wishlist_Product(Wishlist.this, R.layout.item_wishlist, wishlistArrayList);
        binding.gvProducts.setAdapter(adapter);

    }

}