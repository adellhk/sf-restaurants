package io.adell.places.data;

import java.util.List;

/**
 * Created by Adell on 10/19/2017.
 */

public class PlacesSearchResponse {
  List<Place> results;

  public PlacesSearchResponse(List<Place> results) {
    this.results = results;
  }

  public List<Place> getResults() {
    return results;
  }

  public void setResults(List<Place> results) {
    this.results = results;
  }
}
