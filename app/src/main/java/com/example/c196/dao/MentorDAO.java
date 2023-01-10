package com.example.c196.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.c196.entities.Mentor;

import java.util.List;

@Dao
public interface MentorDAO {
    @Insert
    void insertMentor(Mentor mentor);

    @Update
    void updateMentor(Mentor mentor);

    @Delete
    void deleteMentor(Mentor mentor);

    @Query("SELECT * FROM mentors")
    List<Mentor> getMentors();
}
