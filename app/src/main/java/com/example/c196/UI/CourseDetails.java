package com.example.c196.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196.R;
import com.example.c196.database.Repository;
import com.example.c196.entities.Assessment;
import com.example.c196.entities.Course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    DatePickerDialog.OnDateSetListener startDate;
    DatePickerDialog.OnDateSetListener endDate;
    final Calendar myCalendarStart = Calendar.getInstance();
    final Calendar myCalendarEnd = Calendar.getInstance();

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

        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        String currentDate = sdf.format(new Date());

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

        RecyclerView recyclerView = findViewById(R.id.assessmentrecyclerview);
        repository = new Repository(getApplication());
        final AssessmentAdapter assessmentAdapter = new AssessmentAdapter(this);
        recyclerView.setAdapter(assessmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Assessment> filteredAssessments = new ArrayList<>();
        for (Assessment c : repository.getAssessments()) {
            if (c.getCourseID() == courseID) filteredAssessments.add(c);
        }
        assessmentAdapter.setAssessments(filteredAssessments);

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


        editCourseStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editCourseStart.getText().toString();
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(CourseDetails.this, startDate, myCalendarStart.get(Calendar.YEAR),
                        myCalendarStart.get(Calendar.MONTH), myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        startDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int startYear, int startMonth, int startDay) {
                myCalendarStart.set(Calendar.YEAR, startYear);
                myCalendarStart.set(Calendar.MONTH, startMonth);
                myCalendarStart.set(Calendar.DAY_OF_MONTH, startDay);
                updateLabelStart();
            }
        };


        editCourseEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editCourseEnd.getText().toString();
                try {
                    myCalendarEnd.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(CourseDetails.this, endDate, myCalendarEnd.get(Calendar.YEAR),
                        myCalendarEnd.get(Calendar.MONTH), myCalendarEnd.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        endDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int endYear, int endMonth, int endDay) {
                myCalendarEnd.set(Calendar.YEAR, endYear);
                myCalendarEnd.set(Calendar.MONTH, endMonth);
                myCalendarEnd.set(Calendar.DAY_OF_MONTH, endDay);
                updateLabelEnd();
            }
        };

    }

    private void updateLabelStart() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editCourseStart.setText(sdf.format(myCalendarStart.getTime()));
    }

    private void updateLabelEnd() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editCourseEnd.setText(sdf.format(myCalendarEnd.getTime()));
    }

}
