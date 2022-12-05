package com.example.thegodzilla_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.Interface.MyItemClick;
import com.example.models.Product;
import com.example.fragment.DetailFragment;
import com.example.fragment.GridProductFragment;
import com.example.fragment.ListProductFragment;
import com.example.utils.Constant;


public class All_product extends AppCompatActivity implements View.OnClickListener, MyItemClick {

    ImageButton imgbtnGrid, imgbtnFilter;
    ImageView imvBack,imvTrend,imvAll,imvCart;
    EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_allproduct);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        LinkViews();
        AddEvents();

        getSupportFragmentManager().beginTransaction().replace(com.example.thegodzilla_app.R.id.fragmentProduct,new ListProductFragment()).commit();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    private void LinkViews() {
        edtSearch = findViewById(R.id.edtSearch);
        imgbtnGrid = findViewById(R.id.imgbtnGrid);
        imgbtnFilter = findViewById(R.id.imgbtnFilter);
//        imvCart = findViewById(R.id.imvCart);
//        imvBack = findViewById(R.id.imvBack);
    }

    private void AddEvents() {
        imgbtnGrid.setOnClickListener(this);

        imgbtnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                BottomSheetDialog b = new BottomSheetDialog(All_product.this);
//                b.setContentView(R.layout.layout_popup_filter);
//                b.show();

                startActivity (new Intent(All_product.this, Filter.class));
            }
        });


//        imvBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(All_product.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });


//        imvCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment fragment = new CartFragment();
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full1,fragment).commit();
//            }
//        });


        edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(All_product.this,Search_keyword.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        if(v.getId()==R.id.imgbtnGrid)
        {if(imgbtnGrid.getTag()==null || imgbtnGrid.getTag().equals("list")){
            imgbtnGrid.setImageResource(R.drawable.all);
            imgbtnGrid.setTag("grid");
            fragment = new GridProductFragment();
        }
        else {
            imgbtnGrid.setImageResource(R.drawable.trend);
            imgbtnGrid.setTag("list");
            fragment = new ListProductFragment();
        }
    }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentProduct,fragment).commit();
    }


    @Override
    public void click(Product p) {
        DetailFragment detailFragment= new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.SELECT_ITEM,p);
                detailFragment.setArguments(bundle);
                if (bundle != null)

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full1, detailFragment).
                addToBackStack(null).
                commit();
    }

//    public void openSizeDialog() {
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.layout_popup_size);
//        GridView gvSize = dialog.findViewById(R.id.gvPopSize);
//        String[] size = { "7", "7.5", "8", "8.5", "9", "9.5"} ;
//        PopupSizeAdapter adapter = new PopupSizeAdapter(this,R.layout.item_size_layout,size);
//        gvSize.setAdapter(adapter);
//        gvSize.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Fragment fragment = new CartFragment();
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full1,fragment).commit();
//                dialog.cancel();
//            }
//        });
//        dialog.show();
//    }
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