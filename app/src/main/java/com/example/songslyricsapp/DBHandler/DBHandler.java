package com.example.songslyricsapp.DBHandler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "songdb.db";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }

    public ArrayList<String> getSongNames(String category){
        ArrayList<String> songNames = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(Song.SongDetails.TABLE_NAME,
                new String[]{Song.SongDetails.COLUMN_NAME_SONG_NAME, Song.SongDetails.COLUMN_NAME_ARTIST},
                Song.SongDetails.COLUMN_NAME_SONG_CATEGORY + " = ? ",
                new String[]{category},
                null,
                null,
                null);
        while (cursor.moveToNext()){

            songNames.add(cursor.getString(cursor.getColumnIndexOrThrow(Song.SongDetails.COLUMN_NAME_SONG_NAME))+ " - "+ cursor.getString(cursor.getColumnIndexOrThrow(Song.SongDetails.COLUMN_NAME_ARTIST)));
        }

        db.close();
        return songNames;

    }

    public String getSong(String songname){

        String song = "";
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(Song.SongDetails.TABLE_NAME,
                new String[]{Song.SongDetails.COLUMN_NAME_SONG},
                Song.SongDetails.COLUMN_NAME_SONG_NAME + " = ? ",
                new String[]{songname},
                null,
                null,
                null);
        while (cursor.moveToNext()){
            song = cursor.getString(cursor.getColumnIndexOrThrow(Song.SongDetails.COLUMN_NAME_SONG));
        }
        db.close();
        return song;
    }
    public ArrayList<String> getSongNameArtist(){
        ArrayList<String> songNames = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(Song.SongDetails.TABLE_NAME,
                new String[]{Song.SongDetails.COLUMN_NAME_SONG_NAME},
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()){
            songNames.add(cursor.getString(cursor.getColumnIndexOrThrow(Song.SongDetails.COLUMN_NAME_ARTIST)));
        }

        db.close();
        return songNames;

    }
}

