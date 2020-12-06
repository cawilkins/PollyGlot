package com.example.pollyglot;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardCategoryFragment extends Fragment implements CardCategoryAdapter.OnCategoryClickListener {

    private List<CardCategoryModel> categoryList;
    private CardCategoryAdapter adapter;
    private RecyclerView recyclerView;
    private CardCategoryViewModel model;

    public CardCategoryFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize adapter
        categoryList = new ArrayList<>();
        adapter = new CardCategoryAdapter(getContext(), categoryList, this);

        // Prepare categories
        InsertCategories();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_flashcard_category, container, false);

        // Initialize RecyclerView widget
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        // Create RecyclerView layout manager
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        // Item decoration
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onCategoryClicked(int categoryId) {
        model = new ViewModelProvider(requireActivity()).get(CardCategoryViewModel.class);

        model.select(categoryId);
    }

    private void InsertCategories() {

        CardCategoryModel item = new CardCategoryModel("Alphabet");
        categoryList.add(item);

        item = new CardCategoryModel("Numbers");
        categoryList.add(item);

        item = new CardCategoryModel("Phrases");
        categoryList.add(item);

        adapter.notifyDataSetChanged();
    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

            int position = parent.getChildAdapterPosition(view);
            int coloumn = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - coloumn * spacing / spanCount;
                outRect.right = (coloumn + 1) * spacing / spanCount;

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = coloumn * spacing / spanCount;
                outRect.right = spacing - (coloumn + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}