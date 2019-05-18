package com.example.user.thirdtask.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.user.thirdtask.model.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM student")
    List<Student> getAllStudents();

    @Query("SELECT * FROM student WHERE ID = (SELECT MAX(id) FROM student)")
    Student getLastStudent();

    @Query("DELETE FROM student")
    void clearTable();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Student... students);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);
}