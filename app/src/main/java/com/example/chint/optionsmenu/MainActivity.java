package com.example.chint.optionsmenu;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    MenuItem google;
    MenuItem yahoo;
    MenuItem bing;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        google = (MenuItem)findViewById(R.id.google);
        yahoo = (MenuItem)findViewById(R.id.yahoo);
        bing = (MenuItem)findViewById(R.id.bing);

        GooglePage gp = new GooglePage();
        YahooPage yp = new YahooPage();
        BingPage bp = new BingPage();

        int id = item.getItemId();
        if(id==R.id.google){
            getFragmentManager().beginTransaction().replace(R.id.fragment,gp,"google").commit();
        }
        if(id==R.id.yahoo){
            getFragmentManager().beginTransaction().replace(R.id.fragment,yp,"yahoo").commit();
        }
        if(id==R.id.bing){
            getFragmentManager().beginTransaction().replace(R.id.fragment,bp,"bing").commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
