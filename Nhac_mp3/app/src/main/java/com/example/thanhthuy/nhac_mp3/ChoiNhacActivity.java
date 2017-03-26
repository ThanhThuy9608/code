package com.example.thanhthuy.nhac_mp3;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.thanhthuy.nhac_mp3.LayMusic.SongMusic;
import com.example.thanhthuy.nhac_mp3.LayMusic.Songs;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ChoiNhacActivity extends ActionBarActivity implements View.OnClickListener {

    ImageButton ibPlay, ibNext, ibPrevious, ibLapLai, ibNgauNhien, ibStop;
    SeekBar seekBarSong;
    TextView textViewStart, textViewEnd;
    MediaPlayer mp;
    ArrayList<File> mySongs;
    Uri u;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_nhac);

        seekBarSong  =(SeekBar) findViewById(R.id.seekBarSong);
        textViewStart = (TextView) findViewById(R.id.textViewStart);
        textViewEnd = (TextView) findViewById(R.id.textViewEnd);
        ibPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
        ibStop = (ImageButton) findViewById(R.id.imageButtonStop1);
        ibPrevious = (ImageButton) findViewById(R.id.imageButtonBackchoinhac);
        ibLapLai = (ImageButton) findViewById(R.id.imageLapLai);
        ibNgauNhien = (ImageButton) findViewById(R.id.imageButtonNgauNhien);
        ibNext = (ImageButton) findViewById(R.id.imageButtonNext1);


        ibPrevious.setOnClickListener(this);
        ibNgauNhien.setOnClickListener(this);
        ibLapLai.setOnClickListener(this);
        ibStop.setOnClickListener(this);
        ibNext.setOnClickListener(this);
        ibPlay.setOnClickListener(this);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        // getParcelableArrayList(String key, Parcelabe[] value): đưa một ArrayList đối tượng Parcelabe vào Bundle
        mySongs = (ArrayList) b.getParcelableArrayList("arr_song");
        position = b.getInt("position", 0);

        u = Uri.parse(mySongs.get(position).toString());
        mp = MediaPlayer.create(getApplicationContext(), u);
        mp.start();
    }

//    public void Control(){
//        seekBarSong  =(SeekBar) findViewById(R.id.seekBarSong);
//        textViewStart = (TextView) findViewById(R.id.textViewStart);
//        textViewEnd = (TextView) findViewById(R.id.textViewEnd);
//        ibPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
//        ibStop = (ImageButton) findViewById(R.id.imageButtonStop1);
//        ibPrevious = (ImageButton) findViewById(R.id.imageButtonBackchoinhac);
//        ibLapLai = (ImageButton) findViewById(R.id.imageLapLai);
//        ibNgauNhien = (ImageButton) findViewById(R.id.imageButtonNgauNhien);
//        ibNext = (ImageButton) findViewById(R.id.imageButtonNext1);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.imageButtonPlay:
//                if(mp.isPlaying()){
//                    mp.pause();
//                }
//                else mp.start();
//                break;
                mp.start();
                break;
            case R.id.imageButtonStop1:
                mp.pause();
                break;
            case R.id.imageButtonNext1:
                mp.stop();
                mp.release();
                position = (position+1)%mySongs.size();
                u = Uri.parse(mySongs.get(position).toString());
                mp = MediaPlayer.create(getApplicationContext(), u);
                mp.start();

                break;
            case R.id.imageButtonBackchoinhac:
                mp.stop();
                mp.release();
//                if(position - 1 <0){
//                    position = mySongs.size() - 1;
//                }
//                else {
//                    position = position-1;
//                }
                position = (position-1<0)?mySongs.size() - 1 : position-1;

                u = Uri.parse(mySongs.get(position).toString());
                mp = MediaPlayer.create(getApplicationContext(), u);
                mp.start();
                break;
        }
    }
}
