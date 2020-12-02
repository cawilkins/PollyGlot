package com.example.pollyglot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.Toast;

public class Flashcards extends AppCompatActivity {

    private Button flipBtn;
    private Button backBtn;
    private Button tipBtn;
    private Fragment fragment;
    private AdapterViewFlipper adapterViewFlipper;
    private int cardId;
    private boolean showingBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);

        // Display card front by default
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_container, new CardFrontFragment())
                    .commit();
        }

        // Back Button
        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Flashcards.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tipBtn = findViewById(R.id.tip_btn);
        tipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Flashcards.this);
                builder.setMessage("Click on the Flip button to flip the card.\n\nFlip back to the symbol side to " +
                        "continue.\n\nSwipe left to go to the next flashcard.\n\nSwipe right to go back to the previous flashcard." +
                "\n\nClick the Back button to go back to the main page.");
                builder.setTitle("Tips");
                builder.setCancelable(true);
                builder.setNeutralButton("Close", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        // Flip Button
        flipBtn = findViewById(R.id.flip_btn);
        flipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);
                adapterViewFlipper = fragment.getView().findViewById(R.id.adapterViewFlipper);
                cardId = adapterViewFlipper.getDisplayedChild();
                flipCard();
            }
        });
    }

    private void flipCard() {
        if (showingBack) {
            getSupportFragmentManager().popBackStack();
            showingBack = false;
            return;
        }

        // Flip to the back.

        showingBack = true;

        // Create and commit a new fragment transaction that adds the fragment for
        // the back of the card, uses custom animations, and is part of the fragment
        // manager's back stack.

        getSupportFragmentManager()
                .beginTransaction()

                // Replace the default fragment animations with animator resources
                // representing rotations when switching to the back of the card, as
                // well as animator resources representing rotations when flipping
                // back to the front (e.g. when the system Back button is pressed).
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)

                // Replace any fragments currently in the container view with a
                // fragment representing the next page (indicated by the
                // just-incremented currentPage variable).
                .replace(R.id.frame_container, new CardBackFragment(cardId))

                // Add this transaction to the back stack, allowing users to press
                // Back to get to the front of the card.
                .addToBackStack(null)

                // Commit the transaction.
                .commit();
    }

}