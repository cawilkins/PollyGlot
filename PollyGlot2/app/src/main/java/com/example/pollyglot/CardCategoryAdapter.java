package com.example.pollyglot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardCategoryAdapter extends RecyclerView.Adapter<CardCategoryAdapter.MyViewHolder> {

    public interface OnCategoryClickListener {
        public void onCategoryClicked(int categoryId);
    }

    private OnCategoryClickListener mCallback;

    private Context context;
    private List<CardCategoryModel> categoryList;

    public CardCategoryAdapter(Context context, List<CardCategoryModel> categoryList, OnCategoryClickListener callback) {
        this.context = context;
        this.categoryList = categoryList;
        mCallback = callback;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Get item's view based on item layout
        View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_category, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CardCategoryModel cardCategoryModel = categoryList.get(position);

        holder.name.setText(cardCategoryModel.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onCategoryClicked(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.category_name);
        }
    }
}
