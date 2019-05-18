package com.example.user.thirdtask.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo
    public String fio;
    @ColumnInfo
    public String date;

    public Student(String fio, String date) {
        this.fio = fio;
        this.date = date;
    }
}