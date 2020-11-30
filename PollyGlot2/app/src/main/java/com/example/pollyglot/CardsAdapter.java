package com.example.pollyglot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class CardsAdapter extends BaseAdapter {
    private Context context;
    private List<CardModel> appList;
    LayoutInflater inflater;

    public CardsAdapter(Context applicationContext, List<CardModel> appList) {
        this.context = applicationContext;
        this.appList = appList;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return appList.size();
    }

    @Override
    public Object getItem(int position) {
        return appList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.card_front, parent,false);

        CardModel appsModel = appList.get(position);

        // Link those objects with their respective id's
        // that we have given in .XML file
        TextView name = (TextView) view.findViewById(R.id.name);
        ImageView image = (ImageView) view.findViewById(R.id.thumbnail);

        // Set the data in text view
        name.setText(appsModel.getName());

        // Set the image in Image view
        image.setImageResource(appsModel.getThumbnail());
        return view;
    }
}
