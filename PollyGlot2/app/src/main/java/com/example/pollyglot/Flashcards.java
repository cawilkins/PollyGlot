package com.example.pollyglot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;

public class Flashcards extends AppCompatActivity {

    private Button backBtn, flipBtn, tipBtn;
    private Fragment fragment, frontFragment;
    private AdapterViewFlipper adapterViewFlipper;
    private int categoryId, cardId;
    private boolean showingBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);

        // Display card category by default
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_container, new CardCategoryFragment())
                    .commit();
        }

        // Back Button
        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);
                if (fragment instanceof CardCategoryFragment) {
                    Intent intent = new Intent(Flashcards.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Flashcards.this, Flashcards.class);
                    startActivity(intent);
                }
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

        flipBtn = findViewById(R.id.flip_btn);
        flipBtn.setVisibility(View.GONE);
        flipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);
                adapterViewFlipper = fragment.getView().findViewById(R.id.adapterViewFlipper);
                cardId = adapterViewFlipper.getDisplayedChild();
                flipCard();
            }
        });

        CardCategoryViewModel model = new ViewModelProvider(this).get(CardCategoryViewModel.class);
        model.getSelected().observe(this, item -> {
            flipBtn.setVisibility(View.VISIBLE);

            categoryId = item;

            switch (item) {
                case 0:
                    frontFragment = new CardAlphabetFrontFragment();
                    break;
                case 1:
                    frontFragment = new CardNumberFrontFragment();
                    break;
                case 2:
                    frontFragment = new CardPhraseFrontFragment();
                    break;
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, frontFragment)
                    .commit();
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
        switch (categoryId) {
            case 0:
                getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.animator.card_flip_right_in,
                            R.animator.card_flip_right_out,
                            R.animator.card_flip_left_in,
                            R.animator.card_flip_left_out)
                    .replace(R.id.frame_container, new CardAlphabetBackFragment(cardId))
                    .addToBackStack(null)
                    .commit();
                break;
            case 1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.animator.card_flip_right_in,
                                R.animator.card_flip_right_out,
                                R.animator.card_flip_left_in,
                                R.animator.card_flip_left_out)
                        .replace(R.id.frame_container, new CardNumberBackFragment(cardId))
                        .addToBackStack(null)
                        .commit();
                break;
            case 2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.animator.card_flip_right_in,
                                R.animator.card_flip_right_out,
                                R.animator.card_flip_left_in,
                                R.animator.card_flip_left_out)
                        .replace(R.id.frame_container, new CardPhraseBackFragment(cardId))
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }

}