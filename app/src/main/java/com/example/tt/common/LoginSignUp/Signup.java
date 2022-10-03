package com.example.tt.common.LoginSignUp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tt.BackgroundTask;
import com.example.tt.R;
import com.example.tt.user.UserDashboard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Signup extends AppCompatActivity {
    private Button btnRegi;

    private EditText etname, etemail, etcontact, etpassword, etconfirmpassword;
    private String URL = "http://10.0.2.2/Example/register.php";
    private String name, email, contact, password, confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_signup);
        btnRegi = (Button) findViewById(R.id.regi_btn);
        etname = (EditText) findViewById(R.id.txt_user);
        etemail = (EditText) findViewById(R.id.txt_email);
        etcontact = (EditText) findViewById(R.id.txt_no);
        etpassword = (EditText) findViewById(R.id.txt_pass);
        etconfirmpassword = (EditText) findViewById(R.id.txt_repass);
        name = email= contact =password=confirmpassword = "";




    }
    public void save(View view){
        name = etname.getText().toString().trim();
        email = etemail.getText().toString().trim();
        password = etpassword.getText().toString().trim();
        contact = etcontact.getText().toString().trim();
        confirmpassword = etconfirmpassword.getText().toString().trim();

        if(!password.equals(confirmpassword)){
            Toast.makeText(this,"Password Mismatch",Toast.LENGTH_SHORT).show();
        }
        else if (!name.equals("") && !contact.equals("")  && !email.equals("") && !password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("success")) {
                      btnRegi.setClickable(false);
                        Toast.makeText(Signup.this, "Register Completed", Toast.LENGTH_SHORT).show();

                    } else if (response.equals("failure")) {
                        Toast.makeText(Signup.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> data = new HashMap<>();

                    data.put("name",name);
                    data.put("contact",contact);
                    data.put("email",email);
                    data.put("password",password);


                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }

    }

    public void callback(View view) {
        startActivity(new Intent(getApplicationContext(), Startup.class));
    }

    public void callnext(View view) {
        startActivity(new Intent(getApplicationContext(), Signup2.class));
    }

    public void returnlogin(View view) {
        startActivity(new Intent(getApplicationContext(), Login_Activity.class));
    }
}