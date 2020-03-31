package com.example.songslyricsapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.songslyricsapp.DBHandler.DBHandler;

import java.util.ArrayList;

public class SongListActivity  extends AppCompatActivity {

    TextView txtViewSongListName;
    ArrayAdapter arrayAdapter;
    String songtype = "";
    ListView listView;
    EditText searchtxtEdit;
    Button btnSearch;
    DBHandler dbHandler;
    ArrayList<String> songlist;
    public static final String SONG_NAME = "com.example.songlyricsapp.songlistactivity.songname";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songlistview);


        listView = findViewById(R.id.listViewList);
        txtViewSongListName = findViewById(R.id.textViewTitleList);
        searchtxtEdit = findViewById(R.id.searchText);
        btnSearch = findViewById(R.id.buttonSearch);
        Intent intent = getIntent();
        String songName = intent.getStringExtra(HomeActivity.SONG_TYPE);
        Log.v("SONG_TYPE",songName);
        if(songName.equals( HomeActivity.SONG_TYPE_ENGLISH)){
            txtViewSongListName.setText("English Songs");
            songtype ="ENGLISH";
        }else if(songName.equals(HomeActivity.SONG_TYPE_SINHALA)){
            txtViewSongListName.setText("Sinhala Songs");
            songtype ="SINHALA";
        }else if(songName.equals( HomeActivity.SONG_TYPE_TAMIL)){
            txtViewSongListName.setText("Tamil Songs");
            songtype ="TAMIL";
        }else if(songName .equals( HomeActivity.SONG_TYPE_HINDI)){
            txtViewSongListName.setText("Hindi Songs");
            songtype ="HINDI";
        }


        dbHandler  = new DBHandler(getApplicationContext());
        songlist = dbHandler.getSongNames(songtype);
        arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.list_song_item,songlist);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(SongListActivity.this, SongActivity.class);
                intent1.putExtra(SONG_NAME,arrayAdapter.getItem(i).toString());
                startActivity(intent1);
            }
        });

        searchtxtEdit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String search = searchtxtEdit.getText().toString();
                if(search != ""){
                    arrayAdapter.getFilter().filter(search);
                }
                return false;
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = searchtxtEdit.getText().toString();
                if(search != ""){
                    arrayAdapter.getFilter().filter(search);

                }
            }
        });
    }
}
