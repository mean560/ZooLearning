package com.example.zoolearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zoolearning.model.AnimalDAO;
import com.example.zoolearning.model.Database;

public class MainActivity extends AppCompatActivity {

    RecyclerView animalRecyclerView;

    AnimalDAO animalDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalRecyclerView = findViewById(R.id.animal_recycler_view);

        animalDAO = Database.getDBInstance(this).animalDao();

        AnimalRecycler animalRecycler = new AnimalRecycler(animalDAO.getAllAnimals());

        animalRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        animalRecyclerView.setAdapter(animalRecycler);
        // add button
        Button addAnimalButton = findViewById(R.id.add_animal_button);
        addAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddAnimalActivity.class);
                startActivity(i);
            }
        });

        //ตอนที่เปิดแอปครั้งแรกจะไม่มีข้อมูลที่ถูกบันทึกไว้
        TextView noAnimal = findViewById(R.id.textViewNo);
        if(animalDAO.getAllAnimals().isEmpty()){
            noAnimal.setText("NO ANIMALS");
        } else {
            noAnimal.setText("");
        }

    }
}