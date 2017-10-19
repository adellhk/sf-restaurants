package io.adell.places.places;

import android.util.Log;
import io.adell.places.data.Place;
import io.adell.places.data.PlacesSearchResponse;
import io.adell.places.data.PlacesService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Created by Adell on 10/19/2017.
 */

public class PlacesPresenter implements PlacesContract.Presenter {

  private final PlacesService placesService;
  public List<Place> places;
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
    Disposable getPlaces = placesService
        .getPlaces(type, location, "1500", mapsApiKey)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribeWith(new DisposableSingleObserver<PlacesSearchResponse>() {

          @Override
          public void onSuccess(@NonNull PlacesSearchResponse placesSearchResponse) {
            places = placesSearchResponse.getResults();
          }

          @Override
          public void onError(@NonNull Throwable e) {
            Log.d("PlacesPresenter", "onError: " + e);
          }
        });
  }

  @Override
  public void openPlaceDetails() {

  }

  @Override
  public void handleConnectionError() {
    view.showConnectionError();
  }
}
