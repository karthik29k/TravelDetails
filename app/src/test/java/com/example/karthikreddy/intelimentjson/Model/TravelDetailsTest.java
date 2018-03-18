package com.example.karthikreddy.intelimentjson.Model;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by karthikreddy on 19/03/18.
 */

public class TravelDetailsTest {

    String jsonString = "{" +
    "\"id\": 1, \"name\": \"Blue Mountains\"," +
    "\"fromcentral\": {\"car\": \"80 Mins\",\"train\": \"120 Mins\"}," +
    "\"location\": {\"latitude\": -33.7181, \"longitude\": 150.3160 }" +
    "}";

    TravelDetails travelDetails = new Gson().fromJson(jsonString, TravelDetails.class);

    @Test
    public void getName_returnsName_whenAssigned() throws Exception {
        assertEquals(travelDetails.getName(), "Blue Mountains");
    }

    @Test
    public void getFromCentrals_returnsFromCentral_whenAssigned() throws Exception {
        assertEquals(travelDetails.getFromCentrals().getCar(), "80 Mins");
        assertEquals(travelDetails.getFromCentrals().getTrain(), "120 Mins");
    }

    @Test
    public void getLocation_returnsLocation_whenAssigned() throws Exception {
        assertEquals(travelDetails.getLocation().getLatitude(), "-33.7181");
        assertEquals(travelDetails.getLocation().getLongitude(), "150.3160");
    }

}