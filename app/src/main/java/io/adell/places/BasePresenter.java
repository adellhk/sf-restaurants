package io.adell.places;

/**
 * Created by Adell on 10/19/2017.
 */

public interface BasePresenter<T> {
  void takeView(T view);

  void dropView();
}
