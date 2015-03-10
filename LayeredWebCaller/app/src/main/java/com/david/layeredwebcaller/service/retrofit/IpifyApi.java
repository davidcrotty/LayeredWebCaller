package com.david.layeredwebcaller.service.retrofit;

import com.david.layeredwebcaller.model.HostModel;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by David Crotty on 10/03/2015.
 */
public interface IpifyApi {
    @GET("http://api.ipify.org?format=json")
    public Observable<HostModel> getIpAddress();
}
