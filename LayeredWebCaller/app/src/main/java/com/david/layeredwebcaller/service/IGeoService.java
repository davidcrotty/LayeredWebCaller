package com.david.layeredwebcaller.service;

import com.david.layeredwebcaller.model.HostModel;

import rx.Observable;

/**
 * Created by David Crotty on 10/03/2015.
 */
public interface IGeoService {
    Observable<HostModel> getIpAddress();
}
