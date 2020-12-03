package com.example.pollyglot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Alphabet extends AppCompatActivity {

    //Names of all the buttons on the grid
    Button btnalef, btnbe, btnpe, btnte, btnse, btnjim, btnche, btnhejimi, btnkhe, btndaal, btnzaal,
     btnre, btnze, btnzhe, btnsin, btnshin, btnsaad, btnzaad, btntaa, btnzaa, btnein, btnghein,
     btnfe, btnqaaf, btnkaaf, btngaaf, btnlaam, btnmim, btnnun, btnvaav, btnhed, btnye, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);


        btnalef = findViewById(R.id.button41);      //attaches each button with the name of the button
        btnbe = findViewById(R.id.button42);
        btnpe = findViewById(R.id.button43);
        btnte = findViewById(R.id.button44);
        btnse = findViewById(R.id.button45);
        btnjim = findViewById(R.id.button46);
        btnche = findViewById(R.id.button47);
        btnhejimi = findViewById(R.id.button48);
        btnkhe = findViewById(R.id.button49);
        btndaal = findViewById(R.id.button50);
        btnzaal = findViewById(R.id.button51);
        btnre = findViewById(R.id.button52);
        btnze = findViewById(R.id.button53);
        btnzhe = findViewById(R.id.button54);
        btnsin = findViewById(R.id.button55);
        btnshin = findViewById(R.id.button56);
        btnsaad = findViewById(R.id.button57);
        btnzaad = findViewById(R.id.button58);
        btntaa = findViewById(R.id.button59);
        btnzaa = findViewById(R.id.button60);
        btnein = findViewById(R.id.button61);
        btnghein = findViewById(R.id.button62);
        btnfe = findViewById(R.id.button63);
        btnqaaf = findViewById(R.id.button64);
        btnkaaf = findViewById(R.id.button65);
        btngaaf = findViewById(R.id.button66);
        btnlaam = findViewById(R.id.button67);
        btnmim = findViewById(R.id.button68);
        btnnun = findViewById(R.id.button69);
        btnvaav = findViewById(R.id.button70);
        btnhed = findViewById(R.id.button71);
        btnye = findViewById(R.id.button72);
        back = findViewById(R.id.button5);

        final MediaPlayer alefsound = MediaPlayer.create(this,R.raw.alef);  //Get the sound from the raw folder
        final MediaPlayer besound = MediaPlayer.create(this,R.raw.be);
        final MediaPlayer pesound = MediaPlayer.create(this,R.raw.pe);
        final MediaPlayer tesound = MediaPlayer.create(this,R.raw.te);
        final MediaPlayer sesound = MediaPlayer.create(this,R.raw.se);
        final MediaPlayer jimsound = MediaPlayer.create(this,R.raw.jim);
        final MediaPlayer chesound = MediaPlayer.create(this,R.raw.che);
        final MediaPlayer hejimisound = MediaPlayer.create(this,R.raw.hejimi);
        final MediaPlayer khesound = MediaPlayer.create(this,R.raw.khe);
        final MediaPlayer daalsound = MediaPlayer.create(this,R.raw.daal);
        final MediaPlayer zaalsound = MediaPlayer.create(this,R.raw.zaal);
        final MediaPlayer resound = MediaPlayer.create(this,R.raw.re);
        final MediaPlayer zesound = MediaPlayer.create(this,R.raw.ze);
        final MediaPlayer zhesound = MediaPlayer.create(this,R.raw.zhe);
        final MediaPlayer sinsound = MediaPlayer.create(this,R.raw.sin);
        final MediaPlayer shinsound = MediaPlayer.create(this,R.raw.shin);
        final MediaPlayer saadsound = MediaPlayer.create(this,R.raw.saad);
        final MediaPlayer zaadsound = MediaPlayer.create(this,R.raw.zaad);
        final MediaPlayer taasound = MediaPlayer.create(this,R.raw.taa);
        final MediaPlayer zaasound = MediaPlayer.create(this,R.raw.zaa);
        final MediaPlayer einsound = MediaPlayer.create(this,R.raw.ein);
        final MediaPlayer gheinsound = MediaPlayer.create(this,R.raw.ghein);
        final MediaPlayer fesound = MediaPlayer.create(this,R.raw.fe);
        final MediaPlayer qaafsound = MediaPlayer.create(this,R.raw.qaaf);
        final MediaPlayer kaafsound = MediaPlayer.create(this,R.raw.kaaf);
        final MediaPlayer gaafsound = MediaPlayer.create(this,R.raw.gaaf);
        final MediaPlayer laamsound = MediaPlayer.create(this,R.raw.laam);
        final MediaPlayer mimsound = MediaPlayer.create(this,R.raw.mim);
        final MediaPlayer nunsound = MediaPlayer.create(this,R.raw.nun);
        final MediaPlayer vaavsound = MediaPlayer.create(this,R.raw.vaav);
        final MediaPlayer hedsound = MediaPlayer.create(this,R.raw.hedocheshm);
        final MediaPlayer yesound = MediaPlayer.create(this,R.raw.ye);


        btnalef.setOnClickListener(v -> alefsound.start());     //When the button is clicked, play the sound
        btnbe.setOnClickListener(v -> besound.start());
        btnpe.setOnClickListener(v -> pesound.start());
        btnte.setOnClickListener(v -> tesound.start());
        btnse.setOnClickListener(v -> sesound.start());
        btnjim.setOnClickListener(v -> jimsound.start());
        btnche.setOnClickListener(v -> chesound.start());
        btnhejimi.setOnClickListener(v -> hejimisound.start());
        btnkhe.setOnClickListener(v -> khesound.start());
        btndaal.setOnClickListener(v -> daalsound.start());
        btnzaal.setOnClickListener(v -> zaalsound.start());
        btnre.setOnClickListener(v -> resound.start());
        btnze.setOnClickListener(v -> zesound.start());
        btnzhe.setOnClickListener(v -> zhesound.start());
        btnsin.setOnClickListener(v -> sinsound.start());
        btnshin.setOnClickListener(v -> shinsound.start());
        btnsaad.setOnClickListener(v -> saadsound.start());
        btnzaad.setOnClickListener(v -> zaadsound.start());
        btntaa.setOnClickListener(v -> taasound.start());
        btnzaa.setOnClickListener(v -> zaasound.start());
        btnein.setOnClickListener(v -> einsound.start());
        btnghein.setOnClickListener(v -> gheinsound.start());
        btnfe.setOnClickListener(v -> fesound.start());
        btnqaaf.setOnClickListener(v -> qaafsound.start());
        btnkaaf.setOnClickListener(v -> kaafsound.start());
        btngaaf.setOnClickListener(v -> gaafsound.start());
        btnlaam.setOnClickListener(v -> laamsound.start());
        btnmim.setOnClickListener(v -> mimsound.start());
        btnnun.setOnClickListener(v -> nunsound.start());
        btnvaav.setOnClickListener(v -> vaavsound.start());
        btnhed.setOnClickListener(v -> hedsound.start());
        btnye.setOnClickListener(v -> yesound.start());

        back.setOnClickListener(v -> {      //When button is clicked, it goes back to the home screen
            Intent intent = new Intent(Alphabet.this, MainActivity.class);
            startActivity(intent);
        });
    }
}