package com.example.pollyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;

public class Dictionary extends AppCompatActivity {
    TextView translation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        Button translate;
        translate = findViewById(R.id.button6);
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
                /*if(thread.getState() == Thread.State.NEW){
                    thread.start();
                }*/
                EditText edtxt = findViewById(R.id.editTextTextPersonName);
                String intext = edtxt.getText().toString();
                new TranslateTask().execute(intext);
            }
        });
    }

    void Display(String transres){
        translation = findViewById(R.id.textView4);
        translation.setText(transres);
    }
    private class TranslateTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String transres = "";
                try {
                    transres = Translate.doTranslation(strings[0]);
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            return transres;
        }

        @Override
        //calls display to handle translation result
        protected void onPostExecute(String transres){
            Display(transres);
        }
    }
}




