package com.example.thegodzilla_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.Interface.MyBtnVoucherClick;
import com.example.adapter.CheckoutAdapter;
import com.example.adapter.VoucherAdapter;
import com.example.models.Product1;
import com.example.models.TranInf;
import com.example.models.Vouchers;
import com.example.thegodzilla_app.databinding.ActivityCheckoutBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class CheckOut extends AppCompatActivity implements MyBtnVoucherClick
{
    ActivityCheckoutBinding binding;
    CheckoutAdapter adapter;
    ArrayList<Product1> product1s;
    BottomSheetDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_checkout);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.txtCheckoutAddress.setText(TranInf.AddressInf);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_checkout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        loadData();
        addEvent();

//        Intent i = getIntent();
//        binding.txtCheckoutAddress.getText(i.getStringExtra("name"));


    }

    private void addEvent()
    {
//        binding.btnBackhome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
        binding.btnEditAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CheckOut.this, Address.class);
                startActivity(intent);

            }
        });
        binding.txtRedeem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog = new BottomSheetDialog(CheckOut.this);
                dialog.setContentView(R.layout.layout_popup_myvoucher);
                ListView lvVoucher = dialog.findViewById(R.id.lvMyvoucherPopUp);
                VoucherAdapter adapter;
                ArrayList<Vouchers> vouchers;
                vouchers = new ArrayList<>();
                vouchers.add(new Vouchers(R.drawable.logoconverse,"CONVERSE","BUY 1 GET 1"));
                vouchers.add(new Vouchers(R.drawable.logobalenciaga,"BALENCIAGA","Sale off 10%"));
                vouchers.add(new Vouchers(R.drawable.logonike_voucher,"NIKE","Sale off 10% "));
                adapter = new VoucherAdapter(CheckOut.this,R.layout.item_voucher_list,vouchers);
                lvVoucher.setAdapter(adapter);
                dialog.show();
            }
        });
        binding.txtEditDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Dialog dialogDelivery = new Dialog(CheckOut.this);
                dialogDelivery.setContentView(R.layout.layout_popup_delivery);
                dialogDelivery.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayout llStandard, llFast, ll24h;
                llStandard = dialogDelivery.findViewById(R.id.llStandard);
                llFast = dialogDelivery.findViewById(R.id.llFast);
                ll24h = dialogDelivery.findViewById(R.id.ll24h);
                switchDeliveryMethod(ll24h, llStandard, llFast , dialogDelivery);
                dialogDelivery.show();
            }

        });

        binding.btnMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckOut.this, MomoMethod.class);
                startActivity(intent);
            }
        });
        binding.btnPaymentmethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckOut.this, Paymentmethod.class);
                startActivity(intent);
            }
        });

        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckOut.this, OrderSuccess.class);
                startActivity(intent);
            }
        });


    }
    private void switchDeliveryMethod(LinearLayout ll24h, LinearLayout llStandard, LinearLayout llFast, Dialog dialogDelivery) {
        llStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtEditDelivery.setText("Standard Delivery");
                binding.txtPriceDelivery.setText("3$");
                binding.imvDelivery.setImageResource(R.drawable.standard_deli);
                dialogDelivery.cancel();
            }
        });

        llFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtPriceDelivery.setText("Fast Delivery");
                binding.txtPriceDelivery.setText("5$");
                binding.imvDelivery.setImageResource(R.drawable.fast_deli);
                dialogDelivery.cancel();
            }
        });

        ll24h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.txtEditDelivery.setText("24h Delivery");
                binding.txtPriceDelivery.setText("10$");
                binding.imvDelivery.setImageResource(R.drawable.deli_24h);
                dialogDelivery.cancel();
            }
        });
    }

    private void loadData()
    {
        product1s = new ArrayList<>();
        product1s.add(new Product1(R.drawable.puma,"Puma","Shoes fashion","180000","2"));
        product1s.add(new Product1(R.drawable.logoconverse,"Converse","Shoes fashion","190000","3"));
        adapter = new CheckoutAdapter(CheckOut.this,R.layout.item_checkout_list, product1s);
        binding.lvproductCheckout.setAdapter(adapter);
    }


    @Override
    public void btnclick(Vouchers voucher)
    {
        binding.txtRedeem.setText(voucher.getTxtTitle());
        dialog.dismiss();
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