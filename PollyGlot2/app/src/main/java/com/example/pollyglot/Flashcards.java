package com.example.pollyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterViewFlipper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Flashcards extends AppCompatActivity {

    private List<CardModel> cardsList;
    private CardsAdapter adapter;
    private AdapterViewFlipper adapterViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);

        // Initialize adapter
        cardsList = new ArrayList<>();
        adapter = new CardsAdapter(this, cardsList);

        // Initialize ViewFlipper
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterViewFlipper);
        adapterViewFlipper.setAdapter(adapter);
        adapterViewFlipper.setFlipInterval(2600);

        // Prepare cards
        InsertDataIntoCards();

        // Gesture event
        adapterViewFlipper.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeRight() {
                //Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                adapterViewFlipper.setInAnimation(Flashcards.this, R.animator.left_in);
                adapterViewFlipper.setOutAnimation(Flashcards.this, R.animator.right_out);
                adapterViewFlipper.showPrevious();
            }
            public void onSwipeLeft() {
                //Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                adapterViewFlipper.setInAnimation(Flashcards.this, R.animator.right_in);
                adapterViewFlipper.setOutAnimation(Flashcards.this, R.animator.left_out);
                adapterViewFlipper.showNext();
            }
        });
    }

    private void InsertDataIntoCards() {

        CardModel item = new CardModel("alef", "aa");
        cardsList.add(item);

        item = new CardModel("be", "b");
        cardsList.add(item);

        item = new CardModel("pe", "p");
        cardsList.add(item);

        item = new CardModel("te", "t");
        cardsList.add(item);

        adapter.notifyDataSetChanged();
    }
}