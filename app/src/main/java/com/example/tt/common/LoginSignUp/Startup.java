package com.example.tt.common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.tt.R;

import java.util.Objects;

public class Startup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_startup2);

    }
    public  void callLoginScreen(View view){
        startActivity(new Intent(getApplicationContext(), Login_Activity.class));
    }
    public  void callSignUpScreen(View view){
        startActivity(new Intent(getApplicationContext(), Signup.class));
    }
}