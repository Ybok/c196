package com.example.c196.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c196.R;
import com.example.c196.database.BikeRepository;
import com.example.c196.database.Repository;
import com.example.c196.entities.Product;
import com.example.c196.entities.Term;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TermDetails extends AppCompatActivity {

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

        editTermName = findViewById(R.id.termname);
        editTermStart = findViewById(R.id.termstart);
        editTermEnd = findViewById(R.id.termend);
        //spelled same as adapter. default if number
        termID = getIntent().getIntExtra("id", -1);
        termName = getIntent().getStringExtra("name");
        termStart = getIntent().getStringExtra("startDate");
        termEnd = getIntent().getStringExtra("endDate");
        editTermName.setText(termName);
        editTermStart.setText(termStart);
        editTermEnd.setText((termEnd));

        repository = new Repository(getApplication());

        Button button=findViewById(R.id.saveterm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(termID==-1) {
                    term = new Term(0, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
                    repository.insertTerm(term);
                } else {
                    term = new Term(0, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
                    repository.updateTerm(term);
                }
            }
        });

//        Button fab=findViewById(R.id.button2);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(TermDetails.this, Courses.class);
//                startActivity(intent);
//            }
//        });

    }
}