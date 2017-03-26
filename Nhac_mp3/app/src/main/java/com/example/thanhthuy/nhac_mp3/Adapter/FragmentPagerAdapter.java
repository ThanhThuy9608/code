package com.example.thanhthuy.nhac_mp3.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.thanhthuy.nhac_mp3.Frangment.FragmentNgheSi;
import com.example.thanhthuy.nhac_mp3.Frangment.MusicFragment;
import com.example.thanhthuy.nhac_mp3.Frangment.tabAlbumFragment;


public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new MusicFragment();
                break;
            case 1:
                frag=new tabAlbumFragment();
                break;
            case 2:
                frag = new FragmentNgheSi();
                break;
        }
        return frag;
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title="Bài hát";
                break;
            case 1:
                title="Album";
                break;
            case 2:
                title="Nghệ sĩ";
                break;
        }

        return title;
    }

}
