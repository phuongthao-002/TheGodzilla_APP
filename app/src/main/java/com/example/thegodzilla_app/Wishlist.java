package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.adapter.WishlistAdapter;
import com.example.models.Wishlist_models;
import com.example.thegodzilla_app.databinding.ActivityWishlistBinding;

import java.util.ArrayList;

public class Wishlist extends AppCompatActivity {

    ActivityWishlistBinding binding;

    GridView gvProducts;
    ArrayList<Wishlist_models> wishlistArrayList;
    WishlistAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_wishlist);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_wishlist);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        binding = ActivityWishlistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }
    private void loadData() {
        wishlistArrayList = new ArrayList<>();
        wishlistArrayList.add(new Wishlist_models(R.drawable.name, "JOGGER ", "$400"));
        wishlistArrayList.add(new Wishlist_models(R.drawable.name, "Adidas", "$500"));
        wishlistArrayList.add(new Wishlist_models(R.drawable.name, "Hanaval", "$450"));

        adapter = new WishlistAdapter(Wishlist.this, R.layout.item_wishlist, wishlistArrayList);
        binding.gvProducts.setAdapter(adapter);

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