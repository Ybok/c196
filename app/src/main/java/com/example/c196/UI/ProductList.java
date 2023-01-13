package com.example.c196.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c196.R;
import com.example.c196.database.BikeRepository;
import com.example.c196.database.Repository;
import com.example.c196.entities.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ProductList extends AppCompatActivity {

    private BikeRepository bikeRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        RecyclerView recyclerView = findViewById(R.id.productrecyclerview);
        final ProductAdapter productAdapter = new ProductAdapter(this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bikeRepository = new BikeRepository(getApplication());
        List<Product> allProducts = bikeRepository.getAllProducts();
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        productAdapter.setProducts(allProducts);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProductList.this, ProductDetails.class);
                startActivity(intent);
            }
        });
    }
}