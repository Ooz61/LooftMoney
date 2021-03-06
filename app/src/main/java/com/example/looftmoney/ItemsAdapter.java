package com.example.looftmoney;


import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> mItemsList = new ArrayList<Item>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.item_view, null);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position) {
        holder.bindItem(mItemsList.get(position));
    }

    public void addItem(Item item) {
        mItemsList.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mNameView;
        private TextView mPriceView;

        public ItemViewHolder(@NonNull final View itemView) {
            super(itemView);

            mNameView = itemView.findViewById(R.id.name_view);
            mPriceView = itemView.findViewById(R.id.price_view);
        }

        @SuppressLint("StringFormatInvalid")
        public void bindItem(final Item item) {
            mNameView.setText(item.getName());
            mPriceView.setText(
                    mPriceView.getContext().getResources().getString(R.string.price_with_currency, String.valueOf(item.getPrice()))
            );
        }
    }
}