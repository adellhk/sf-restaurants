package io.adell.places.places;

/**
 * Created by Adell on 10/19/2017.
 */

public class PlacesPresenter implements PlacesContract.Presenter {

  private PlacesContract.View view;

  @Override
  public void takeView(PlacesContract.View view) {
    this.view = view;
  }

  @Override
  public void dropView() {
    this.view = null;
  }

  @Override
  public void loadPlaces() {

  }

  @Override
  public void openPlaceDetails() {

  }
}
