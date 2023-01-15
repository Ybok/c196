package com.example.c196.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c196.R;
import com.example.c196.database.Repository;
import com.example.c196.entities.Assessment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Assessments extends AppCompatActivity {

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessments);

        RecyclerView recyclerView = findViewById(R.id.assessmentrecyclerview);
        final AssessmentAdapter assessmentAdapter = new AssessmentAdapter(this);
        recyclerView.setAdapter(assessmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        repository = new Repository(getApplication());
        List<Assessment> allAssessments = repository.getAssessments();

        FloatingActionButton fab = findViewById(R.id.floatingActionButton5);
        assessmentAdapter.setAssessments(allAssessments);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Assessments.this, AssessmentDetails.class);
                startActivity(intent);
            }
        });
    }
}