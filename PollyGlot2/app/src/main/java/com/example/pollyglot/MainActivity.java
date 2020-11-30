package com.example.pollyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button dictionary;
    private Button flashcards;
    private Button alphabet;
    private Button fillinblank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dictionary = findViewById(R.id.button);
        flashcards = findViewById(R.id.button2);
        alphabet = findViewById(R.id.button3);
        fillinblank = findViewById(R.id.button4);
        dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dictionary.class);
                startActivity(intent);
            }
        });
        flashcards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Flashcards.class);
                startActivity(intent);
            }
        });
        alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Alphabet.class);
                startActivity(intent);
            }
        });
        fillinblank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FillinBlank.class);
                startActivity(intent);
            }
        });
    }
}