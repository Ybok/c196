package com.example.c196.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.c196.R;
import com.example.c196.database.BikeRepository;
import com.example.c196.database.Repository;
import com.example.c196.entities.Part;
import com.example.c196.entities.Product;
import com.example.c196.entities.Term;

public class MainActivity extends AppCompatActivity {

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

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ProductList.class);
                startActivity(intent);
            }
        });
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


}