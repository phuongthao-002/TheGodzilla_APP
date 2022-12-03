package com.example.Interface.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Message;
import com.example.thegodzilla_app.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{
    private List<Message> LisrMessage;
    public void setData(List<Message> list){
        this.LisrMessage = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = LisrMessage.get(position);
        if(message == null){
            return;
        }
        holder.tvMessage.setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        if( LisrMessage !=null){
            return LisrMessage.size();
        }
        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{
        private TextView tvMessage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tv_chat_message);
        }
    }
}