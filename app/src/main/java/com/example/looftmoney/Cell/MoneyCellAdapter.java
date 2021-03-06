package com.example.looftmoney.Cell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.looftmoney.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoneyCellAdapter extends RecyclerView.Adapter<MoneyCellAdapter.MoneyViewHolder> {

    private List<MoneyItem> moneyItemList = new ArrayList<>();

    public interface MoneyCellAdapterClick {
        void onCellClick(MoneyItem moneyItem);
        void OnTitleClick();
    }

    public MoneyCellAdapterClick moneyCellAdapterClick;

    public void setData(List<MoneyItem> moneyItems) {
        moneyItemList.clear();
        moneyItemList.addAll(moneyItems);

        notifyDataSetChanged();
    }

    public void setMoneyCellAdapterClick(MoneyCellAdapterClick moneyCellAdapterClick) {
        this.moneyCellAdapterClick = moneyCellAdapterClick;
    }

    @NonNull
    @Override
    public MoneyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MoneyViewHolder(layoutInflater.inflate(R.layout.cell_money,parent, false),
                moneyCellAdapterClick);
    }

    @Override
    public void onBindViewHolder(@NonNull MoneyViewHolder holder, int position) {
        holder.bind(moneyItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return moneyItemList.size();
    }

    static class MoneyViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView valueTextView;
        private MoneyCellAdapterClick moneyCellAdapterClick;

        public MoneyViewHolder(@NonNull View itemView,MoneyCellAdapterClick moneyCellAdapterClick) {
            super(itemView);

            this.moneyCellAdapterClick =moneyCellAdapterClick;

            titleTextView = itemView.findViewById(R.id.moneyCellTitleView);
            valueTextView = itemView.findViewById(R.id.moneyCellValueView);

        }

        public void bind(MoneyItem moneyItem) {
            titleTextView.setText(moneyItem.getTitle());
            valueTextView.setText(moneyItem.getValue());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(moneyCellAdapterClick !=null) {
                        moneyCellAdapterClick.onCellClick(moneyItem);

                    }
                }
            });

            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(moneyCellAdapterClick != null){
                        moneyCellAdapterClick.OnTitleClick();
                    }
                }
            });
        }
    }

}