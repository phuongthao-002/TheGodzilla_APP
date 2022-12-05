package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.models.Wishlist_models;
import com.example.thegodzilla_app.R;

import java.util.ArrayList;

public class WishlistAdapter extends BaseAdapter {
    Activity activity;
    int item_wishlist;
    ArrayList<Wishlist_models> wishlists;

    public WishlistAdapter(Activity activity, int item_wishlist, ArrayList<Wishlist_models> wishlists) {
        this.activity = activity;
        this.item_wishlist = item_wishlist;
        this.wishlists = wishlists;
    }


    @Override
    public int getCount() {
        return wishlists.size();
    }

    @Override
    public Object getItem(int i) {
        return wishlists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null)
        {
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_wishlist,null);
            holder.imvThumb = view.findViewById(R.id.imvThumb1);
            holder.txtname=view.findViewById(R.id.txtName1);
            holder.txtprice=view.findViewById(R.id.txtPrice1);
//            holder.txtsold=view.findViewById(R.id.txt_Sold);
            view.setTag(holder);
        }
        else
        {
            holder =(ViewHolder) view.getTag();
        }


        Wishlist_models b = wishlists.get(i);
        holder.imvThumb.setImageResource(b.getProductThumb());
        holder.txtname.setText(b.getProductName());
        holder.txtprice.setText(b.getProductPrice());
//        holder.txtsold.setText(b.getProductSold());
        return view;


    }
    public static class ViewHolder
    {
        ImageView imvThumb;
        TextView txtname,txtprice,txtsold;
    }
}
