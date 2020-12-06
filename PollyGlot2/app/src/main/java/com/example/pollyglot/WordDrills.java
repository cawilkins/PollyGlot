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
    ImageButton audioclip;
    Button B08UL;
    Button B09UR;
    Button B10LL;
    Button B11LR;
    Button B05None;

    //Method used to shuffle the AudioList and assign the new first item to the speaker button
    //Accessed on page creation, as well as when a user clicks Continue after a correct answer
    private void loadAudio(List<Map.Entry<String, Integer>> audioListLoad) {
        //Shuffles the provided List of Key/Value pairs
        //The shuffling of just a subset and rotating is to help improve the chance of
        //the answer being one of the four options rather than almost always 'none of the above'
        //Without this, the chance is 4 out of 33, with it the chance is 4 out of 5.
        Collections.rotate(audioListLoad,5);
        Collections.shuffle(audioListLoad.subList(0,4));
        //Selects the new first item in the List's int value
        int audioSelection = audioListLoad.get(1).getValue();
        //Prepares selected audio clip to be played
        final MediaPlayer selectedSound = MediaPlayer.create(this,audioSelection);
        //Tells the speaker butter to listen for a click, and play the selected audio on click
        audioclip.setOnClickListener(v -> selectedSound.start());
    }

    //Method used to shuffle the WordList and assign the new first four items to the answer buttons
    //Accessed on page creation, as well as when a user clicks Continue after a correct answer
    private void loadWord(List<Map.Entry<String, String>> wordListLoad) {
        //Shuffles the provided List of Key/Value pairs
        //The shuffling of just a subset and rotating is to help improve the chance of
        //the answer being one of the four options rather than almost always 'none of the above'
        //Without this, the chance is 4 out of 33, with it the chance is 4 out of 5.
        Collections.rotate(wordListLoad,5);
        Collections.shuffle(wordListLoad.subList(0,4));
        //Selects the new first four items in the List's string values
        String B08rdmSlct = wordListLoad.get(0).getValue();
        String B09rdmSlct = wordListLoad.get(1).getValue();
        String B10rdmSlct = wordListLoad.get(2).getValue();
        String B11rdmSlct = wordListLoad.get(3).getValue();
        //Sets the text of the four answer buttons to the selected strings
        B08UL.setText(B08rdmSlct);
        B09UR.setText(B09rdmSlct);
        B10LL.setText(B10rdmSlct);
        B11LR.setText(B11rdmSlct);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_drills);

        //Creates a Button object
        Button back;
        //Links the new Button object to the Back button in the XML file
        back = findViewById(R.id.button12);
        //On click, go back to main activity
        back.setOnClickListener(new View.OnClickListener() {//on click, go back to main activity
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WordDrills.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Creates a Button object
        Button question;
        //Links the new Button object to the ? button in the XML file
        question = findViewById(R.id.button13);
        //On click, displays a dialog window providing instructions on how to use the activity
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WordDrills.this);
                builder.setMessage("Click on the Speaker to play the audio.\n\nFrom the provided " +
                        "options, select the choice that best matches the sound.\n\nOr select None of the Above.");
                builder.setTitle("Tips");
                //Allows clocks outside of the window to cancel the dialog
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

        //Creates a HashMap and loads it with the word audio files
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

        //Adds the members of the HashMap to a List.
        //This is done to allow the items to be shuffled and then consistently select
        //items from the same position in the shuffled list.
        List<Map.Entry<String, Integer>> audioList = new ArrayList<Map.Entry<String, Integer>>(audioLibrary.entrySet());
        audioclip = findViewById(R.id.imageButton1);
        //Calls the loadAudio method to shuffle the list then assign the new first item to
        //the speaker button.
        loadAudio(audioList);

        //Creates a HashMap and loads it with the word strings from resources
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

        //Adds the members of the HashMap to a List.
        //This is done to allow the items to be shuffled and then consistently select
        //items from the same position in the shuffled list.
        List<Map.Entry<String, String>> wordList = new ArrayList<Map.Entry<String, String>>(wordMap.entrySet());

        //Creates 4 Button objects and links them to existing buttons
        //in the layout
        B08UL = findViewById(R.id.button8);
        B09UR = findViewById(R.id.button9);
        B10LL = findViewById(R.id.button10);
        B11LR = findViewById(R.id.button11);
        B05None = findViewById(R.id.button5);

        //Calls the loadWord method to shuffle the list then assign the new first item to
        //the speaker button.
        loadWord(wordList);

        //Creating a popup message to respond to user selection
        //The comments for this onClickListener apply to the rest of the the onClickListeners
        //Except where stated otherwise.
        B08UL.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Creates a new Snackbar object
                Snackbar response;
                //If the key strings between the two List items matches
                if (wordList.get(0).getKey() == audioList.get(1).getKey()) {
                    //Popup a congratulation and prompt user to continue.
                    //User must click Continue to close the Snackbar popup
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            //New audio and word strings are loaded.
                            loadAudio(audioList);
                            loadWord(wordList);
                        }
                    });
                }
                else {
                    //If user clicks but it doesn't match, inform user in popup that
                    //dismisses itself after a short interval.
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
                            loadAudio(audioList);
                            loadWord(wordList);
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
                            loadAudio(audioList);
                            loadWord(wordList);
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
                            loadAudio(audioList);
                            loadWord(wordList);
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
                //If none of the key strings between the List items of the buttons and that
                //of the Speaker button match.
                if (!((wordList.get(0).getKey() == audioList.get(1).getKey()) ||
                        (wordList.get(1).getKey() == audioList.get(1).getKey()) ||
                        (wordList.get(2).getKey() == audioList.get(1).getKey()) ||
                        (wordList.get(3).getKey() == audioList.get(1).getKey()))) {
                    response = Snackbar.make(v, "Correct! Great Job!", Snackbar.LENGTH_INDEFINITE).setAction("Continue", new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            loadAudio(audioList);
                            loadWord(wordList);
                        }
                    });
                }
                else {
                    //If one of the other four buttons has a key string that matches the
                    //key string of the audiolist item linked to the speaker button.
                    response = Snackbar.make(v, "Not quite. Let's try that Again!", Snackbar.LENGTH_SHORT);
                }
                response.show();
            }
        });

    }
}
