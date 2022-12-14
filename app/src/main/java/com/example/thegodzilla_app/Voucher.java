package com.example.thegodzilla_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.VoucherAdapter;
import com.example.models.Vouchers;

import java.util.ArrayList;

public class Voucher extends AppCompatActivity
{
    Button btnback;
    ListView lvVoucher;
    VoucherAdapter adapter;
    ArrayList<Vouchers> vouchers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        linkViews();
        addEvent();
        loadData();
        intData();

    }

    private void intData()
    {
        vouchers = new ArrayList<>();
        vouchers.add(new com.example.models.Vouchers(R.drawable.logoconverse,"CONVERSE","Buy "));
        vouchers.add(new com.example.models.Vouchers(R.drawable.logobalenciaga,"BALENCIAGA","Sale off 10% for women items"));
        vouchers.add(new com.example.models.Vouchers(R.drawable.logonike_voucher,"NIKE","Sale off 10% all products."));

    }

    private void loadData()
    {
        adapter = new VoucherAdapter(this,R.layout.item_voucher_list,vouchers);
        lvVoucher.setAdapter(adapter);
    }

    private void addEvent()
    {
//        btnback.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
    }

    private void linkViews()
    {
        lvVoucher=findViewById(R.id.lv_voucher);
        btnback =findViewById(R.id.btn_backhome);
    }
    public void btngetvoucher(Button btnVoucher)
    {
        btnVoucher.setBackgroundColor(this.getResources().getColor(R.color.grey));
        btnVoucher.setTextColor(this.getResources().getColor(R.color.darkblue));
        Toast.makeText(Voucher.this,"Use it when making payment", Toast.LENGTH_SHORT).show(); }

//    @Override
//    public void btnclick(Vouchers voucher)
//    {
//        Toast.makeText(this, "Use this voucher when making payment", Toast.LENGTH_SHORT).show();
//    }

}