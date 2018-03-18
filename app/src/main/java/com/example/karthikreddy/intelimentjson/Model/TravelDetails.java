package com.example.karthikreddy.intelimentjson.Model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by karthikreddy on 18/03/18.
 */

public class TravelDetails {
    @SerializedName("name") private String name;
    @SerializedName("fromcentral") private FromCentral fromcentral;
    @SerializedName("location") private Location location;

    @NonNull public String getName() {
        return name;
    }

    @NonNull public FromCentral getFromCentrals() {
        return fromcentral;
    }

    @NonNull public Location getLocation() {
        return location;
    }
}


