package com.example.mytest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.adapter.ExpandableListViewAdapter;

import com.example.models.GroupObject;
import com.example.models.ItemObject;

import com.example.mytest.All_product;
import com.example.thegodzilla_app.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchFragment extends Fragment {

    private ExpandableListView expandableListView;
    private List<GroupObject> mListGroup;
    private Map<GroupObject, List<ItemObject>> mListItem;
    private ExpandableListViewAdapter expandableListViewAdapter;
    View.OnClickListener OpenBack;
    ImageButton imbBackFilter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        linkView(view);
        loadData();
        addEvent();

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
               ShowItem(mListItem.get(mListGroup.get(groupPosition)).get(childPosition).getNameItem());
                return true;
            }
        });
        return view ;
    }

    private void addEvent() {
        OpenBack = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), All_product.class));
            }
        };
        imbBackFilter.setOnClickListener(OpenBack);
        OpenBack = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), All_product.class));
            }
        };
    }

    private void ShowItem(String nameItem) {
        if (nameItem == "Shop All Sports" )  startActivity(new Intent(getContext(), All_product.class));
        else if (nameItem == "All Brands" || nameItem == "Shop By Brand") startActivity(new Intent(getContext(), All_product.class));
        else startActivity(new Intent(getContext(), All_product.class));
        }



    private void linkView(View view) {
        expandableListView = view.findViewById(R.id.elvOption);
        imbBackFilter = view.findViewById(R.id.imbBackFilter);
    }

    private void loadData() {
        mListItem = getmListItem();
        mListGroup = new ArrayList<>(mListItem.keySet());

        expandableListViewAdapter = new ExpandableListViewAdapter(mListGroup, mListItem);
        expandableListView.setAdapter(expandableListViewAdapter);
    }
    private Map<GroupObject, List<ItemObject>> getmListItem(){
        Map<GroupObject, List<ItemObject>> listMap = new HashMap<>();

        GroupObject groupObject1 = new GroupObject(1, "Prices");
        GroupObject groupObject2 = new GroupObject(2, "Types");
        GroupObject groupObject3 = new GroupObject(3, "Sizes");
        GroupObject groupObject4 = new GroupObject(4, "Brands");


        List<ItemObject> objectList1 = new ArrayList<>();
        objectList1.add(new ItemObject(1, "Under $100"));
        objectList1.add(new ItemObject(2, "100$ - 200$"));
        objectList1.add(new ItemObject(3, "200$ - 300$"));
        objectList1.add(new ItemObject(4, "300$ - 400$"));
        objectList1.add(new ItemObject(5, "400$ - 500$"));
        objectList1.add(new ItemObject(6, "500$+"));

        List<ItemObject> objectList2 = new ArrayList<>();
        objectList2.add(new ItemObject(5, "Shop All"));
        objectList2.add(new ItemObject(6, "High Tops"));
        objectList2.add(new ItemObject(7, "Low Tops"));
        objectList2.add(new ItemObject(8, "Slip On"));

        List<ItemObject> objectList3 = new ArrayList<>();
        objectList3.add(new ItemObject(9, "VN 36-37      UK 4"));
        objectList3.add(new ItemObject(10, "VN  37        UK 4.5"));
        objectList3.add(new ItemObject(11, "VN 37-38      UK 5"));
        objectList3.add(new ItemObject(12, "VN  38        UK 5.5"));
        objectList3.add(new ItemObject(13, "VN 38-39      UK 6"));
        objectList3.add(new ItemObject(14, "VN  40        UK 6.5"));
        objectList3.add(new ItemObject(15, "VN 40-41      UK 7"));
        objectList3.add(new ItemObject(16, "VN  41        UK 7.5"));

        List<ItemObject> objectList4 = new ArrayList<>();
        objectList4.add(new ItemObject(18, "Adidas"));
        objectList4.add(new ItemObject(19, "Nike"));
        objectList4.add(new ItemObject(20, "New Balance"));
        objectList4.add(new ItemObject(21, "Rebook"));
        objectList4.add(new ItemObject(22, "Converse"));
        objectList4.add(new ItemObject(23, "Vans"));
        objectList4.add(new ItemObject(24, "Puma"));


        listMap.put(groupObject1, objectList1);
        listMap.put(groupObject2, objectList2);
        listMap.put(groupObject3, objectList3);
        listMap.put(groupObject4, objectList4);

        return listMap;
    }
}