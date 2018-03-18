package com.example.karthikreddy.intelimentjson.Model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by karthikreddy on 18/03/18.
 */

public class Location {
    @SerializedName("latitude") private String latitude;
    @SerializedName("longitude") private String longitude;

    @NonNull public String getLatitude() {
        return latitude;
    }

    @NonNull public String getLongitude() {
        return longitude;
    }

}
