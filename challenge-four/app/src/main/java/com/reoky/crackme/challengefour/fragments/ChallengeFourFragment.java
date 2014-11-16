package com.reoky.crackme.challengefour.fragments;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.reoky.crackme.challengefour.R;
import com.reoky.crackme.challengefour.listeners.ChallengeFourFragmentOnClickListener;

public class ChallengeFourFragment extends Fragment implements LocationListener {

    public ChallengeFourFragment() {}

    // Location
    private LocationManager locationManager;
    private Context context;
    private Location location;

    // UI
    private TextView textViewLatitude;
    private TextView textViewLongitude;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge_four, container, false);

        // Handle the user checking their answer
        final Button buttonCheck = (Button) view.findViewById(R.id.challenge_four_button_check);
        buttonCheck.setOnClickListener(new ChallengeFourFragmentOnClickListener(this));

        textViewLatitude = (TextView) view.findViewById(R.id.TextView_latitude);
        textViewLongitude = (TextView) view.findViewById(R.id.TextView_longitude);
        textViewLatitude.setText("Latitude: Waiting...");
        textViewLongitude.setText("Longitude: For A Lock...");
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        // Get the application context
        context = getActivity().getApplicationContext();

        // Get the location and configure the LocationManager
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public void onResume() {
        super.onResume();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1000, this);
    }

    @Override
    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    // This is the method that will complete the challenge if the coords are correctish
    public void checkLocation() {
        if (location != null) {
            if ((int) location.getLatitude() == 45 && (int) location.getLongitude() == -93) {
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1400);
                Toast.makeText(context, getString(R.string.string_challenge_four_win), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, getString(R.string.string_challenge_four_lose), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            textViewLatitude.setText("Latitude: " + location.getLatitude());
            textViewLongitude.setText("Longitude: " + location.getLongitude());
        } else {
            textViewLatitude.setText("Latitude: N/A");
            textViewLongitude.setText("Longitude: N/A");
        }
        this.location = location;
    }

    // Those method stubs that I have to have, but just don't need
    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {}
    @Override
    public void onProviderEnabled(String s) {}
    @Override
    public void onProviderDisabled(String s) {}
}
