package com.example.thegodzilla_app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.ProductAdapter;
import com.example.adapter.RecentAndTrendingAdapter;
import com.example.database.Product_Database_Helper;
import com.example.models.Product;
import com.example.fragment.DetailFragment;
import com.example.thegodzilla_app.R;
import com.example.utils.Constant;

import java.util.ArrayList;

public class Search_keyword extends AppCompatActivity {

    ImageButton btnBack;
    GridView gvMatching;
    ArrayList<Product> arrayList;
    ProductAdapter adapter;
    RecyclerView rcvTrend, rcvRecent;
    RecentAndTrendingAdapter adapter2, adapter3;
    Fragment detailFragment = null;
    EditText edtSearch;
    Product_Database_Helper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_keyword);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_search);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        LinkViews();
        InitData();
        AddEvents();
    }

    private void LinkViews() {
//        rcvTrend = findViewById(R.id.rcvTrend);
        rcvRecent = findViewById(R.id.rcvRecent);
        gvMatching = findViewById(R.id.gvMatching);
        edtSearch = findViewById(R.id.edtSearch);
//        btnBack = findViewById(R.id.btnBackSearch);
    }

    private void InitData() {
        //MATCHING PRODUCT

        arrayList = new ArrayList<>();
        db = new Product_Database_Helper(this);
        arrayList = db.dsAllProducts();
        adapter = new ProductAdapter(this, R.layout.item_matching_layout, arrayList);
        gvMatching.setAdapter(adapter);

        //  TRENDING SEARCHES

//        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
//        rcvTrend.setLayoutManager(manager);
//        rcvTrend.setHasFixedSize(true);
//
//        String[] trending = {"Jordan","Nike Air Force 1","PUMA Classic" };
//        adapter2 = new RecentAndTrendingAdapter(getApplicationContext(),trending);
//        adapter.notifyDataSetChanged();
//        rcvTrend.setAdapter(adapter2);
//
//        DividerItemDecoration divider = new DividerItemDecoration(rcvTrend.getContext(),DividerItemDecoration.VERTICAL);
//        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
//        divider.setDrawable(drawable);
//        rcvTrend.addItemDecoration(divider);

        //RECENT SEARCHES

        LinearLayoutManager manager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rcvRecent.setLayoutManager(manager2);
        String[] recent = {"Jordan","Nike Air Force 1","PUMA Classic" };
        adapter3 = new RecentAndTrendingAdapter(getApplicationContext(), recent);
        rcvRecent.setAdapter(adapter3);
        DividerItemDecoration divider1 = new DividerItemDecoration(rcvRecent.getContext(),DividerItemDecoration.HORIZONTAL);
        Drawable drawable1 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        divider1.setDrawable(drawable1);
        rcvRecent.addItemDecoration(divider1);
    }

    private void AddEvents() {

//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        gvMatching.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product p = arrayList.get(position);
                detailFragment= new DetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.SELECT_ITEM,p);
                detailFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_full_searchView, detailFragment)
                        .commit();
            }
        });
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