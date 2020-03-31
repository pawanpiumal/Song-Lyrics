package com.example.songslyricsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity  extends AppCompatActivity {
    Button btnSinhala;
    Button btnEnglish;
    Button btnTamil;
    Button btnHindi;

    public static  String SONG_TYPE = "com.example.songlyricsapp.SONG_TYPE";
    public static final String SONG_TYPE_ENGLISH = "com.example.songlyricsapp.ENGLISH";
    public static final String SONG_TYPE_SINHALA = "com.example.songlyricsapp.SINHALA";
    public static final String SONG_TYPE_TAMIL = "com.example.songlyricsapp.TAMIL";
    public static final String SONG_TYPE_HINDI = "com.example.songlyricsapp.HINDI";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        btnSinhala = findViewById(R.id.btnSinhala);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnTamil = findViewById(R.id.btnTamil);
        btnHindi = findViewById(R.id.btnHindi);

        btnSinhala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sinhala = new Intent(HomeActivity.this,SongListActivity.class);
                sinhala.putExtra(SONG_TYPE,SONG_TYPE_SINHALA );
                startActivity(sinhala);
            }
        });
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent english = new Intent(HomeActivity.this,SongListActivity.class);
                english.putExtra(SONG_TYPE,SONG_TYPE_ENGLISH );
                startActivity(english);

            }
        });
        btnTamil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tamil = new Intent(HomeActivity.this,SongListActivity.class);
                tamil.putExtra(SONG_TYPE,SONG_TYPE_TAMIL );
                startActivity(tamil);

            }
        });
        btnHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hindi = new Intent(HomeActivity.this,SongListActivity.class);
                hindi.putExtra(SONG_TYPE,SONG_TYPE_HINDI);
                startActivity(hindi);

            }
        });



    }
}
