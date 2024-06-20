package com.example.gymtrainer.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymtrainer.AbsActivity;
import com.example.gymtrainer.Barbell;
import com.example.gymtrainer.BarbellFront;
import com.example.gymtrainer.BicepCurl;
import com.example.gymtrainer.Chestwork1;
import com.example.gymtrainer.Chestwork2;
import com.example.gymtrainer.Chestwork3;
import com.example.gymtrainer.Chestwork4;
import com.example.gymtrainer.CrossCrunches;
import com.example.gymtrainer.CrossSquats;
import com.example.gymtrainer.Crunches;
import com.example.gymtrainer.DumbellBicepCurl;
import com.example.gymtrainer.DumbellReverse;
import com.example.gymtrainer.DumbellSeated;
import com.example.gymtrainer.HeelTouches;
import com.example.gymtrainer.JumpSquats;
import com.example.gymtrainer.KneeTouches;
import com.example.gymtrainer.PrisonerSquats;
import com.example.gymtrainer.R;
import com.example.gymtrainer.TicepActivity2;
import com.example.gymtrainer.TriceoActivity4;
import com.example.gymtrainer.TricepActivity1;
import com.example.gymtrainer.TricepActivity3;
import com.example.gymtrainer.WallSit;
import com.example.gymtrainer.models.ItemModel;

import java.util.List;

public class AbsAdapter extends RecyclerView.Adapter<AbsAdapter.ViewHolder> {

    private List<ItemModel> data;
    private Context context;

    public AbsAdapter(Context context, List<ItemModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.absgym, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel item = data.get(position);

        // Set text
        holder.textView.setText(item.getText());

        // Set image
        holder.imageView.setImageResource(item.getImageResource());

        // Handle click on the image
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Determine which image was clicked and start the corresponding activity
                if (item.getImageResource() == R.drawable.crunches) {
                    Intent intent = new Intent(context, Crunches.class);
                    context.startActivity(intent);
                }
                else if (item.getImageResource() == R.drawable.helltouchepng) {
                    Intent intent = new Intent(context, HeelTouches.class);
                    context.startActivity(intent);
                }
                else if (item.getImageResource() == R.drawable.crosscrunchespng) {
                    Intent intent = new Intent(context, CrossCrunches.class);
                    context.startActivity(intent);
                }
                else if (item.getImageResource() == R.drawable.bicepcurl) {
                    Intent intent = new Intent(context, BicepCurl.class);
                    context.startActivity(intent);
                }
                else if (item.getImageResource() == R.drawable.dbicepcurl) {
                    Intent intent = new Intent(context, DumbellBicepCurl.class);
                    context.startActivity(intent);
                }
                else if (item.getImageResource() == R.drawable.crosssquat) {
                    Intent intent = new Intent(context, CrossSquats.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.prisonersqauts) {
                    Intent intent = new Intent(context, PrisonerSquats.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.barbelluprightrow) {
                    Intent intent = new Intent(context, Barbell.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.barbellfrontraise) {
                    Intent intent = new Intent(context, BarbellFront.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.kneelinepushup) {
                    Intent intent = new Intent(context, Chestwork1.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.diamondpushup) {
                    Intent intent = new Intent(context, Chestwork2.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.pushups) {
                    Intent intent = new Intent(context, Chestwork3.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.reverseknelling) {
                    Intent intent = new Intent(context, Chestwork4.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.tricep1pic) {
                    Intent intent = new Intent(context, TricepActivity1.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.tricep2pic) {
                    Intent intent = new Intent(context, TicepActivity2.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.tricep3pic) {
                    Intent intent = new Intent(context, TricepActivity3.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.tricep4pic) {
                    Intent intent = new Intent(context, TriceoActivity4.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.kneetouchespic) {
                    Intent intent = new Intent(context, KneeTouches.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.dumbellreversepic) {
                    Intent intent = new Intent(context, DumbellReverse.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.dumbellseatedpic) {
                    Intent intent = new Intent(context, DumbellSeated.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.jumpsquatspic) {
                    Intent intent = new Intent(context, JumpSquats.class);
                    context.startActivity(intent);

                }
                else if (item.getImageResource() == R.drawable.wallsitpic) {
                    Intent intent = new Intent(context, WallSit.class);
                    context.startActivity(intent);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.excercisetext);
            imageView = itemView.findViewById(R.id.exerciseimage);
        }
    }
}