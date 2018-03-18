package com.example.karthikreddy.intelimentjson.Model;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by karthikreddy on 19/03/18.
 */

public class LocationTest {
    private String jsonString = "{\"latitude\": -33.7181, \"longitude\": 150.3160 }";
    private Location location = new Gson().fromJson(jsonString, Location.class);

    @Test
    public void getLatitude() throws Exception {
        assertEquals(location.getLatitude(), "-33.7181");
    }

    @Test
    public void getLongitude() throws Exception {
        assertEquals(location.getLongitude(), "150.3160");
    }

}