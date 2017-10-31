package io.adell.places.data;

/**
 * Created by Adell on 10/31/2017.
 */

public class PlaceDetailsSearchResponse {
  Place result;

  public PlaceDetailsSearchResponse(Place result) {
    this.result = result;
  }

  public Place getResult() {
    return result;
  }
}
