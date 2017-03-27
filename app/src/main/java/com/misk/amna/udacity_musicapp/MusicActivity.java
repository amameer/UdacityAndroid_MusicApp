package com.misk.amna.udacity_musicapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.media.AudioManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MusicActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView PlayPause;
    TextView songTxV;
    TextView LengthTxV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Intent i = getIntent();
        Uri url =Uri.parse(i.getStringExtra("urlKey"));
        String Song=i.getStringExtra("SongKey");
        String Length=i.getStringExtra("LengthKey");

        songTxV=(TextView)findViewById(R.id.textView7);
        LengthTxV=(TextView)findViewById(R.id.textView8);
        PlayPause =(ImageView) findViewById(R.id.imageView5);
        songTxV.append(Song);
        LengthTxV.append(Length);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
     try {
            mediaPlayer.setDataSource(this, url);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {

            Toast.makeText(this,"Problem",Toast.LENGTH_SHORT);

        }


    }

    public void PlayPause(View v) {

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
         PlayPause.setImageResource(android.R.drawable.ic_media_play);
        }
        else {
            mediaPlayer.start();
            PlayPause.setImageResource(android.R.drawable.ic_media_pause);

        }

    }
}
