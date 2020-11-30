package com.example.pollyglot;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CardFrontFragment extends Fragment {

    private List<CardFrontModel> cardsList;
    private CardsFrontAdapter adapter;
    private AdapterViewFlipper adapterViewFlipper;
    private Button flipBtn;
    private int position;

    public CardFrontFragment() {
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
        CardFrontModel item = new CardFrontModel("ا");
        cardsList.add(item);

        item = new CardFrontModel("ب");
        cardsList.add(item);

        item = new CardFrontModel("پ");
        cardsList.add(item);

        item = new CardFrontModel("ت");
        cardsList.add(item);

        item = new CardFrontModel("ث");
        cardsList.add(item);

        item = new CardFrontModel("ج");
        cardsList.add(item);

        item = new CardFrontModel("چ");
        cardsList.add(item);

        item = new CardFrontModel("ح");
        cardsList.add(item);

        item = new CardFrontModel("خ");
        cardsList.add(item);

        item = new CardFrontModel("د");
        cardsList.add(item);

        item = new CardFrontModel("ذ");
        cardsList.add(item);

        item = new CardFrontModel("ر");
        cardsList.add(item);

        item = new CardFrontModel("ز");
        cardsList.add(item);

        item = new CardFrontModel("ژ");
        cardsList.add(item);

        item = new CardFrontModel("س");
        cardsList.add(item);

        item = new CardFrontModel("ش");
        cardsList.add(item);

        item = new CardFrontModel("ص");
        cardsList.add(item);

        item = new CardFrontModel("ض");
        cardsList.add(item);

        item = new CardFrontModel("ط");
        cardsList.add(item);

        item = new CardFrontModel("ظ");
        cardsList.add(item);

        item = new CardFrontModel("21");
        cardsList.add(item);

        item = new CardFrontModel("22");
        cardsList.add(item);

        item = new CardFrontModel("23");
        cardsList.add(item);

        item = new CardFrontModel("24");
        cardsList.add(item);

        item = new CardFrontModel("25");
        cardsList.add(item);

        item = new CardFrontModel("26");
        cardsList.add(item);

        item = new CardFrontModel("27");
        cardsList.add(item);

        item = new CardFrontModel("28");
        cardsList.add(item);

        item = new CardFrontModel("29");
        cardsList.add(item);

        item = new CardFrontModel("30");
        cardsList.add(item);

        item = new CardFrontModel("31");
        cardsList.add(item);

        item = new CardFrontModel("32");
        cardsList.add(item);
    }

}