package com.example.tt.helper_classes.Homeadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tt.R;

import java.util.ArrayList;

public class MostAdapter extends RecyclerView.Adapter<MostAdapter.MostViewHolder> {

ArrayList<MostBoughtHelperClass> mostBoughtLocations;

    public MostAdapter(ArrayList<MostBoughtHelperClass> mostBoughtLocations) {
        this.mostBoughtLocations = mostBoughtLocations;
    }

    @NonNull
    @Override
    public MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
       MostAdapter.MostViewHolder mostViewHolder = new MostViewHolder(view);




        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewHolder holder, int position) {
MostBoughtHelperClass mostBoughtHelperClass = mostBoughtLocations.get(position);
holder.image.setImageResource(mostBoughtHelperClass.getImage());
holder.title.setText(mostBoughtHelperClass.getTitle());
    }

    @Override
    public int getItemCount() {
        return mostBoughtLocations.size();
    }

    public static  class MostViewHolder extends RecyclerView.ViewHolder{
ImageView image;
TextView title;
    public MostViewHolder(@NonNull View itemView) {
        super(itemView);

        //hooks

        image = itemView.findViewById(R.id.mv_image);
        title = itemView.findViewById(R.id.mv_title);


    }
}


}
