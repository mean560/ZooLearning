package com.example.zoolearning;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoolearning.model.Animal;
import com.example.zoolearning.model.Converter;

import java.util.List;

public class AnimalRecycler extends RecyclerView.Adapter<AnimalViewHolder> {

    List<Animal> data;

    public AnimalRecycler (List<Animal> animals){
        data = animals;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);
        return new AnimalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = data.get(position);
        holder.animalImageView.setImageBitmap(Converter.convertByteArray2Image(animal.getPicture()));
        holder.animalThaiName.setText(animal.getThainame());
        holder.animalEngName.setText(animal.getEngname());
        holder.animalSciName.setText(animal.getSciname());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
