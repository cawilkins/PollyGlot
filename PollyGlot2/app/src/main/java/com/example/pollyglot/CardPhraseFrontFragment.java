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

public class CardPhraseFrontFragment extends Fragment {

    private List<CardFrontModel> cardsList;
    private CardsFrontAdapter adapter;
    private AdapterViewFlipper adapterViewFlipper;
    private Button flipBtn;
    private int position;

    public CardPhraseFrontFragment() {
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
        CardFrontModel item = new CardFrontModel(getString(R.string.salaam));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.bale));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.na));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.esm));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.in));
        cardsList.add(item);

        item = new CardFrontModel("آن");
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.kojaa));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.az));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.alaan));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.awb));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.ghazaa));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.emrooz));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.chetoori));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.mamnoon));
        cardsList.add(item);

        item = new CardFrontModel("خدا حافظ");
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.khoobam));
        cardsList.add(item);

        item = new CardFrontModel("اسمت چیست؟");
        cardsList.add(item);

        item = new CardFrontModel("اسمم () است");
        cardsList.add(item);

        item = new CardFrontModel("از کجا هستی؟");
        cardsList.add(item);

        item = new CardFrontModel("از () هستم");
        cardsList.add(item);

        item = new CardFrontModel("فارسی میدونی؟");
        cardsList.add(item);

        item = new CardFrontModel("انگلیسی میدونی؟");
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.chekhabar));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.salaamati));
        cardsList.add(item);

        item = new CardFrontModel(getString(R.string.khoshvaqtam));
        cardsList.add(item);
    }

}