package io.adell.places.data;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Adell on 10/19/2017.
 */

public interface PlacesService {
  String BASE_URL = "https://maps.googleapis.com";

  @GET("/maps/api/place/search/json")
  Single<PlacesSearchResponse> getPlaces(@Query("types") String types,
      @Query("location") String location,
      @Query("radius") String radius,
      @Query("key") String key);

  @GET("/maps/api/place/details/json")
  Single<PlaceDetailsSearchResponse> getPlaceDetails(@Query("placeid") String placeId,
      @Query("key") String mapsApiKey);
}
