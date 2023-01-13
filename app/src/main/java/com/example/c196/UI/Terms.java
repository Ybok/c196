package com.example.c196.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c196.R;
import com.example.c196.database.Repository;
import com.example.c196.entities.Term;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Terms extends AppCompatActivity {

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        RecyclerView recyclerView = findViewById(R.id.termrecyclerview);
        final TermAdapter termAdapter = new TermAdapter(this);
        recyclerView.setAdapter(termAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        repository = new Repository(getApplication());
        List<Term> allTerms = repository.getTerms();
        FloatingActionButton fab = findViewById(R.id.floatingActionButton4);
        termAdapter.setTerms(allTerms);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Terms.this, TermDetails.class);
                startActivity(intent);
            }
        });
    }
}