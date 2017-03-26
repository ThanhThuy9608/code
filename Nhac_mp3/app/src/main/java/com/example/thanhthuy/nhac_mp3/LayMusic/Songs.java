package com.example.thanhthuy.nhac_mp3.LayMusic;



import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.thanhthuy.nhac_mp3.LayMusic.SongMusic;

import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static android.R.attr.data;

/**
 * Created by ThanhThuy on 17/03/2017.
 */
public class Songs {

    private String[] START = {"*"};

    public List<SongMusic> getMusic(Context context) {

        SongMusic songMusic ;
        ContentResolver cr = context.getContentResolver();

        //Trường hợp muốn mở để chọn Media thì phải dùng EXTERNAL_CONTENT_URI
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        // lấy ra music
        String selection = MediaStore.Audio.Media.IS_MUSIC + "!=0";
        String sortOrder = MediaStore.Audio.Media.TITLE + " ASC";

        // Dùng con trỏ để trỏ đến từng đối tượng
        Cursor cur = cr.query(uri, START, selection, null, sortOrder);
        int count = 0;
        //List<SongMusic> listSong = new ArrayList<>();
        ArrayList<SongMusic> listSong = new ArrayList<SongMusic>();
        if (cur != null) {
            count = cur.getCount();  // đếm

            if (count > 0) {
//                if (cur.moveToFirst()) {
                    while (cur.moveToNext()) {
                        String path = cur.getString(cur.getColumnIndex(MediaStore.Audio.Media.DATA));

                        // lấy tên của từng bài hát
                        String name = cur.getString(cur.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                        // lấy album
                        String album = cur.getString(cur.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                        // lấy tên tac giả
                        String TacGia = cur.getString(cur.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                        // lấy thời gian của từng bài hát
                       // String ThoiGian = String.valueOf(cur.getString(cur.getColumnIndex(MediaStore.Audio.Media.DURATION)));

                        String ThoiGian = getDuration(Integer.parseInt(cur.getString(cur.getColumnIndex(MediaStore.Audio.Media.DURATION))));
                        // Lấy tên tiêu đề
                        String title = cur.getColumnName(cur.getColumnIndex(MediaStore.Audio.Media.TITLE));

                        songMusic = new SongMusic(path, name, album, TacGia, ThoiGian, title);

                        listSong.add(songMusic);
                    }
                }
            }
            cur.close();
            return listSong;
        }

//    private static String getDuration( long millis) {
//        if(millis < 0){
//            throw new IllegalArgumentException(" Thoi gian nho hon 0");
//        }
//        long minutes = TimeUnit.MICROSECONDS.toMinutes(millis);
//        millis = TimeUnit.MINUTES.toMillis(millis);
//        long seconds = TimeUnit.MICROSECONDS.toSeconds(millis);
//
//        // StringBuilder có thể thay đổi được
//        StringBuilder sb = new StringBuilder(6);
//        // Nối chuỗi
//        sb.append(minutes< 10 ? "0" + minutes : minutes);
//        sb.append(":");
//        sb.append(seconds<10 ? "0" + seconds : seconds);
//        return sb.toString();
//    }

    public static String getDuration(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";

        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        return finalTimerString;
    }
}
