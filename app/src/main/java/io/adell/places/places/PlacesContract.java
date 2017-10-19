package io.adell.places.places;

import io.adell.places.BasePresenter;
import io.adell.places.BaseView;

/**
 * Created by Adell on 10/19/2017.
 */

public interface PlacesContract {
  interface Presenter extends BasePresenter<View> {

  }

  interface View extends BaseView<Presenter> {

  }
}
