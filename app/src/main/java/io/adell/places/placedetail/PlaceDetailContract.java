package io.adell.places.placedetail;

import io.adell.places.BasePresenter;
import io.adell.places.BaseView;

/**
 * Created by Adell on 10/19/2017.
 */

public interface PlaceDetailContract {
  interface View extends BaseView<Presenter> {

  }

  interface Presenter extends BasePresenter<View> {

  }
}
