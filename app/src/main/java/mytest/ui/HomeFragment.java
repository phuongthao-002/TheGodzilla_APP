package mytest.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.adapter.BrandAdapter;
import com.example.adapter.ImageAdapter;
import com.example.thegodzilla_app.R;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    GridView grvBrands;
    BrandAdapter brandAdapter;
    ViewPager viewPager;
    ImageAdapter imageAdapter, ShoesListAdapter;
    Timer timer;
    CircleIndicator circleIndicator;
    RecyclerView rcvListShoes;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(com.example.thegodzilla_app.R.layout.fragment_home, container, false);
        linkViews(view);
        loadData();
        return view;
    }



    private void loadData() {
        //banner slider
        imageAdapter = new ImageAdapter(getContext());
        viewPager.setAdapter(imageAdapter);
        //Gridview - Brands
        int[] brandList = {R.drawable.nike,R.drawable.adidas,R.drawable.supreme,R.drawable.vans,R.drawable.jordan,R.drawable.louboutin,R.drawable.converse,R.drawable.balenciaga};

        brandAdapter = new BrandAdapter(getContext(), R.layout.item_brand_gridview_layout, brandList);
        grvBrands.setAdapter(brandAdapter);
        //Circle Indicator
        circleIndicator.setViewPager(viewPager);
        imageAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        //Auto Silde

        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(() -> {
                    int currentItem = viewPager.getCurrentItem();
                    int totalItem = imageAdapter.getCount() - 1;
                    if (currentItem < totalItem) {
                        currentItem++;
                        viewPager.setCurrentItem(currentItem);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                });
            }
        }, 1000, 2500);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }


    private void linkViews(View view) {
        viewPager = view.findViewById(R.id.viewPager);
        grvBrands = view.findViewById(R.id.grvBrands);
        circleIndicator = view.findViewById(R.id.circleIndicator);
    }

}

