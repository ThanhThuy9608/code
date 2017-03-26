package com.example.thanhthuy.nhac_mp3;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.thanhthuy.nhac_mp3.Adapter.FragmentPagerAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager pager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        intitViewPager();
        // loadTabs();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

/**
    public void loadTabs(){
        final TabHost tab  = (TabHost) findViewById(android.R.id.tabhost);
        // gọi lệnh setup
        tab.setup();
        TabHost.TabSpec spec;
        // Tạo tab1
        spec = tab.newTabSpec("t1");
        spec.setContent(R.id.tabMusic);
        spec.setIndicator("Bài hát");
        tab.addTab(spec);

        // Tạo tab2

        spec = tab.newTabSpec("t1");
        spec.setContent(R.id.tabAlbum);
        spec.setIndicator("Album");
        tab.addTab(spec);

        // Thiết lâp mặc định
        tab.setCurrentTab(0);
    }
    */

    public void intitViewPager(){
        pager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        FragmentManager manager = getSupportFragmentManager();
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // displaySelectedScreen(id);
        if (id == R.id.nav_Music) {
            Toast.makeText(this, "Music", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_Album) {

            Toast.makeText(this, "Music", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_caidat) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_lq) {

        } else if (id == R.id.nav_close) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
