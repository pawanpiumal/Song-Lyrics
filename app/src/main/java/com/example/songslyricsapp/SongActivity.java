package com.example.songslyricsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.songslyricsapp.DBHandler.DBHandler;

public class SongActivity extends AppCompatActivity {

    TextView txtViewSong;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songview);


        txtViewSong = findViewById(R.id.textViewSong);
        Intent intent = getIntent();
        String songName = intent.getStringExtra(SongListActivity.SONG_NAME);
        Log.v("Song",songName);
        Log.v("Song","sadasdsa");
        DBHandler dbHandler = new DBHandler(getApplicationContext());
        String song  = dbHandler.getSong(songName);
        Log.v("Song",dbHandler.getSong("Older"));
        txtViewSong.setText(song);



    }
}
