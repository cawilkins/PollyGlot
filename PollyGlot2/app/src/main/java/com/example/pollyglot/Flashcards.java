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
            public void onSwipeTop() {
                Toast.makeText(Flashcards.this, "top", Toast.LENGTH_SHORT).show();
            }
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
            public void onSwipeBottom() {
                Toast.makeText(Flashcards.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void InsertDataIntoCards() {
        int[] appsCovers = new int[] {
                R.drawable.facebook,
                R.drawable.youtube,
                R.drawable.twitter
        };

        CardModel item = new CardModel("Facebook App", appsCovers[0]);
        cardsList.add(item);

        item = new CardModel("Youtube App", appsCovers[1]);
        cardsList.add(item);

        item = new CardModel("Twitter App", appsCovers[2]);
        cardsList.add(item);

        adapter.notifyDataSetChanged();
    }
}