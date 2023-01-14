package com.example.c196.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196.R;
import com.example.c196.database.Repository;
import com.example.c196.entities.Course;
import com.example.c196.entities.Term;

import java.util.ArrayList;
import java.util.List;

public class TermDetails extends AppCompatActivity {

    TextView listTermID;
    EditText editTermName;
    EditText editTermStart;
    EditText editTermEnd;
    int termID;
    String termName;
    String termStart;
    String termEnd;
    Term term;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_details);

        listTermID = findViewById(R.id.termid);
        editTermName = findViewById(R.id.termname);
        editTermStart = findViewById(R.id.termstart);
        editTermEnd = findViewById(R.id.termend);
        termID = getIntent().getIntExtra("id", -1);
        termName = getIntent().getStringExtra("name");
        termStart = getIntent().getStringExtra("startDate");
        termEnd = getIntent().getStringExtra("endDate");
        listTermID.setText(String.valueOf(termID));
        editTermName.setText(termName);
        editTermStart.setText(termStart);
        editTermEnd.setText(termEnd);

        repository = new Repository(getApplication());

        RecyclerView recyclerView = findViewById(R.id.courserecyclerview);
        repository = new Repository(getApplication());
        final CourseAdapter courseAdapter = new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Course> filteredCourses = new ArrayList<>();
        for (Course c : repository.getCourses()) {
            if (c.getTermID() == termID) filteredCourses.add(c);
        }
        courseAdapter.setCourses(filteredCourses);

        Button button=findViewById(R.id.saveterm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(termID==-1) {
                    term = new Term(0, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
                    repository.insertTerm(term);
                } else {
                    term = new Term(termID, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
                    repository.updateTerm(term);
                }
                Intent intent=new Intent(TermDetails.this, Terms.class);
                startActivity(intent);
            }
        });

        Button fab=findViewById(R.id.button2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TermDetails.this, CourseDetails.class);
                startActivity(intent);
            }
        });

    }
}