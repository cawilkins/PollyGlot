package com.example.pollyglot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class CardsFrontAdapter extends BaseAdapter {

    private Context context;
    private List<CardFrontModel> cardList;
    LayoutInflater inflater;
    View.OnClickListener listener;

    public CardsFrontAdapter(Context applicationContext, List<CardFrontModel> cardList) {
        this.context = applicationContext;
        this.cardList = cardList;
        this.listener = listener;
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
        view = inflater.inflate(R.layout.card_front, parent,false);

        CardFrontModel cardModel = cardList.get(position);

        // Link those objects with their respective id's
        // that we have given in .XML file
        TextView symbol = (TextView) view.findViewById(R.id.symbol);

        // Set the symbol in text view
        symbol.setText(cardModel.getSymbol());

        return view;
    }


}
