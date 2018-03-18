package com.example.karthikreddy.intelimentjson.Model;

import com.google.gson.Gson;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

/**
 * Created by karthikreddy on 19/03/18.
 */

public class FromCentralTest {

    @Test
    public void getCar_returnsAnException_whenNull() throws Exception {
        FromCentral fromCentral = new FromCentral();
        try {
            assertTrue(fromCentral.getCar().isEmpty());
            fail("Car should never be null");
        } catch (NullPointerException e) {
            // test pass
        }
    }

    @Test
    public void getTrain_returnsNoInfo_whenNull() throws Exception {
        FromCentral fromCentral = new FromCentral();
        assertTrue(fromCentral.getTrain().equals( "No info"));
    }

    @Test
    public void getTrain_returnCarTravel_whenNotNull() throws Exception {
        // Setup
        String jsonString = "{ \"car\": \"80 Mins\", \"train\": \"120 Mins\"}";
        FromCentral fromCentral = new Gson().fromJson(jsonString, FromCentral.class);

        // verify
        assertTrue(fromCentral.getTrain().equals("120 Mins"));
    }

    @Test
    public void getCar_returnCarTravel_whenNotNull() throws Exception {
        // Setup
        String jsonString = "{ \"car\": \"80 Mins\", \"train\": \"120 Mins\"}";
        FromCentral fromCentral = new Gson().fromJson(jsonString, FromCentral.class);

        // verify
        assertTrue(fromCentral.getCar().equals("80 Mins"));
    }

    @Test
    public void getTrain_returnNoInfo_whenTrainIsNotReturned() throws Exception {
        // Setup
        String jsonString = "{ \"car\": \"80 Mins\"}";
        FromCentral fromCentral = new Gson().fromJson(jsonString, FromCentral.class);

        // verify
        assertTrue(fromCentral.getTrain().equals( "No info"));
    }

}