package com.example.pollyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Alphabet extends AppCompatActivity {

    Button btnbe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        btnbe = findViewById(R.id.button42);
        final MediaPlayer besound = MediaPlayer.create(this,R.raw.be);
        btnbe.setOnClickListener(v -> {
            //make it so sound plays when button is clicked
            besound.start();
        });
    }
}