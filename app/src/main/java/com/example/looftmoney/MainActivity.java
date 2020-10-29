package com.example.looftmoney;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.looftmoney.cells.MoneyCellAdapter;
import com.example.looftmoney.cells.MoneyCellAdapterClick;
import com.example.looftmoney.cells.MoneyItem;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemsView;

    private MoneyCellAdapter moneyCellAdapter = new MoneyCellAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);

        configureRecyclerView();

        generateMoney();
    }

    private void generateMoney(){
        List<MoneyItem> moneyItem = new ArrayList<>();
        moneyItem.add(new MoneyItem("PS5","30000P"));
        moneyItem.add(new MoneyItem("Salary", "300000P"));

        moneyCellAdapter.setData(moneyItem);
    }

    private void configureRecyclerView() {
        itemsView = findViewById(R.id.itemsView);
        itemsView.setAdapter(moneyCellAdapter);

        moneyCellAdapter.moneyCellAdapterClick = new MoneyCellAdapterClick() {
            @Override
            public void onCellClick(MoneyItem moneyItem) {
                Toast.makeText(getApplicationContext(),"Cell clicked" + moneyItem.getValue(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void OnTitleClick() {
                Toast.makeText(getApplicationContext(),"Title clicked",Toast.LENGTH_LONG).show();

            }
        };

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false);

        itemsView.setLayoutManager(layoutManager);


    }
}