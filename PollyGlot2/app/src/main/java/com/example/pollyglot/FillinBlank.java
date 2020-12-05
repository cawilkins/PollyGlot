package com.example.pollyglot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FillinBlank extends AppCompatActivity {
    ImageButton audioclip;
    Button B08UL;
    Button B09UR;
    Button B10LL;
    Button B11LR;
    Button B05None;

    private void loadAudio(List<Map.Entry<String, Integer>> audioListLoad) {
        Collections.shuffle(audioListLoad);
        int audioSelection = audioListLoad.get(1).getValue();
        final MediaPlayer selectedSound = MediaPlayer.create(this,audioSelection);
        audioclip.setOnClickListener(v -> selectedSound.start());
    }
    private void loadChar(List<Map.Entry<String, String>> charListLoad) {
        Collections.shuffle(charListLoad);
        String B08rdmSlct = charListLoad.get(0).getValue();
        String B09rdmSlct = charListLoad.get(1).getValue();
        String B10rdmSlct = charListLoad.get(2).getValue();
        String B11rdmSlct = charListLoad.get(3).getValue();
        B08UL.setText(B08rdmSlct);
        B09UR.setText(B09rdmSlct);
        B10LL.setText(B10rdmSlct);
        B11LR.setText(B11rdmSlct);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillin_blank);

        Button back;
        back = findViewById(R.id.button12);
        back.setOnClickListener(new View.OnClickListener() {//on click, go back to main activity
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FillinBlank.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button question;
        question = findViewById(R.id.button13);
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FillinBlank.this);
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
        audioLibrary.put("aleph", R.raw.alef);
        audioLibrary.put("be", R.raw.be);
        audioLibrary.put("pe", R.raw.pe);
        audioLibrary.put("te", R.raw.te);
        audioLibrary.put("se", R.raw.se);
        audioLibrary.put("jim", R.raw.jim);
        audioLibrary.put("che", R.raw.che);
        audioLibrary.put("hejimi", R.raw.hejimi);
        audioLibrary.put("khe", R.raw.khe);
        audioLibrary.put("daal", R.raw.daal);
        audioLibrary.put("zaal", R.raw.zaal);
        audioLibrary.put("re", R.raw.re);
        audioLibrary.put("ze", R.raw.ze);
        audioLibrary.put("zhe", R.raw.zhe);
        audioLibrary.put("sin", R.raw.sin);
        audioLibrary.put("shin", R.raw.shin);
        audioLibrary.put("saad", R.raw.saad);
        audioLibrary.put("zaad", R.raw.zaad);
        audioLibrary.put("taa", R.raw.taa);
        audioLibrary.put("zaa", R.raw.zaa);
        audioLibrary.put("ein", R.raw.ein);
        audioLibrary.put("ghein", R.raw.ghein);
        audioLibrary.put("fe", R.raw.fe);
        audioLibrary.put("qaaf", R.raw.qaaf);
        audioLibrary.put("kaaf", R.raw.kaaf);
        audioLibrary.put("gaaf", R.raw.gaaf);
        audioLibrary.put("laam", R.raw.laam);
        audioLibrary.put("mim", R.raw.mim);
        audioLibrary.put("nun", R.raw.nun);
        audioLibrary.put("vaav", R.raw.vaav);
        audioLibrary.put("hedocheshm", R.raw.hedocheshm);
        audioLibrary.put("ye", R.raw.ye);

        List<Map.Entry<String, Integer>> audioList = new ArrayList<Map.Entry<String, Integer>>(audioLibrary.entrySet());
        audioclip = findViewById(R.id.imageButton1);
        loadAudio(audioList);

        HashMap<String, String> charMap = new HashMap<String, String>();
        charMap.put("aleph",getString(R.string.aleph));
        charMap.put("be", getString(R.string.be));
        charMap.put("pe", getString(R.string.pe));
        charMap.put("se", getString(R.string.te));
        charMap.put("jim", getString(R.string.jim));
        charMap.put("che", getString(R.string.che));
        charMap.put("hejimi", getString(R.string.hejimi));
        charMap.put("khe", getString(R.string.khe));
        charMap.put("daal", getString(R.string.daal));
        charMap.put("zaal", getString(R.string.zaal));
        charMap.put("re", getString(R.string.re));
        charMap.put("ze", getString(R.string.ze));
        charMap.put("zhe", getString(R.string.zhe));
        charMap.put("sin", getString(R.string.sin));
        charMap.put("shin", getString(R.string.shin));
        charMap.put("saad", getString(R.string.saad));
        charMap.put("zaad", getString(R.string.zaad));
        charMap.put("taa", getString(R.string.taa));
        charMap.put("zaa", getString(R.string.zaa));
        charMap.put("ein", getString(R.string.ein));
        charMap.put("ghein", getString(R.string.ghein));
        charMap.put("fe", getString(R.string.fe));
        charMap.put("qaaf", getString(R.string.qaaf));
        charMap.put("kaaf", getString(R.string.kaaf));
        charMap.put("gaaf", getString(R.string.gaaf));
        charMap.put("laam", getString(R.string.laam));
        charMap.put("mim", getString(R.string.mim));
        charMap.put("nun", getString(R.string.nun));
        charMap.put("vaav", getString(R.string.vaav));
        charMap.put("hedocheshm", getString(R.string.hedocheshm));
        charMap.put("ye", getString(R.string.ye));

        List<Map.Entry<String, String>> charList = new ArrayList<Map.Entry<String, String>>(charMap.entrySet());

        //Creates 4 Button objects and links them to existing buttons
        //in the layout
        B08UL = findViewById(R.id.button8);
        B09UR = findViewById(R.id.button9);
        B10LL = findViewById(R.id.button10);
        B11LR = findViewById(R.id.button11);
        B05None = findViewById(R.id.button5);
        loadChar(charList);

        //Creating a popup message to respond to user selection
        B08UL.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //generateResponse(v, charList, audioList);
                Snackbar response;
                if (charList.get(0).getKey() == audioList.get(1).getKey()) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            loadAudio(audioList);
                            loadChar(charList);
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
                if (charList.get(1).getKey() == audioList.get(1).getKey()) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            loadAudio(audioList);
                            loadChar(charList);
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
                if (charList.get(2).getKey() == audioList.get(1).getKey()) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            loadAudio(audioList);
                            loadChar(charList);
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
                if (charList.get(3).getKey() == audioList.get(1).getKey()) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            loadAudio(audioList);
                            loadChar(charList);
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
                if (!((charList.get(0).getKey() == audioList.get(1).getKey()) ||
                        (charList.get(1).getKey() == audioList.get(1).getKey()) ||
                        (charList.get(2).getKey() == audioList.get(1).getKey()) ||
                        (charList.get(3).getKey() == audioList.get(1).getKey()))) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            loadAudio(audioList);
                            loadChar(charList);
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
