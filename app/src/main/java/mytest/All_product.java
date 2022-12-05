package mytest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.Interface.MyItemClick;
import com.example.models.Product;
import com.example.fragment.DetailFragment;
import com.example.fragment.GridProductFragment;
import com.example.fragment.ListProductFragment;
import com.example.thegodzilla_app.R;
import com.example.utils.Constant;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class All_product extends AppCompatActivity implements View.OnClickListener, MyItemClick {

    ImageButton imgbtnGrid, imgbtnFilter;
    ImageView imvBack;
    EditText edtSearch;
    Button btnTrending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.thegodzilla_app.R.layout.activity_all_product);

        LinkViews();
        AddEvents();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentProduct,new ListProductFragment()).commit();
    }

    private void LinkViews() {
        edtSearch = findViewById(R.id.edtSearch);
        imgbtnGrid = findViewById(R.id.imgbtnGrid);
        imgbtnFilter = findViewById(R.id.imgbtnFilter);
//        imvCart = findViewById(R.id.imvCart);
        imvBack = findViewById(R.id.imvBack);
    }

    private void AddEvents() {
        imgbtnGrid.setOnClickListener(this);
        btnTrending.setOnClickListener(this);

        imgbtnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog b = new BottomSheetDialog(All_product.this);
                b.setContentView(R.layout.layout_popup_filter);
                b.show();
            }
        });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        if(v.getId()==R.id.imgbtnGrid)
        {if(imgbtnGrid.getTag()==null || imgbtnGrid.getTag().equals("grid")){
            imgbtnGrid.setImageResource(R.drawable.trend);
            imgbtnGrid.setTag("list");
            fragment = new GridProductFragment();
        }
        else {
            imgbtnGrid.setImageResource(R.drawable.all);
            imgbtnGrid.setTag("grid");
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

}