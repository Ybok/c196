package com.example.c196.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c196.R;
import com.example.c196.database.Repository;
import com.example.c196.entities.Course;

public class CourseDetails extends AppCompatActivity {

    EditText editTermID;
    EditText editCourseName;
    EditText editCourseStart;
    EditText editCourseEnd;
    EditText editCourseStatus;
    EditText editCourseNotes;

    int courseID;
    String courseName;
    String courseStart;
    String courseEnd;
    String courseStatus;
    String courseNotes;
    int termID;

    Course course;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        editTermID = findViewById(R.id.associatedterm);
        editCourseName = findViewById(R.id.coursename);
        editCourseStart = findViewById(R.id.coursestart);
        editCourseEnd = findViewById(R.id.courseend);
        editCourseStatus = findViewById(R.id.coursestatus);
        editCourseNotes = findViewById(R.id.coursenotes);
        courseID = getIntent().getIntExtra("id", -1);
        courseName = getIntent().getStringExtra("title");
        courseStart = getIntent().getStringExtra("startDate");
        courseEnd = getIntent().getStringExtra("endDate");
        courseStatus = getIntent().getStringExtra("status");
        courseNotes = getIntent().getStringExtra("notes");
        termID = getIntent().getIntExtra("termID", -1);
        editTermID.setText(String.valueOf(termID));
        editCourseName.setText(courseName);
        editCourseStart.setText(courseStart);
        editCourseEnd.setText(courseEnd);
        editCourseStatus.setText(courseStatus);
        editCourseNotes.setText(courseNotes);

        repository = new Repository(getApplication());
        Button button=findViewById(R.id.savecourse);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(courseID==-1) {
                    course = new Course(0, editCourseName.getText().toString(), editCourseStart.getText().toString(), editCourseEnd.getText().toString(), editCourseStatus.getText().toString(), editCourseNotes.getText().toString(), Integer.parseInt(String.valueOf(editTermID.getText())));
                    repository.insertCourse(course);
                } else {
                    course = new Course(courseID, editCourseName.getText().toString(), editCourseStart.getText().toString(), editCourseEnd.getText().toString(), editCourseStatus.getText().toString(), editCourseNotes.getText().toString(), Integer.parseInt(String.valueOf(editTermID.getText())));
                    repository.updateCourse(course);
                }
                Intent intent=new Intent(CourseDetails.this, Courses.class);
                startActivity(intent);
            }
        });

    }

}
