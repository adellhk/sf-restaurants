package io.adell.places.places;

import io.adell.places.data.PlacesService;

/**
 * Created by Adell on 10/19/2017.
 */

public class PlacesPresenter implements PlacesContract.Presenter {

  private final PlacesService placesService;
  private PlacesContract.View view;
  private String mapsApiKey;

  public PlacesPresenter(PlacesService placesService, String mapsApiKey) {
    this.placesService = placesService;
    this.mapsApiKey = mapsApiKey;
  }

  @Override
  public void takeView(PlacesContract.View view) {
    this.view = view;
  }

  @Override
  public void dropView() {
    this.view = null;
  }

  @Override
  public void loadPlaces(String type, String location) {
    placesService.getPlaces(type, location, "1500", mapsApiKey);
  }

  @Override
  public void openPlaceDetails() {

  }

  @Override
  public void handleConnectionError() {
    view.showConnectionError();
  }
}
