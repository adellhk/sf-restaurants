package io.adell.places.places;

import io.adell.places.BasePresenter;
import io.adell.places.BaseView;

/**
 * Created by Adell on 10/19/2017.
 */

public interface PlacesContract {
  interface Presenter extends BasePresenter<View> {
    void loadPlaces();

    void openPlaceDetails();
  }

  interface View extends BaseView<Presenter> {
    void showPlaceDetails();

    void showPlaces();
  }
}
