package com.example.tt.common.LoginSignUp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tt.R;
import com.example.tt.user.UserDashboard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Login_Activity extends AppCompatActivity {
private EditText etEmail,etPassword;
private  String email,password;
private  String URL = "http://10.0.2.2/Example/conn.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_login);
        email = password = "";
        etEmail = findViewById(R.id.ename);
        etPassword = findViewById(R.id.epass);


    }
    public void login(View view){
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        if(!email.equals("") && !password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("success")) {
                        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                        finish();

                    } else if (response.equals("failure")) {
                        Toast.makeText(Login_Activity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Login_Activity.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> data = new HashMap<>();
                    data.put("email",email);
                    data.put("password",password);


                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }else{
            Toast.makeText(Login_Activity.this, "Feilds cannot be empty!", Toast.LENGTH_SHORT).show();
        }

    }



    public  void callback(View view){
        startActivity(new Intent(getApplicationContext(), Startup.class));
    }
    public  void returnsignup(View view){
        startActivity(new Intent(getApplicationContext(), Signup.class));
    }

}