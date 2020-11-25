package com.example.zoolearning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zoolearning.model.Animal;
import com.example.zoolearning.model.AnimalDAO;
import com.example.zoolearning.model.Converter;
import com.example.zoolearning.model.Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddAnimalActivity extends AppCompatActivity {

    ImageView animalPicture;
    Bitmap bmpImage;
    EditText thainame, engname, sciname;

    AnimalDAO animalDAO;

    Animal animal;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        animalPicture = findViewById(R.id.show_exmple_picture_text_view);
        bmpImage = null;

        thainame = findViewById(R.id.enter_thai_name_edit_view);
        engname = findViewById(R.id.enter_eng_name_edit_view);
        sciname = findViewById(R.id.enter_sci_name_edit_view);

        animalDAO = Database.getDBInstance(this).animalDao();

    }

    final int CAMERA_INTENT = 51;
    //take picture button
    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent, CAMERA_INTENT);
        }
    }
    //แสดงภาพที่บันทึกได้
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CAMERA_INTENT:
//                if(requestCode == Activity.RESULT_OK){
                bmpImage = (Bitmap) data.getExtras().get("data");
                if(bmpImage != null){
                    animalPicture.setImageBitmap(bmpImage);
                } else {
                    Toast.makeText(this,"Bitmap is null",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    //save button
    public void saveAnimal(View view) {//เช็คว่ากรอกข้อมูลครบหรือไม่
        if(thainame.getText().toString().isEmpty() || engname.getText().toString().isEmpty() || sciname.getText().toString().isEmpty() || bmpImage == null){
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show();
        } else {//ถ้าครบแล้วสร้างก้อน object

            animal = new Animal();

            animal.setThainame(thainame.getText().toString());
            animal.setEngname(engname.getText().toString());
            animal.setSciname(sciname.getText().toString());
            animal.setPicture(Converter.convertImage2ByteArray(bmpImage));

            animalDAO.insertAnimal(animal);

            Toast.makeText(this,"จัดเก็บข้อมูลเรียบร้อย", Toast.LENGTH_SHORT).show();
        }
    }
    //show animal button
    public void showAnimal(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}