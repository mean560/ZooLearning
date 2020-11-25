package com.example.zoolearning;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    ImageView animalImageView;
    TextView animalThaiName, animalEngName, animalSciName;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        animalImageView = itemView.findViewById(R.id.animal_image_view);
        animalThaiName = itemView.findViewById(R.id.thai_name_text_view);
        animalEngName = itemView.findViewById(R.id.eng_name_text_view);
        animalSciName = itemView.findViewById(R.id.sci_name_text_view);
    }
}
