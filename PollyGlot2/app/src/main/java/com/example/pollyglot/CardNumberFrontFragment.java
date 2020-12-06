package com.example.pollyglot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CardNumberFrontFragment extends Fragment {

    private List<CardFrontModel> cardsList;
    private CardsFrontAdapter adapter;
    private AdapterViewFlipper adapterViewFlipper;
    private Button flipBtn;
    private int position;

    public CardNumberFrontFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize adapter
        cardsList = new ArrayList<>();
        adapter = new CardsFrontAdapter(getContext(), cardsList);

        // Prepare cards
        InsertDataIntoCards();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_flashcard_front, container, false);

        // Initialize ViewFlipper
        adapterViewFlipper = (AdapterViewFlipper) v.findViewById(R.id.adapterViewFlipper);
        adapterViewFlipper.setAdapter(adapter);
        adapterViewFlipper.setFlipInterval(2000);

        // Gesture event
        adapterViewFlipper.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeRight() {
                //Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                adapterViewFlipper.setInAnimation(getContext(), R.animator.left_in);
                adapterViewFlipper.setOutAnimation(getContext(), R.animator.right_out);
                adapterViewFlipper.showPrevious();
            }
            public void onSwipeLeft() {
                //Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                adapterViewFlipper.setInAnimation(getContext(), R.animator.right_in);
                adapterViewFlipper.setOutAnimation(getContext(), R.animator.left_out);
                adapterViewFlipper.showNext();
            }
        });

        return v;
    }

    private void InsertDataIntoCards() {
        CardFrontModel item = new CardFrontModel(getString(R.string.yek));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.d_o));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.se3));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.chahaar));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.panj));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.shesh));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.haft));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.hasht));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.no));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.da));
        cardsList.add(item);
    }

}