package com.misk.amna.udacity_musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MusicLibraryActivity extends AppCompatActivity {

    ImageView song1;
    ImageView song2;
    ImageView song3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_library);

        song1 = (ImageView) findViewById(R.id.song1i);
        song2 = (ImageView) findViewById(R.id.song2i);
        song3 = (ImageView) findViewById(R.id.song3i);


        song1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PlayMusicActivity.class);
                String url = "http://ms1.sm3na.com/41/Sm3na_com_46044.mp3";
                String Song = getString(R.string.song1);
                String Length = "3:00 m";
                i.putExtra("urlKey", url);
                i.putExtra("LengthKey", Length);
                i.putExtra("SongKey", Song);
                startActivity(i);
            }
        });


        song2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PlayMusicActivity.class);
                String url = "http://ms1.sm3na.com/41/Sm3na_com_46058.mp3";
                String Song = getString(R.string.song2);
                String Length = "1:50 m";
                i.putExtra("urlKey", url);
                i.putExtra("LengthKey", Length);
                i.putExtra("SongKey", Song);
                startActivity(i);
            }
        });

        song2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PlayMusicActivity.class);
                String url = "http://ms1.sm3na.com/41/Sm3na_com_46052.mp3";
                String Song = getString(R.string.song3);
                String Length = "2:00 m";
                i.putExtra("urlKey", url);
                i.putExtra("LengthKey", Length);
                i.putExtra("SongKey", Song);
                startActivity(i);
            }
        });


    }
}