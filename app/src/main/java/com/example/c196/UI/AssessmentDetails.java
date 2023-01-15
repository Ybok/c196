package com.example.c196.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c196.R;
import com.example.c196.database.Repository;
import com.example.c196.entities.Assessment;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_details);

        editCourseID = findViewById(R.id.associatedcourse);
        editAssessmentName = findViewById(R.id.assessmentname);
        editAssessmentType = findViewById(R.id.assessmenttype);
        editAssessmentStart = findViewById(R.id.assessmentstart);
        editAssessmentEnd = findViewById(R.id.assessmentend);
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

    }
}
