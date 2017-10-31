package io.adell.places.placedetail;

import io.adell.places.BasePresenter;
import io.adell.places.BaseView;

/**
 * Created by Adell on 10/19/2017.
 */

public interface PlaceDetailsContract {
  interface View extends BaseView<Presenter> {
    void showPlace();

    void callPlace();
  }

  interface Presenter extends BasePresenter<View> {
    void loadPlaceDetails();


  }
}
