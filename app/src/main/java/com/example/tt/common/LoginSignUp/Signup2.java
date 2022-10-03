package com.example.tt.common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.tt.R;
import com.example.tt.common.LoginSignUp.Signup;
import com.example.tt.user.UserDashboard;

import java.util.Objects;

public class Signup2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_signup2);
    }
    public  void callbacklogin(View view){
        startActivity(new Intent(getApplicationContext(), Signup.class));
    }
    public  void godashboard(View view){
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
    }
}