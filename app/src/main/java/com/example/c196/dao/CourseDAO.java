package com.example.c196.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.c196.entities.Course;

import java.util.List;

@Dao
public interface CourseDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCourse(Course course);

    @Update()
    void updateCourse(Course course);

    @Delete
    void deleteCourse(Course course);

    @Query("SELECT * FROM courses ORDER BY courseID ASC")
    List<Course> getCourses();
}
