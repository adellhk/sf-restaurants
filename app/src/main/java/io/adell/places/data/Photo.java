package io.adell.places.data;

/**
 * Created by Adell on 10/19/2017.
 */

public class Photo {
  String photoReference;
  int height;
  int width;

  public Photo(String photoReference, int height, int width) {
    this.photoReference = photoReference;
    this.height = height;
    this.width = width;
  }

  public Photo() {

  }

  public String getPhotoReference() {
    return photoReference;
  }

  public void setPhotoReference(String photoReference) {
    this.photoReference = photoReference;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }
}
