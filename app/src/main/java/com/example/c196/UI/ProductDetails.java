package com.example.c196.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c196.R;
import com.example.c196.database.BikeRepository;
import com.example.c196.entities.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProductDetails extends AppCompatActivity {

    EditText editName;
    EditText editPrice;
    String name;
    double price;
    int id;
    Product product;
    BikeRepository bikeRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        editName = findViewById(R.id.productname);
        editPrice=findViewById(R.id.productprice);
        //spelled same as adapter. default if number
        id = getIntent().getIntExtra("id", -1);
        name = getIntent().getStringExtra("name");
        price = getIntent().getDoubleExtra("price", -1);
        editName.setText(name);
        editPrice.setText(Double.toString(price));

        bikeRepository = new BikeRepository(getApplication());

        Button button=findViewById(R.id.saveproduct);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id==-1) {
                    product = new Product(0, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
                    bikeRepository.insert(product);
                } else {
                    product = new Product(id, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
                    bikeRepository.update(product);
                }
            }
        });

        FloatingActionButton fab=findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProductDetails.this, PartDetails.class);
                startActivity(intent);
            }
        });
    }
}