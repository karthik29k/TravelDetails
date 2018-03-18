package com.example.karthikreddy.intelimentjson.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.karthikreddy.intelimentjson.Model.TravelDetails;
import com.example.karthikreddy.intelimentjson.R;
import com.example.karthikreddy.intelimentjson.util.HttpHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import icepick.Icepick;
import icepick.Icicle;

/**
 * Created by karthikreddy on 18/03/18.
 */

public class MainActivity extends Activity {

    @BindView(R.id.carTravelTime) TextView carResult;
    @BindView(R.id.trainTravelTime) TextView trainResult;
    @BindView(R.id.destination_spinner) Spinner spinner;
    @BindView(R.id.navigateBtn) Button navigate;

    @Icicle int itemPosition;

    private String carTime, trainTime, latitude, longitude;
    private List<TravelDetails> travelDetailsList;
    private ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new FetchData().execute();
    }

    @OnClick(R.id.navigateBtn)
    public void setNavigate() { navigateToMaps();}

    @OnItemSelected(R.id.destination_spinner)
    public void spinnerOnItemSelected(int position) {
        itemPosition = position;
        updateDetails();
        populateScreen();
    }

    private void updateDetails() {
        carTime = travelDetailsList.get(itemPosition).getFromCentrals().getCar();
        trainTime = travelDetailsList.get(itemPosition).getFromCentrals().getTrain();
        latitude = travelDetailsList.get(itemPosition).getLocation().getLatitude();
        longitude = travelDetailsList.get(itemPosition).getLocation().getLongitude();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        spinner.setSelection(itemPosition);
        populateScreen();
    }

    private void populateScreen() {
        carResult.setText(carTime);
        trainResult.setText(trainTime);
    }

    private void navigateToMaps() {
        Intent intent = null , chooser = null;
        intent = new Intent(android.content.Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:"+ latitude + ","+ longitude));
        chooser = Intent.createChooser(intent, "Launch Maps");
        startActivity(chooser);
    }

    private void setSpinnerAdapter() {
        spinnerAdapter = new ArrayAdapter(MainActivity.this,
                            android.R.layout.simple_spinner_item,
                            getDestinations());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    private String[] getDestinations() {
        int numberOfDestinations = travelDetailsList.size();
        String [] destinations = new String[numberOfDestinations];
        for (int index = 0; index < numberOfDestinations; index++) {
            TravelDetails travelDetails = travelDetailsList.get(index);
            destinations[index] = travelDetails.getName();
        }
        return destinations;
    }

    private class FetchData extends AsyncTask<Void, Void, Void> {
        private String BASE_URL = "http://express-it.optusnet.com.au/sample.json";

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler httpHandler = new HttpHandler();
            String jsonStr = httpHandler.makeServiceCall(BASE_URL);

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<TravelDetails>>(){}.getType();

            travelDetailsList = gson.fromJson(jsonStr, listType);
            return null;
        }

        @Override
        protected void onPostExecute(Void s) {
            super.onPostExecute(s);
            setSpinnerAdapter();
        }
    }
}

