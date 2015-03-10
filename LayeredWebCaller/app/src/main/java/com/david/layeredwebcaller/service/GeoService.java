package com.david.layeredwebcaller.service;

import com.david.layeredwebcaller.BuildConfig;
import com.david.layeredwebcaller.model.HostModel;
import com.david.layeredwebcaller.service.retrofit.IpifyApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by David Crotty on 10/03/2015.
 */
public class GeoService implements IGeoService {

    private IpifyApi _geoApi;

    public GeoService(){
        //TODO pass params in using DI
        Gson gson = new GsonBuilder()
                        .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                                      .setConverter(new GsonConverter(gson)).setEndpoint(BuildConfig.GEOAPI_BASEURL)
                                      .setLogLevel(RestAdapter.LogLevel.FULL)
                                      .build();
        _geoApi = restAdapter.create(IpifyApi.class);
        //TODO generic error handler can be set in retrofit itself
    }

    @Override
    public Observable<HostModel> getIpAddress() {
        return _geoApi.getIpAddress().observeOn(AndroidSchedulers.mainThread());
    }
}
