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

public class CardAlphabetFrontFragment extends Fragment {

    private List<CardFrontModel> cardsList;
    private CardsFrontAdapter adapter;
    private AdapterViewFlipper adapterViewFlipper;
    private Button flipBtn;
    private int position;

    public CardAlphabetFrontFragment() {
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
        CardFrontModel item = new CardFrontModel(getString(R.string.aleph));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.be));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.pe));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.te));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.se));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.jim));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.che));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.hejimi));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.khe));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.daal));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.zaal));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.re));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.ze));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.zhe));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.sin));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.shin));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.saad));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.zaad));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.taa));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.zaa));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.ein));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.ghein));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.fe));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.qaaf));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.kaaf));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.gaaf));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.laam));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.mim));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.nun));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.vaav));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.hedocheshm));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.ye));
        cardsList.add(item);
    }

}