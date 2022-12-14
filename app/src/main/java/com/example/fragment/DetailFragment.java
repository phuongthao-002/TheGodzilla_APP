package com.example.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.adapter.PopupSizeAdapter;
import com.example.models.Product;
import com.example.thegodzilla_app.R;
import com.example.thegodzilla_app.CheckOut;
import com.example.utils.Constant;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class DetailFragment extends Fragment {
    Product p;
    Button btnAddToCart,btnBuyNow;
    ImageView imvBack,imvHeart;
    TextView txtName,txtPrice,txtType,txtSize, txtDescription;
    ImageView imvThumb;
    GridView gvSize;
    View.OnClickListener OpenBuy;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(com.example.thegodzilla_app.R.layout.fragment_detail, container, false);

        imvBack = view.findViewById(R.id.imvBack);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(DetailFragment.this).commit();
            }
        });

        txtName = view.findViewById(R.id.txtName);
        txtPrice = view.findViewById(R.id.txtPrice);
        txtType = view.findViewById(R.id.txtType);
        txtDescription = view.findViewById(R.id.txtDescription);
        imvThumb = view.findViewById(R.id.imvThumb);
        gvSize = view.findViewById(R.id.gvSize);
//        OpenBuy = new View.OnClickListener() {
        btnBuyNow = view.findViewById(R.id.btnBuyDetail);
        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CheckOut.class));
            }
        });

//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getContext(), CartView.class));
//            }
//        };
//        btnBuyNow = view.findViewById(R.id.btnBuyDetail);
//        btnBuyNow.setOnClickListener(OpenBuy);
//        OpenBuy = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getContext(), CartView.class));
//            }
//        };



        Bundle bundle = getArguments();

            p = (Product) bundle.getSerializable(Constant.SELECT_ITEM);
            txtName.setText(p.getName());
            txtPrice.setText("$" + String.valueOf(p.getPrice()));
            txtType.setText(p.getType());
            txtDescription.setText(p.getDescription());

        byte[] photo = p.getThumb();
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo,0,photo.length);
        imvThumb.setImageBitmap(bitmap);


        btnAddToCart = view.findViewById(R.id.btnAddToCart);

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Th??m v??o gi??? h??ng th??nh c??ng",Toast.LENGTH_LONG).show();

                }
            });

        imvHeart = view.findViewById(R.id.imvHeart);

        imvHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Th??m v??o WishList th??nh c??ng",Toast.LENGTH_LONG).show();

            }
        });


        txtSize = view.findViewById(R.id.txtViewSizeGuide);
        txtSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
                bottomSheetDialog.setContentView(R.layout.layout_popup_viewsize);

                ImageButton imvbtnClose = bottomSheetDialog.findViewById(R.id.imvbtnClose);
                imvbtnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.cancel();
                    }
                });
                bottomSheetDialog.show();
            }
        });

        String[] size = { "7", "7.5", "8", "8.5", "9", "9.5"} ;
        PopupSizeAdapter adapter = new PopupSizeAdapter(getContext(),R.layout.item_size_layout,size);

        gvSize.setAdapter(adapter);
        gvSize.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.selectedPosition(position);
                adapter.notifyDataSetChanged();
            }
        });
        return view;

    }


}