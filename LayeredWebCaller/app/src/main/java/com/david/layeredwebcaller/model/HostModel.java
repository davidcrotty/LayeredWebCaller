package com.david.layeredwebcaller.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by David Crotty on 10/03/2015.
 */
public class HostModel {
    @SerializedName("ip")
    private String _ipAddress;
    public HostModel(String ipAddress) {
        _ipAddress = ipAddress;
    }
    public String getIpAddress(){
        return _ipAddress;
    }
}
