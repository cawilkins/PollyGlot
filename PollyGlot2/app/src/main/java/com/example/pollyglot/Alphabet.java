package com.example.pollyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Alphabet extends AppCompatActivity {

    Button btnalef;
    Button btnbe;
    Button btnpe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        btnalef = findViewById(R.id.button41);
        btnbe = findViewById(R.id.button42);
        btnpe = findViewById(R.id.button43);

        final MediaPlayer alefsound = MediaPlayer.create(this,R.raw.alef);
        final MediaPlayer besound = MediaPlayer.create(this,R.raw.be);
        final MediaPlayer pesound = MediaPlayer.create(this,R.raw.pe);


        btnalef.setOnClickListener(v -> alefsound.start());
        btnbe.setOnClickListener(v -> {
            besound.start();
        });
        btnpe.setOnClickListener(v -> pesound.start());
    }
}