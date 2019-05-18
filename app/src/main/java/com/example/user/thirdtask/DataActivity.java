package com.example.user.thirdtask;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.thirdtask.adapters.RecyclerViewAdapter;
import com.example.user.thirdtask.database.AppDatabase;

public class DataActivity extends AppCompatActivity {

    AppDatabase db;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        db = Room.databaseBuilder(this, AppDatabase.class, "studentDB")
                .allowMainThreadQueries()
                .build();

        recyclerView = findViewById(R.id.students_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(db.studentDao().getAllStudents()));
    }
}
