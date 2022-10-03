package com.example.tt.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.tt.R;
import com.example.tt.common.LoginSignUp.Startup;
import com.example.tt.helper_classes.Homeadapter.FeaturedAdapter;
import com.example.tt.helper_classes.Homeadapter.FeaturedHelperClass;
import com.example.tt.helper_classes.Homeadapter.MostAdapter;
import com.example.tt.helper_classes.Homeadapter.MostBoughtHelperClass;

import java.util.ArrayList;
import java.util.Objects;

public class UserDashboard extends AppCompatActivity {
    //assign variables
RecyclerView featuredrecycler;
RecyclerView mostrecycler;
RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove app bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.user_dashboard);

        //hooks
        featuredrecycler = findViewById(R.id.featured_recycler);
        mostrecycler = findViewById(R.id.most_bought);


        featuredRecycler();
   mostRecycler();
    }

    private void featuredRecycler(){
        featuredrecycler.setHasFixedSize(true);
        featuredrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.cards1,"Cooked Food"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.cards2,"Grilled Food"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.cards3,"Crunch Food"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.cards4,"Spicy Food"));

adapter = new FeaturedAdapter(featuredLocations);
featuredrecycler.setAdapter(adapter);
    }
    private void  mostRecycler(){
        mostrecycler.setHasFixedSize(true);
        mostrecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        ArrayList<MostBoughtHelperClass> mostBoughtLocations = new ArrayList<>();
        mostBoughtLocations.add(new MostBoughtHelperClass(R.drawable.cards1,"Cooked Food"));
        mostBoughtLocations.add(new MostBoughtHelperClass(R.drawable.cards2,"Grilled Food"));
        mostBoughtLocations.add(new MostBoughtHelperClass(R.drawable.cards3,"Crunch Food"));
        mostBoughtLocations.add(new MostBoughtHelperClass(R.drawable.cards4,"Spicy Food"));

        adapter = new MostAdapter(mostBoughtLocations);
       mostrecycler.setAdapter(adapter);
    }

public  void callRetailerScreens(View view){
startActivity(new Intent(getApplicationContext(), Startup.class));
}


}