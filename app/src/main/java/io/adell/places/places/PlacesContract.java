package io.adell.places.places;

import io.adell.places.BasePresenter;
import io.adell.places.BaseView;
import io.adell.places.data.Place;
import java.util.List;

/**
 * Created by Adell on 10/19/2017.
 */

public interface PlacesContract {
  interface Presenter extends BasePresenter<View> {

    void loadPlaces(String type, String location);

    void openPlaceDetails();

    void handleConnectionError();
  }

  interface View extends BaseView<Presenter> {
    void showPlaceDetails();

    void showPlaces(List<Place> places);

    void showConnectionError();
  }
}
