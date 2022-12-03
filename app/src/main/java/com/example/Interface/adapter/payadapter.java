package com.example.Interface.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.models.pay;
import com.example.thegodzilla_app.R;

import java.util.List;

public class payadapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<pay> pays;

    public payadapter(Activity activity, int item_layout, List<pay> pays) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.pays = pays;
    }

    @Override
    public int getCount() {
        return pays.size();
    }

    @Override
    public Object getItem(int i) {
        return pays.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view ==null){
            //link view
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.paymethThumb = view.findViewById(R.id.imv_paymethod_Thumb);
            holder.paymethName = view.findViewById(R.id.txt_paymethod_Name);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //binding data
        pay b = pays.get(i);
        holder.paymethThumb.setImageResource(b.getPaymeThumb());
        holder.paymethName.setText(b.getPaymeName());
        return view;
    }
    public static class ViewHolder{
        ImageView paymethThumb;
        TextView paymethName;
    }
}
