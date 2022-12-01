package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Productcart;
import com.example.thegodzilla_app.R;

import java.util.ArrayList;

public class cart_adapter extends RecyclerView.Adapter<cart_adapter.ViewHolder>
{
    ArrayList<Productcart> productcarts;
    Context context;

    public cart_adapter(ArrayList<Productcart> productcarts, Context context) {
        this.productcarts = productcarts;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_cart_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.imghinh.setImageResource(productcarts.get(position).getProductThumb());
        holder.txtname.setText(productcarts.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return productcarts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtname;
        ImageView imghinh;
        public ViewHolder(View itemView) {
            super(itemView);
            txtname = (TextView)itemView.findViewById(R.id.txtName_cart);
            imghinh = (ImageView) itemView.findViewById(R.id.imvThumb_cart);
        }
    }
}