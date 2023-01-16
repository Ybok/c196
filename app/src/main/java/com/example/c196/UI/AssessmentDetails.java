package com.example.c196.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c196.R;
import com.example.c196.database.Repository;
import com.example.c196.entities.Assessment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AssessmentDetails extends AppCompatActivity {

    EditText editAssessmentName;
    EditText editAssessmentType;
    EditText editAssessmentStart;
    EditText editAssessmentEnd;
    EditText editCourseID;

    int assessmentID;
    String assessmentName;
    String assessmentType;
    String assessmentStart;
    String assessmentEnd;
    int courseID;

    Assessment assessment;
    Repository repository;

    DatePickerDialog.OnDateSetListener startDate;
    DatePickerDialog.OnDateSetListener endDate;
    final Calendar myCalendarStart = Calendar.getInstance();
    final Calendar myCalendarEnd = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_details);

        editCourseID = findViewById(R.id.associatedcourse);
        editAssessmentName = findViewById(R.id.assessmentname);
        editAssessmentType = findViewById(R.id.assessmenttype);
        editAssessmentStart = findViewById(R.id.assessmentstart);
        editAssessmentEnd = findViewById(R.id.assessmentend);

        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        String currentDate = sdf.format(new Date());

        assessmentID = getIntent().getIntExtra("id", -1);
        assessmentName = getIntent().getStringExtra("title");
        assessmentType = getIntent().getStringExtra("type");
        assessmentStart = getIntent().getStringExtra("startDate");
        assessmentEnd = getIntent().getStringExtra("endDate");
        courseID = getIntent().getIntExtra("courseID", -1);
        editCourseID.setText(String.valueOf(courseID));
        editAssessmentName.setText(assessmentName);
        editAssessmentType.setText(assessmentType);
        editAssessmentStart.setText(assessmentStart);
        editAssessmentEnd.setText(assessmentEnd);

        repository = new Repository(getApplication());
        Button button=findViewById(R.id.saveassessment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(assessmentID==-1) {
                    assessment = new Assessment(0, editAssessmentName.getText().toString(), editAssessmentType.getText().toString(), editAssessmentStart.getText().toString(), editAssessmentEnd.getText().toString(), Integer.parseInt(String.valueOf(editCourseID.getText())));
                    repository.insertAssessment(assessment);
                } else {
                    assessment = new Assessment(assessmentID, editAssessmentName.getText().toString(), editAssessmentType.getText().toString(), editAssessmentStart.getText().toString(), editAssessmentEnd.getText().toString(),  Integer.parseInt(String.valueOf(editCourseID.getText())));
                    repository.updateAssessment(assessment);
                }
                Intent intent=new Intent(AssessmentDetails.this, Assessments.class);
                startActivity(intent);
            }
        });


        editAssessmentStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editAssessmentStart.getText().toString();
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(AssessmentDetails.this, startDate, myCalendarStart.get(Calendar.YEAR),
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


        editAssessmentEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editAssessmentEnd.getText().toString();
                try {
                    myCalendarEnd.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(AssessmentDetails.this, endDate, myCalendarEnd.get(Calendar.YEAR),
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

        editAssessmentStart.setText(sdf.format(myCalendarStart.getTime()));
    }

    private void updateLabelEnd() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editAssessmentEnd.setText(sdf.format(myCalendarEnd.getTime()));
    }
}
