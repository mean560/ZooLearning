package com.example.zoolearning.model;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.Calendar;

@androidx.room.Database(
        entities = Animal.class,
        version = 1,
        exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static Database animalDB = null;

    public abstract AnimalDAO animalDao();

    public static synchronized Database getDBInstance(Context context) {
        if (animalDB == null) {
            animalDB = Room.databaseBuilder(context.getApplicationContext(), Database.class, "animal19b2").allowMainThreadQueries().build();
        }
        return animalDB;
    }
}