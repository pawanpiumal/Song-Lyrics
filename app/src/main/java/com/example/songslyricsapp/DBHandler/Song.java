package com.example.songslyricsapp.DBHandler;

import android.provider.BaseColumns;

public class Song {
    private Song(){

    }
    protected static class SongDetails implements BaseColumns{
        protected static final String TABLE_NAME = "songs";
        protected static final String COLUMN_NAME_SONG_NAME = "songname";
        protected static final String COLUMN_NAME_SONG = "song";
        protected static final String COLUMN_NAME_SONG_CATEGORY = "category";
        protected static final String COLUMN_NAME_ARTIST = "artist";
    }
}
