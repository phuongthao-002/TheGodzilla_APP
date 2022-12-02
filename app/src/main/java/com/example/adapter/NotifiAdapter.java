package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.models.Notifi;
import com.example.thegodzilla_app.R;

import java.util.List;

public class NotifiAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Notifi> notifis;

    public NotifiAdapter(Activity activity, int item_layout, List<Notifi> notifis) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.notifis = notifis;
    }


    @Override
    public int getCount() {
        return notifis.size();
    }

    @Override
    public Object getItem(int i) {
        return notifis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout,null);
            holder.notifiThumb = view.findViewById(R.id.imv_Notifi_Thumb);
            holder.notifiStatus = view.findViewById(R.id.txt_Notifi_Status);
            view.setTag(holder);
        } else

        {
            holder = (ViewHolder) view.getTag();
        }
        Notifi n = notifis.get(i);
        holder.notifiThumb.setImageResource(n.getNotifiThumb());
        holder.notifiStatus.setText(n.getNotifiStatus());

        return view;
    }
    public class ViewHolder{
        ImageView notifiThumb;
        TextView notifiStatus;


    }
}
