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

public class CardNumberBackFragment extends Fragment {

    private List<CardBackModel> cardsList;
    private CardsBackAdapter adapter;
    private AdapterViewFlipper adapterViewFlipper;
    private Button flipBtn;
    private int position;

    public CardNumberBackFragment() {
        // Required empty public constructor
    }

    public CardNumberBackFragment(int position) {
        this.position = position;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cardsList = new ArrayList<>();

        // Initialize adapter
        adapter = new CardsBackAdapter(getContext(), cardsList);

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
        adapterViewFlipper.setDisplayedChild(position);
        adapterViewFlipper.setFlipInterval(2000);

        // Gesture event
        adapterViewFlipper.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeTop() {
                //Toast.makeText(getContext(), "top", Toast.LENGTH_SHORT).show();
                adapterViewFlipper.setInAnimation(getContext(), R.animator.left_in);
                adapterViewFlipper.setOutAnimation(getContext(), R.animator.right_out);
                adapterViewFlipper.showPrevious();
            }
            public void onSwipeRight() {
                //Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                //Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                //Toast.makeText(getContext(), "bottom", Toast.LENGTH_SHORT).show();
                adapterViewFlipper.setInAnimation(getContext(), R.animator.right_in);
                adapterViewFlipper.setOutAnimation(getContext(), R.animator.left_out);
                adapterViewFlipper.showNext();
            }

        });

        return v;
    }

    private void InsertDataIntoCards() {
        CardBackModel item = new CardBackModel("one", "yek");
        cardsList.add(item);

        item = new CardBackModel("two", "do");
        cardsList.add(item);

        item = new CardBackModel("three", "se");
        cardsList.add(item);

        item = new CardBackModel("four", "chahaar");
        cardsList.add(item);

        item = new CardBackModel("five", "panj");
        cardsList.add(item);

        item = new CardBackModel("six", "shesh");
        cardsList.add(item);

        item = new CardBackModel("seven", "haft");
        cardsList.add(item);

        item = new CardBackModel("eight", "hasht");
        cardsList.add(item);

        item = new CardBackModel("nine", "no");
        cardsList.add(item);

        item = new CardBackModel("ten", "da");
        cardsList.add(item);
    }

}