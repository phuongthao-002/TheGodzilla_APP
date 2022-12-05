package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Productcart;
import com.example.thegodzilla_app.R;

import java.util.ArrayList;
import java.util.List;

public class cart_adapter extends BaseAdapter
{
 Activity activity;
 int item_layput;
 List<Productcart> productcarts;

    public cart_adapter(Activity activity, int item_layput, List<Productcart> productcarts) {
        this.activity = activity;
        this.item_layput = item_layput;
        this.productcarts = productcarts;
    }

    @Override
    public int getCount() {
        return productcarts.size();
    }

    @Override
    public Object getItem(int i) {
        return productcarts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null)
        {
            //Link views
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layput,null);
            holder.imvThumb=view.findViewById(R.id.imvThumb_cart);
            holder.txtName = view.findViewById(R.id.txtName_cart);
            view.setTag(holder);

        } else
        {
            holder = (ViewHolder) view.getTag();
        }

        //Binding data
        Productcart b  = productcarts.get(i);
        holder.imvThumb.setImageResource(b.getProductThumb());
        holder.txtName.setText(b.getProductName());
        return view;

    }
    public static class ViewHolder
    {
        ImageView imvThumb;
        TextView txtName;

    }
}