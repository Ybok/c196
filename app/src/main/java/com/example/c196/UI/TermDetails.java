package com.example.c196.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196.R;
import com.example.c196.database.Repository;
import com.example.c196.entities.Course;
import com.example.c196.entities.Term;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    Term currentTerm;
    Repository repository;

    int numCourses;

    DatePickerDialog.OnDateSetListener startDate;
    DatePickerDialog.OnDateSetListener endDate;
    final Calendar myCalendarStart = Calendar.getInstance();
    final Calendar myCalendarEnd = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_details);


        listTermID = findViewById(R.id.termid);
        editTermName = findViewById(R.id.termname);
        editTermStart = findViewById(R.id.termstart);
        editTermEnd = findViewById(R.id.termend);

        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        String currentDate = sdf.format(new Date());

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


        editTermStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editTermStart.getText().toString();
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(TermDetails.this, startDate, myCalendarStart.get(Calendar.YEAR),
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


        editTermEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date;
                String info = editTermEnd.getText().toString();
                try {
                    myCalendarEnd.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(TermDetails.this, endDate, myCalendarEnd.get(Calendar.YEAR),
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


        Button fab=findViewById(R.id.button2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TermDetails.this, CourseDetails.class);
                startActivity(intent);
            }
        });

    }


    private void updateLabelStart() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editTermStart.setText(sdf.format(myCalendarStart.getTime()));
    }

    private void updateLabelEnd() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editTermEnd.setText(sdf.format(myCalendarEnd.getTime()));
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.deletecourse, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.deleteterm:
                for (Term term : repository.getTerms()) {
                    if (term.getTermID() == termID) currentTerm = term;
                }

                numCourses = 0;
                for (Course course : repository.getCourses()) {
                    if (course.getTermID() == termID) ++numCourses;
                }

                if (numCourses == 0) {
                    repository.deleteTerm(currentTerm);
                    Toast.makeText(TermDetails.this, currentTerm.getTermTitle() + " was deleted", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(TermDetails.this, Terms.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(TermDetails.this, "Can't delete a term with courses associated", Toast.LENGTH_LONG).show();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}