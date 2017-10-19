package io.adell.places.places;

import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import io.adell.places.data.Place;
import java.util.List;

/**
 * Created by Adell on 10/19/2017.
 */

public class PlacesMapFragment extends SupportMapFragment implements PlacesContract.View,
    OnMapReadyCallback, GoogleMap.OnPoiClickListener {
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
  public void showPlaceDetails(Place place) {
    Toast.makeText(getContext(), "place: "+place.getName(), Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showPlaces(List<Place> places) {
    for (Place place : places) {
      Place.Location placeLocation = place.getGeometry().getLocation();
      LatLng placeLatLng = new LatLng(placeLocation.getLat(), placeLocation.getLng());
      map.addMarker(new MarkerOptions().position(placeLatLng).title(place.getName()));
    }
  }

  @Override
  public void showConnectionError() {
    Toast.makeText(getContext(), "Connection error", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    map = googleMap;
    LatLng sf = new LatLng(37.778644,-122.405680);
    map.moveCamera(CameraUpdateFactory.newLatLng(sf));
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(sf, 14.0f));
    map.setOnPoiClickListener(this);
    map.seton
  }

  @Override
  public void onPoiClick(PointOfInterest pointOfInterest) {
    presenter.openPlaceDetails(pointOfInterest.placeId);
  }
}