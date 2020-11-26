package com.example.pollyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

public class Dictionary extends AppCompatActivity {
    TextView translation = (TextView)findViewById(R.id.textView5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        Button translate;
        translate = findViewById(R.id.button6);
        TextView translation = (TextView)findViewById(R.id.textView5);
        Button back;
        back = findViewById(R.id.button7);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dictionary.this, MainActivity.class);
                startActivity(intent);
            }
        });
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread.start();
            }
        });
    }

    Thread thread = new Thread(new Runnable(){

        @Override
        public void run() {
            EditText edtxt = findViewById(R.id.editTextTextPersonName);
            String intext = edtxt.getText().toString();
            String transres;
            try {
                transres = Translate.doTranslation(intext);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            translation.setText(transres);
        }
    });
}




