package com.misk.amna.udacity_musicapp;

import android.content.Intent;
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

public class PlayMusicActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView PlayPause;
    TextView songTxV;
    TextView LengthTxV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        Intent i = getIntent();
        Uri url = Uri.parse(i.getStringExtra("urlKey"));
        String Song = i.getStringExtra("SongKey");
        String Length = i.getStringExtra("LengthKey");
        Boolean isPlaying; // to chech if music playing activity restarted with new music or resumed

        songTxV = (TextView) findViewById(R.id.textView7);
        LengthTxV = (TextView) findViewById(R.id.textView8);
        PlayPause = (ImageView) findViewById(R.id.imageView5);
        songTxV.append(Song);
        LengthTxV.append(Length);



        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


        try {
            mediaPlayer.setDataSource(this, url);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {

            Toast.makeText(this, "Cannot play this music", Toast.LENGTH_LONG);

        }


        PlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    PlayPause.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    mediaPlayer.start();
                    PlayPause.setImageResource(android.R.drawable.ic_media_pause);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mediaPlayer.release();

    }

}
