package com.example.thanhthuy.nhac_mp3.Frangment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.thanhthuy.nhac_mp3.ChoiNhacActivity;
import com.example.thanhthuy.nhac_mp3.LayMusic.SongMusic;
import com.example.thanhthuy.nhac_mp3.LayMusic.TungBaiHat;
import com.example.thanhthuy.nhac_mp3.R;
import com.example.thanhthuy.nhac_mp3.LayMusic.Songs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {

    ListView lv;
    //String[] items;

    public MusicFragment() {
        // Required empty public constructor
    }

    /**
     * Đọc từ SD Card
     * Environment.getExternalStorageDirectory().getAbsolutePath():
     * để lấy đường dẫn trên SD Card
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_music, container, false);

        lv = (ListView) v.findViewById(R.id.lvBaiHat);

      //  ArrayList<File> mySongs = findSongs(Environment.getExternalStorageDirectory());
//

//        for(int i=0; i < listbaihat.size(); i++){
//            // nếu có đuôi .mp3 thì replace thành rỗng
//            items[i] = listbaihat.get(i).getName().toString().replace(".mp3","").replace(".wav","");
//        }
//                items = new String[mySongs.size()];

//                 ArrayAdapter<String> adp = new ArrayAdapter<String>(getActivity(),R.layout.bai_hat,R.id.titlebaihat, items);


           //     lv.setAdapter(adp);

        Songs song = new Songs();

        final  List<SongMusic> listbaihat = song.getMusic(getActivity());

         final TungBaiHat adTungBaiHat = new TungBaiHat(getActivity(), R.layout.bai_hat, listbaihat);

        lv.setAdapter(adTungBaiHat);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ChoiNhacActivity.class);

                SongMusic[] arrSong = listbaihat.toArray(new SongMusic[listbaihat.size()]);
                intent.putExtra("arr_song", arrSong);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });
        return v;
    }

//
//    public ArrayList<File> findSongs(File root){
//        ArrayList<File> al = new ArrayList<File>();
//        File[] files = root.listFiles();
//
//        for (File singleFile :files){
//            // isDirectory: kiểm tra xem nó có phải là một thư mục ko
//            // isHidden: Kiểm tra tập tin ẩn
//
//            if(singleFile.isDirectory() && singleFile.isHidden()){
//                al.addAll(findSongs(singleFile));
//            }
//            else {
//                if(singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav")){   // lấy ra file có đuôi .mp3
//                    al.add(singleFile);
//                }
//            }
//        }
//        return al;
//    }


}
