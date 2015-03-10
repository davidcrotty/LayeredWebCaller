package com.david.layeredwebcaller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.david.layeredwebcaller.model.HostModel;
import com.david.layeredwebcaller.service.GeoService;
import com.david.layeredwebcaller.service.IGeoService;

import rx.functions.Action1;


public class MainActivity extends Activity {

    private IGeoService _geoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _geoService = new GeoService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        _geoService.getIpAddress().subscribe(new Action1<HostModel>() {
            @Override
            public void call(HostModel hostModel) {
                Toast.makeText(getApplicationContext(), "Ip Address is: " + hostModel.getIpAddress(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
