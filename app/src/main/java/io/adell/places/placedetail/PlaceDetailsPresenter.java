package io.adell.places.placedetail;

import android.util.Log;
import io.adell.places.data.PlaceDetailsSearchResponse;
import io.adell.places.data.PlacesSearchResponse;
import io.adell.places.data.PlacesService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adell on 10/19/2017.
 */

public class PlaceDetailsPresenter implements PlaceDetailsContract.Presenter {
  private String placeId;
  private final PlacesService placesService;
  private final String mapsApiKey;

  public PlaceDetailsPresenter(String placeId, PlacesService placesService, String mapsApiKey) {
    this.placeId = placeId;
    this.placesService = placesService;
    this.mapsApiKey = mapsApiKey;
  }

  @Override
  public void takeView(PlaceDetailsContract.View view) {

  }

  @Override
  public void dropView() {

  }

  @Override
  public void loadPlaceDetails() {
    Disposable getPlaceDetails = placesService
        .getPlaceDetails(placeId, mapsApiKey)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribeWith(new DisposableSingleObserver<PlaceDetailsSearchResponse>() {

          @Override
          public void onSuccess(@NonNull PlaceDetailsSearchResponse placeDetailsSearchResponse) {
            Log.d("PlaceDetailsPresenter", "onSuccess: "+placeDetailsSearchResponse.getResult());
          }

          @Override
          public void onError(@NonNull Throwable e) {
            Log.d("PlaceDetailsPresenter", "onError: " + e);
          }
        });

  }
}
