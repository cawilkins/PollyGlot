package com.example.pollyglot;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDrills extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_drills);

        Button back;
        back = findViewById(R.id.button12);

        back.setOnClickListener(new View.OnClickListener() {//on click, go back to main activity
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordDrills.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button question;
        question = findViewById(R.id.button13);

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WordDrills.this);
                builder.setMessage("Click on the Speaker to play the audio.\n\nFrom the provided " +
                        "options, select the choice that best matches the sound.\n\nOr select None of the Above.");
                builder.setTitle("Tips");
                builder.setCancelable(true);
                builder.setNeutralButton("Close", new DialogInterface.OnClickListener(){
                    @Override
                            public void onClick(DialogInterface dialog, int which){
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


        HashMap<String, Integer> audioLibrary = new HashMap<String, Integer>();
        audioLibrary.put("alaan", R.raw.alaan);
        audioLibrary.put("anglisi", R.raw.anglisi);
        audioLibrary.put("awb", R.raw.awb);
        audioLibrary.put("azhastam", R.raw.az_hastam);
        audioLibrary.put("azkoja", R.raw.azkoja);
        audioLibrary.put("az", R.raw.az);
        audioLibrary.put("bale", R.raw.bale);
        audioLibrary.put("chahaar", R.raw.chahaar);
        audioLibrary.put("chekhabar", R.raw.chekhabar);
        audioLibrary.put("chetoori", R.raw.chetoori);
        audioLibrary.put("da", R.raw.da);
        audioLibrary.put("do", R.raw.d_o);
        audioLibrary.put("emrooz", R.raw.emrooz);
        audioLibrary.put("esm", R.raw.esm);
        audioLibrary.put("esmet", R.raw.esmet);
        audioLibrary.put("farsi", R.raw.farsi);
        audioLibrary.put("ghazaa", R.raw.ghazaa);
        audioLibrary.put("haft", R.raw.haft);
        audioLibrary.put("hasht", R.raw.hasht);
        audioLibrary.put("in", R.raw.in);
        audioLibrary.put("khoda", R.raw.khoda);
        audioLibrary.put("khoobam", R.raw.khoobam);
        audioLibrary.put("khoshvaqtam", R.raw.khoshvaqtam);
        audioLibrary.put("kojaa", R.raw.kojaa);
        audioLibrary.put("mamnoon", R.raw.mamnoon);
        audioLibrary.put("na", R.raw.na);
        audioLibrary.put("no", R.raw.no);
        audioLibrary.put("panj", R.raw.panj);
        audioLibrary.put("salaam", R.raw.salaam);
        audioLibrary.put("salaamati", R.raw.salaamati);
        audioLibrary.put("se3", R.raw.se3);
        audioLibrary.put("shesh", R.raw.shesh);
        audioLibrary.put("yek", R.raw.yek);

        List<Map.Entry<String, Integer>> audioList = new ArrayList<Map.Entry<String, Integer>>(audioLibrary.entrySet());
        Collections.shuffle(audioList);

        ImageButton audioclip;
        int audioSelection = audioList.get(1).getValue();
        final MediaPlayer selectedSound = MediaPlayer.create(this,audioSelection);
        audioclip = findViewById(R.id.imageButton1);
        audioclip.setOnClickListener(v -> selectedSound.start());


        HashMap<String, String> wordMap = new HashMap<String, String>();
        wordMap.put("alaan",getString(R.string.alaan));
        wordMap.put("anglisi",getString(R.string.anglisi));
        wordMap.put("awb",getString(R.string.awb));
        wordMap.put("azhastam",getString(R.string.az_hastam));
        wordMap.put("azkoja",getString(R.string.azkoja));
        wordMap.put("az",getString(R.string.az));
        wordMap.put("bale",getString(R.string.bale));
        wordMap.put("chahaar",getString(R.string.chahaar));
        wordMap.put("chekhabar",getString(R.string.chekhabar));
        wordMap.put("chetoori",getString(R.string.chetoori));
        wordMap.put("da",getString(R.string.da));
        wordMap.put("do",getString(R.string.d_o));
        wordMap.put("emrooz",getString(R.string.emrooz));
        wordMap.put("esm",getString(R.string.esm));
        wordMap.put("esmet",getString(R.string.esmet));
        wordMap.put("farsi",getString(R.string.farsi));
        wordMap.put("ghazaa",getString(R.string.ghazaa));
        wordMap.put("haft",getString(R.string.haft));
        wordMap.put("hasht",getString(R.string.hasht));
        wordMap.put("in",getString(R.string.in));
        wordMap.put("khoda",getString(R.string.khoda));
        wordMap.put("khoobam",getString(R.string.khoobam));
        wordMap.put("khoshvaqtam",getString(R.string.khoshvaqtam));
        wordMap.put("kojaa",getString(R.string.kojaa));
        wordMap.put("mamnoon",getString(R.string.mamnoon));
        wordMap.put("na",getString(R.string.na));
        wordMap.put("no",getString(R.string.no));
        wordMap.put("panj",getString(R.string.panj));
        wordMap.put("salaam",getString(R.string.salaam));
        wordMap.put("salaamati",getString(R.string.salaamati));
        wordMap.put("se3",getString(R.string.se3));
        wordMap.put("shesh",getString(R.string.shesh));
        wordMap.put("yek",getString(R.string.yek));

        List<Map.Entry<String, String>> wordList = new ArrayList<Map.Entry<String, String>>(wordMap.entrySet());

        //Shuffles the wordLibrary ArrayList and selects the first four items
        Collections.shuffle(wordList);
        String B08rdmSlct = wordList.get(0).getValue();
        String B09rdmSlct = wordList.get(1).getValue();
        String B10rdmSlct = wordList.get(2).getValue();
        String B11rdmSlct = wordList.get(3).getValue();

        //Creates 4 Button objects and links them to existing buttons
        //in the layout
        Button B08UL = (Button) findViewById(R.id.button8);
        Button B09UR = (Button) findViewById(R.id.button9);
        Button B10LL = (Button) findViewById(R.id.button10);
        Button B11LR = (Button) findViewById(R.id.button11);
        Button B05None = (Button) findViewById(R.id.button5);

        //Sets the text of the four buttons to the unique items selected
        //randomly from the wordLibrary ArrayList
        B08UL.setText(B08rdmSlct);
        B09UR.setText(B09rdmSlct);
        B10LL.setText(B10rdmSlct);
        B11LR.setText(B11rdmSlct);


        //Creating a popup message to respond to user selection


        B08UL.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar response;
                if (wordList.get(0).getKey() == audioList.get(1).getKey()) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                }
                else {
                    response = Snackbar.make(v, "Not quite. Let's try that Again!", Snackbar.LENGTH_SHORT);
                }
                response.show();
            }
        });
        B09UR.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar response;
                if (wordList.get(1).getKey() == audioList.get(1).getKey()) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                }
                else {
                    response = Snackbar.make(v, "Not quite. Let's try that Again!", Snackbar.LENGTH_SHORT);
                }
                response.show();
            }
        });
        B10LL.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar response;
                if (wordList.get(2).getKey() == audioList.get(1).getKey()) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                }
                else {
                    response = Snackbar.make(v, "Not quite. Let's try that Again!", Snackbar.LENGTH_SHORT);
                }
                response.show();
            }
        });
        B11LR.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar response;
                if (wordList.get(3).getKey() == audioList.get(1).getKey()) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                }
                else {
                    response = Snackbar.make(v, "Not quite. Let's try that Again!", Snackbar.LENGTH_SHORT);
                }
                response.show();
            }
        });
        B05None.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar response;
                if (!((wordList.get(0).getKey() == audioList.get(1).getKey()) ||
                        (wordList.get(1).getKey() == audioList.get(1).getKey()) ||
                        (wordList.get(2).getKey() == audioList.get(1).getKey()) ||
                        (wordList.get(3).getKey() == audioList.get(1).getKey()))) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                }
                else {
                    response = Snackbar.make(v, "Not quite. Let's try that Again!", Snackbar.LENGTH_SHORT);
                }
                response.show();
            }
        });

    }
}
