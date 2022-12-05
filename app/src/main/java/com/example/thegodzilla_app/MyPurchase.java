package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.adapter.purchase_adapter;
import com.example.models.Mypurchase;
import com.example.thegodzilla_app.databinding.ActivityMypurchaseBinding;

import java.util.ArrayList;

public class MyPurchase extends AppCompatActivity {
    ActivityMypurchaseBinding binding;
    purchase_adapter adapter;
    ArrayList<Mypurchase> puchaselist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_mypurchase);
        binding = ActivityMypurchaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_mypurchase);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

//        ActionBar actionBar =getSupportActionBar();
//        actionBar.hide();


        loadData();
//        addEvent();
    }

//    private void addEvent()
//    {
//        binding.btnBackhome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//    }

    private void loadData()
    {
        puchaselist = new ArrayList<>();
        puchaselist.add(new Mypurchase(R.drawable.logonike_voucher,"Sneaker1","To pay","Pay now"));
        puchaselist.add(new Mypurchase(R.drawable.logoconverse,"Sneaker2","To ship","Contact"));
        puchaselist.add(new Mypurchase(R.drawable.logoconverse,"Sneaker3","Complete","Rate"));
        adapter =new purchase_adapter(MyPurchase.this,R.layout.item_mypurchase_list,puchaselist);
        binding.lvPurchase.setAdapter(adapter);
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