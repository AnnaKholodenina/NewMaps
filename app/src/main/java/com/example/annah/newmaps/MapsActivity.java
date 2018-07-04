package com.example.annah.newmaps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    ImageButton mylocation;

    private GoogleMap mMap;
    private LatLngBounds JAPAN = new LatLngBounds(
            new LatLng(31.43, 130.29), new LatLng(42.70, 142.25)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mylocation = (ImageButton) findViewById(R.id.mylocation);

        /*OnClickListener mylocation = new OnClickListener() {
            @Override
            public void onClick(View v) {
                 mylocation.setText;

            }*/
        };


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng japan = new LatLng(36.01, 138.53);
        googleMap.addMarker(new MarkerOptions()
                .position(japan)
                .title("Япония")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.japan))
                .flat(true)
                .rotation(90));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(JAPAN.getCenter(), 10));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(japan, 6));
        mMap.setLatLngBoundsForCameraTarget(JAPAN);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
    }
}
