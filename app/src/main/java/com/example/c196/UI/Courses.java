package com.example.c196.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c196.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Courses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton3);
//        courseAdapter.setCourses(allCourses);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Courses.this, CourseDetails.class);
                startActivity(intent);
            }
        });
    }
}