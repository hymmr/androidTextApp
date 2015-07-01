package com.example.usr0200393.testapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainDrawerActivity extends AppCompatActivity {

    private DrawerLayout vDrawerLayout;
    private ActionBarDrawerToggle vDrawerToggle;
    private ListView vListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        initDrawer();

        vListView = (ListView) findViewById(R.id.listview);
        vListView.setAdapter(new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, new String[]{"menu 1", "menu 2", "menu 3"}));
    }

    private void initDrawer() {
        vDrawerToggle = new ActionBarDrawerToggle(this, vDrawerLayout, R.string.app_name, R.string.app_name);
        vDrawerToggle.setDrawerIndicatorEnabled(true);
        vDrawerLayout.setDrawerListener(vDrawerToggle);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return vDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        vDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        vDrawerToggle.onConfigurationChanged(newConfig);
    }
}
