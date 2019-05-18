package com.example.user.thirdtask;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.user.thirdtask.database.AppDatabase;
import com.example.user.thirdtask.model.Student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    Button edit;
    Button show;
    Button add;
    String[] fio = {"Лаврентьева Ирина Сергеевна", "Сталин Иосиф Виссарионович", "Цветаева Марина Ивановна","Ленин Владимир Ильич", "Романова Елизавета Петровна"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(this, AppDatabase.class, "studentDB")
                .allowMainThreadQueries()
                .build();

        add = findViewById(R.id.add);
        show = findViewById(R.id.show);
        edit = findViewById(R.id.edit);

        db.studentDao().clearTable();
        for (int i = 0; i< 5; i++ ) db.studentDao().add(new Student(fio[new Random().nextInt(5)], generateDate()));

        edit.setOnClickListener(view -> {
            Student last = db.studentDao().getLastStudent();
            last.fio = "Иванов Иван Иванович";
            db.studentDao().update(last);
        });

        show.setOnClickListener(view ->{
            startActivity(new Intent(this, DataActivity.class));
        });

        add.setOnClickListener(view -> {
            db.studentDao().add(new Student(fio[new Random().nextInt(5)], generateDate()));
        });
    }

    String generateDate(){
        SimpleDateFormat format = new SimpleDateFormat("hh:mm", Locale.getDefault());
        format.setLenient(false);
        Date curDate = new Date();
        return format.format(curDate);
    }
}
