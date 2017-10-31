package io.adell.places.placedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.adell.places.R;
import io.adell.places.data.Place;

/**
 * Created by Adell on 10/19/2017.
 */

public class PlaceDetailFragment extends Fragment implements PlaceDetailsContract.View {
  private PlaceDetailsContract.Presenter presenter;
  private Place place;

  public static PlaceDetailFragment newInstance(Place place) {
    PlaceDetailFragment fragment = new PlaceDetailFragment();
    fragment.place = place;
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_places_detail, container, false);
    return v;
  }

  @Override
  public void showPlace() {
    getView().findViewById(R.id.place_name);
  }

  @Override
  public void callPlace() {

  }

  @Override
  public void setPresenter(PlaceDetailsContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
