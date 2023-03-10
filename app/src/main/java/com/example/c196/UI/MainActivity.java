package com.example.c196.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.c196.R;

public class MainActivity extends AppCompatActivity {

    public static int numAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Product product = new Product(0, "bicycle", 100.0);
//        Repository repository = new Repository(getApplication());
//        repository.insert(product);

//        Term term = new Term(0, "First Term", "1 Oct 2022", "1 Apr 2023");
//        Repository repository = new Repository(getApplication());
//        repository.insertTerm(term);

//        Course course = new Course(0, "First Course", "1 Jan 2023", "1 Feb 2023", "In-Progress", "Optional notes", 0);
//        Repository repository = new Repository(getApplication());
//        repository.insertCourse(course);

//        Assessment assessment = new Assessment(0, "OBJ321", "Objective", "1 Feb 2023", "2 Feb 2023",  0);
//        Repository repository = new Repository(getApplication());
//        repository.insertAssessment(assessment);

        ImageButton termButton=findViewById(R.id.termButton);
        termButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Terms.class);
                startActivity(intent);
            }
        });
        ImageButton courseButton=findViewById(R.id.courseButton);
        courseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Courses.class);
                startActivity(intent);
            }
        });
        ImageButton assessmentButton=findViewById(R.id.assessmentButton);
        assessmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Assessments.class);
                startActivity(intent);
            }
        });
    }


//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_bicycle, menu);
//        return true;
//    }
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.addSampleData:
//                Product product = new Product(0, "bicycle", 100.0);
//                BikeRepository repository = new BikeRepository(getApplication());
//                repository.insert(product);
//                Part part = new Part(0, "wheel", 10.0, 1);
//                repository.insert(part);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_term, menu);
//        return true;
//    }
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.addSampleData:
//                Term term = new Term(0, "First Term", "1 Oct 2022", "1 Apr 2023");
//                Repository repository = new Repository(getApplication());
//                repository.insertTerm(term);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


//        public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_course, menu);
//        return true;
//    }
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.addSampleData:
//                Course course = new Course(0, "First Course", "1 Jan 2023", "1 Feb 2023", "In-Progress", "Optional notes", 0);
//                Repository repository = new Repository(getApplication());
//                repository.insertCourse(course);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_assessment, menu);
//        return true;
//    }
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.addSampleData:
//                Assessment assessment = new Assessment(0, "OBJ321", "Objective", "1 Feb 2023", "2 Feb 2023",  0);
//                Repository repository = new Repository(getApplication());
//                repository.insertAssessment(assessment);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


}