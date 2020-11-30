package com.example.pollyglot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class CardsBackAdapter extends BaseAdapter {
    private Context context;
    private List<CardBackModel> cardList;
    LayoutInflater inflater;

    public CardsBackAdapter(Context applicationContext, List<CardBackModel> cardList) {
        this.context = applicationContext;
        this.cardList = cardList;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return cardList.size();
    }

    @Override
    public Object getItem(int position) {
        return cardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.card_back, parent,false);

        CardBackModel cardModel = cardList.get(position);

        // Link those objects with their respective id's
        // that we have given in .XML file
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView sound = (TextView) view.findViewById(R.id.sound);

        // Set the name in text view
        name.setText(cardModel.getName());

        // Set the sound in text view
        sound.setText(cardModel.getSound());

        return view;
    }
}
