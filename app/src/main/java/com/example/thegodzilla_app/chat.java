package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.adapter.MessageAdapter;
import com.example.models.Message;

import java.util.ArrayList;
import java.util.List;

public class chat extends AppCompatActivity {
    private EditText edtMessage;
    private Button btnSend;
    private RecyclerView rcvMessage;
    private MessageAdapter messageAdapter;
    private List<Message> ListMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        edtMessage = findViewById(R.id.edt_chat_mess);
        btnSend = findViewById(R.id.btn_chat_send);
        rcvMessage = findViewById(R.id.rev_chat);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvMessage.setLayoutManager(linearLayoutManager);

        ListMessage = new ArrayList<>();
        messageAdapter = new MessageAdapter();
        messageAdapter.setData(ListMessage);
        rcvMessage.setAdapter(messageAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }

            private void sendMessage() {
                String strMessage = edtMessage.getText().toString().trim();
                if(TextUtils.isEmpty(strMessage)){
                    return;
                }
                ListMessage.add(new Message(strMessage));
                messageAdapter.notifyDataSetChanged();
                rcvMessage.scrollToPosition(ListMessage.size() -1);
                edtMessage.setText("");
            }
        });

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_chat);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        };
        return super.onOptionsItemSelected(item);
    }
}