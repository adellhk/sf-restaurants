package io.adell.places.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Adell on 10/19/2017.
 */

public class Place {

  @SerializedName("icon")
  @Expose
  private String icon;
  @SerializedName("id")
  @Expose
  private String id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("photos")
  @Expose
  private List<Photo> photos = null;
  @SerializedName("place_id")
  @Expose
  private String placeId;
  @SerializedName("scope")
  @Expose
  private String scope;
  @SerializedName("reference")
  @Expose
  private String reference;
  @SerializedName("types")
  @Expose
  private List<String> types = null;
  @SerializedName("vicinity")
  @Expose
  private String vicinity;

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Photo> getPhotos() {
    return photos;
  }

  public void setPhotos(List<Photo> photos) {
    this.photos = photos;
  }

  public String getPlaceId() {
    return placeId;
  }

  public void setPlaceId(String placeId) {
    this.placeId = placeId;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public List<String> getTypes() {
    return types;
  }

  public void setTypes(List<String> types) {
    this.types = types;
  }

  public String getVicinity() {
    return vicinity;
  }

  public void setVicinity(String vicinity) {
    this.vicinity = vicinity;
  }
}
