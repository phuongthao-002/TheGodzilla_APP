package com.example.thegodzilla_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
public class SplashScreen extends AppCompatActivity {
    Animation fadein,zoomout;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags((WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON));
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        setContentView(R.layout.activity_splash_screen);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        zoomout = AnimationUtils.loadAnimation(this,R.anim.zoom_out);

        logo = findViewById(R.id.logo);
        logo.setAnimation(fadein);
        logo.setAnimation(zoomout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, LogIn.class));
                finish();
            }
        }, 2000);

    }
}