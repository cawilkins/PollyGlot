package com.example.pollyglot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CardBackFragment extends Fragment {

    private List<CardBackModel> cardsList;
    private CardsBackAdapter adapter;
    private AdapterViewFlipper adapterViewFlipper;
    private Button flipBtn;
    private int position;

    public CardBackFragment() {
        // Required empty public constructor
    }

    public CardBackFragment(int position) {
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
        CardBackModel item = new CardBackModel("alef", "aa");
        cardsList.add(item);

        item = new CardBackModel("be", "b");
        cardsList.add(item);

        item = new CardBackModel("pe", "p");
        cardsList.add(item);

        item = new CardBackModel("te", "t");
        cardsList.add(item);

        item = new CardBackModel("se", "s");
        cardsList.add(item);

        item = new CardBackModel("jim", "j");
        cardsList.add(item);

        item = new CardBackModel("che", "ch");
        cardsList.add(item);

        item = new CardBackModel("hejimi", "h");
        cardsList.add(item);

        item = new CardBackModel("khe", "kh");
        cardsList.add(item);

        item = new CardBackModel("daal", "d");
        cardsList.add(item);

        item = new CardBackModel("zaal", "z");
        cardsList.add(item);

        item = new CardBackModel("re", "r");
        cardsList.add(item);

        item = new CardBackModel("ze", "z");
        cardsList.add(item);

        item = new CardBackModel("zhe", "zh");
        cardsList.add(item);

        item = new CardBackModel("sin", "s");
        cardsList.add(item);

        item = new CardBackModel("shin", "sh");
        cardsList.add(item);

        item = new CardBackModel("saad", "s");
        cardsList.add(item);

        item = new CardBackModel("zaad", "z");
        cardsList.add(item);

        item = new CardBackModel("taa", "t");
        cardsList.add(item);

        item = new CardBackModel("zaa", "z");
        cardsList.add(item);

        item = new CardBackModel("'", "ein");
        cardsList.add(item);

        item = new CardBackModel("ghein", "gh");
        cardsList.add(item);

        item = new CardBackModel("fe", "f");
        cardsList.add(item);

        item = new CardBackModel("qaaf", "q");
        cardsList.add(item);

        item = new CardBackModel("kaaf", "k");
        cardsList.add(item);

        item = new CardBackModel("gaaf", "g");
        cardsList.add(item);

        item = new CardBackModel("laam", "l");
        cardsList.add(item);

        item = new CardBackModel("mim", "m");
        cardsList.add(item);

        item = new CardBackModel("nun", "n");
        cardsList.add(item);

        item = new CardBackModel("vaav", "v/ /u");
        cardsList.add(item);

        item = new CardBackModel("hedocheshm", "h");
        cardsList.add(item);

        item = new CardBackModel("ye", "y/ /ii");
        cardsList.add(item);
        
    }

}