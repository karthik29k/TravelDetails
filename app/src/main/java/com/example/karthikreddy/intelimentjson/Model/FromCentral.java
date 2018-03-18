package com.example.karthikreddy.intelimentjson.Model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by karthikreddy on 18/03/18.
 */

public class FromCentral {
    @SerializedName("car")
    private String car;
    @SerializedName("train")
    private String train;

    @NonNull
    public String getCar() {
        return car;
    }

    public String getTrain() {
        return train == null ? "No info" : train;
    }
}