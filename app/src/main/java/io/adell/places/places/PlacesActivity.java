package io.adell.places.places;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import io.adell.places.R;

public class PlacesActivity extends FragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_places);
    PlacesMapFragment placesMapFragment = PlacesMapFragment.newInstance();
    FragmentManager fm = getSupportFragmentManager();
    fm.beginTransaction().add(R.id.content_frame, placesMapFragment).commit();
  }
}
