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

public class CardPhraseBackFragment extends Fragment {

    private List<CardBackModel> cardsList;
    private CardsBackAdapter adapter;
    private AdapterViewFlipper adapterViewFlipper;
    private Button flipBtn;
    private int position;

    public CardPhraseBackFragment() {
        // Required empty public constructor
    }

    public CardPhraseBackFragment(int position) {
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
        CardBackModel item = new CardBackModel("Hello", "salaam");
        cardsList.add(item);

        item = new CardBackModel("Yes", "bale");
        cardsList.add(item);

        item = new CardBackModel("No", "na");
        cardsList.add(item);

        item = new CardBackModel("Name", "esm");
        cardsList.add(item);

        item = new CardBackModel("This", "in");
        cardsList.add(item);

        item = new CardBackModel("That", "awn");
        cardsList.add(item);

        item = new CardBackModel("Where", "kojaa");
        cardsList.add(item);

        item = new CardBackModel("From", "az");
        cardsList.add(item);

        item = new CardBackModel("Now", "alaan");
        cardsList.add(item);

        item = new CardBackModel("Water", "awb");
        cardsList.add(item);

        item = new CardBackModel("Food", "ghazza");
        cardsList.add(item);

        item = new CardBackModel("Today", "emrooz");
        cardsList.add(item);

        item = new CardBackModel("How are you?", "chetoori");
        cardsList.add(item);

        item = new CardBackModel("Thank you", "mamnoon");
        cardsList.add(item);

        item = new CardBackModel("Goodbye", "khoda hafez");
        cardsList.add(item);

        item = new CardBackModel("I'm good.", "khoobam");
        cardsList.add(item);

        item = new CardBackModel("What's your name?", "esmet chist");
        cardsList.add(item);

        item = new CardBackModel("My name is ().", "esmam () ast");
        cardsList.add(item);

        item = new CardBackModel("Where are you from?", "az kojaa hasti");
        cardsList.add(item);

        item = new CardBackModel("I'm from ().", "az () hastam");
        cardsList.add(item);

        item = new CardBackModel("Do you know Farsi?", "farsi midoni");
        cardsList.add(item);

        item = new CardBackModel("Do you know English?", "anglisi midoni");
        cardsList.add(item);

        item = new CardBackModel("What's up?", "che khabar");
        cardsList.add(item);

        item = new CardBackModel("Response to What's up", "salaamati");
        cardsList.add(item);

        item = new CardBackModel("Nice to meet you!", "khoshvaqtam");
        cardsList.add(item);
    }

}