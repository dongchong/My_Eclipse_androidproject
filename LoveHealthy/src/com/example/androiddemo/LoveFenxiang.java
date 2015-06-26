package com.example.androiddemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ext.SatelliteMenu;
import android.view.ext.SatelliteMenuItem;

public class LoveFenxiang extends Activity {
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lovefenxiang);
        
        SatelliteMenu menu = (SatelliteMenu) findViewById(R.id.menu);
        List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
        SatelliteMenuItem fangdajing = new SatelliteMenuItem(4, R.drawable.ic_11);
        items.add(fangdajing);
        items.add(new SatelliteMenuItem(4, R.drawable.ic_13));
        items.add(new SatelliteMenuItem(4, R.drawable.ic_14));
        items.add(new SatelliteMenuItem(3, R.drawable.ic_15));
        items.add(new SatelliteMenuItem(2, R.drawable.ic_16));
        items.add(new SatelliteMenuItem(1, R.drawable.ic_12));
//        items.add(new SatelliteMenuItem(5, R.drawable.sat_item));
        menu.addItems(items);      
        
    }
}