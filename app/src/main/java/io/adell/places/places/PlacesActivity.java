package io.adell.places.places;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;
import io.adell.places.R;
import io.adell.places.data.PlacesService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlacesActivity extends FragmentActivity
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

  private PlacesPresenter placesPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_places);
    PlacesMapFragment placesMapFragment = PlacesMapFragment.newInstance();
    FragmentManager fm = getSupportFragmentManager();
    fm.beginTransaction().add(R.id.content_frame, placesMapFragment).commit();

    PlacesService placesService = new Retrofit.Builder()
        .baseUrl(PlacesService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PlacesService.class);

    GoogleApiClient googleApiClient = new GoogleApiClient.Builder(this)
        .addApi(Places.GEO_DATA_API)
        .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .enableAutoManage(this, this)
        .build();
    placesPresenter = new PlacesPresenter(placesService, getString(R.string.google_maps_key));
    placesPresenter.takeView(placesMapFragment);
    String sfLocation = "37.778644,-122.405680";
    placesPresenter.loadPlaces("restaurant", sfLocation);
    placesMapFragment.setPresenter(placesPresenter);
  }

  @Override
  public void onConnected(@Nullable Bundle bundle) {

  }

  @Override
  public void onConnectionSuspended(int i) {

  }

  @Override
  public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    placesPresenter.handleConnectionError();
  }
}
