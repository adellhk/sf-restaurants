package io.adell.places.places;

import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Adell on 10/19/2017.
 */

public class PlacesMapFragment extends SupportMapFragment implements PlacesContract.View,
    OnMapReadyCallback {
  private PlacesContract.Presenter presenter;
  private GoogleMap map;

  public static PlacesMapFragment newInstance() {
    PlacesMapFragment fragment = new PlacesMapFragment();
    return fragment;
  }

  @Override
  public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    getMapAsync(this);
  }

  @Override
  public void setPresenter(PlacesContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void showPlaceDetails() {

  }

  @Override
  public void showPlaces() {

  }

  @Override
  public void showConnectionError() {
    Toast.makeText(getContext(), "Connection error", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    map = googleMap;

    // Add a marker in Sydney and move the camera
    LatLng sydney = new LatLng(-34, 151);
    map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
    map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
  }
}