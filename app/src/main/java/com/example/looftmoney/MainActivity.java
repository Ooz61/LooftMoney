package com.example.looftmoney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);

        configureRecyclerView();
    }

    private void configureRecyclerView() {
        itemsView = findViewById(R.id.itemsView);
    }
}