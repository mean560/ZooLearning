package com.example.zoolearning.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Animals")
public class Animal {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "thai_name")
    String thainame;

    @ColumnInfo(name = "eng_name")
    String engname;

    @ColumnInfo(name = "sci_name")
    String sciname;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte[] picture;

    public Animal() {
    }

    public Animal(int id, String thainame, String engname, String sciname) {
        this.id = id;
        this.thainame = thainame;
        this.engname = engname;
        this.sciname = sciname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setThainame(String thainame) {
        this.thainame = thainame;
    }

    public void setEngname(String engname) {
        this.engname = engname;
    }

    public void setSciname(String sciname) {
        this.sciname = sciname;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getThainame() {
        return thainame;
    }

    public String getEngname() {
        return engname;
    }

    public String getSciname() {
        return sciname;
    }

    public byte[] getPicture() {
        return picture;
    }

}
