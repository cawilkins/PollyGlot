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
        CardFrontModel item = new CardFrontModel("سلام");
        cardsList.add(item);

        item = new CardFrontModel("بله");
        cardsList.add(item);

        item = new CardFrontModel("نه");
        cardsList.add(item);

        item = new CardFrontModel("اسم");
        cardsList.add(item);

        item = new CardFrontModel("این");
        cardsList.add(item);

        item = new CardFrontModel("آن");
        cardsList.add(item);

        item = new CardFrontModel("کجا");
        cardsList.add(item);

        item = new CardFrontModel("از");
        cardsList.add(item);

        item = new CardFrontModel("الان");
        cardsList.add(item);

        item = new CardFrontModel("آب");
        cardsList.add(item);

        item = new CardFrontModel("غذا");
        cardsList.add(item);

        item = new CardFrontModel("امروز");
        cardsList.add(item);

        item = new CardFrontModel("چطوری؟");
        cardsList.add(item);

        item = new CardFrontModel("ممنون");
        cardsList.add(item);

        item = new CardFrontModel("خدا حافظ");
        cardsList.add(item);

        item = new CardFrontModel("خوبم");
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

        item = new CardFrontModel("چه خبر؟");
        cardsList.add(item);

        item = new CardFrontModel("سلامتی");
        cardsList.add(item);

        item = new CardFrontModel("خوشوقتم");
        cardsList.add(item);
    }

}