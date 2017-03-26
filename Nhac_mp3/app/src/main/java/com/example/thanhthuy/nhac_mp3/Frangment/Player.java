package com.example.thanhthuy.nhac_mp3.Frangment;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.thanhthuy.nhac_mp3.R;

import java.io.File;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Player#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Player extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Player() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Player.
     */
    // TODO: Rename and change types and number of parameters
    public static Player newInstance(String param1, String param2) {
        Player fragment = new Player();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    ImageButton ibPlay, ibNext, ibPrevious, ibLapLai, ibNgauNhien, ibStop;
    SeekBar seekBarSong;
    TextView textViewStart, textViewEnd;
    MediaPlayer mp;
    ArrayList<File> mySongs;
    Uri u;
    int position;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_player, container, false);


        seekBarSong  =(SeekBar) v.findViewById(R.id.seekBarSong);
        textViewStart = (TextView) v.findViewById(R.id.textViewStart);
        textViewEnd = (TextView) v.findViewById(R.id.textViewEnd);
        ibPlay = (ImageButton) v.findViewById(R.id.imageButtonPlay);
        ibStop = (ImageButton) v.findViewById(R.id.imageButtonStop1);
        ibPrevious = (ImageButton) v.findViewById(R.id.imageButtonBackchoinhac);
        ibLapLai = (ImageButton) v.findViewById(R.id.imageLapLai);
        ibNgauNhien = (ImageButton) v.findViewById(R.id.imageButtonNgauNhien);
        ibNext = (ImageButton) v.findViewById(R.id.imageButtonNext1);


        ibPrevious.setOnClickListener(this);
        ibNgauNhien.setOnClickListener(this);
        ibLapLai.setOnClickListener(this);
        ibStop.setOnClickListener(this);
        ibNext.setOnClickListener(this);
        ibPlay.setOnClickListener(this);
        return v;
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
                    mp = MediaPlayer.create(getContext(), u);
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
                    mp = MediaPlayer.create(getContext(), u);
                    mp.start();
                    break;
            }
        }
    }

