package com.example.tt.common;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tt.R;
import com.example.tt.common.LoginSignUp.Startup;
import com.example.tt.user.UserDashboard;

import java.util.Objects;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH_TIMER = 5000;

    //assign variables
    ImageView background;
    TextView logo_name;
    TextView powered_by;

    //animations
    Animation sideanim,bottomanim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove app bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.splash_screen);
        //hooks
        background = findViewById(R.id.background_image);
        logo_name = findViewById(R.id.tasty);
        powered_by = findViewById(R.id.powered_by);

        //animations
        sideanim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //assign animations
        background.setAnimation(sideanim);
        logo_name.setAnimation(sideanim);
        powered_by.setAnimation(bottomanim);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), Startup.class);
            startActivity(intent);
            finish();

        },SPLASH_TIMER);
    }
}