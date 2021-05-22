package main.java.models;

import java.io.Serializable;
import java.util.Objects;

public class Store implements Serializable {

  private int storeId;
  private String name;
  private String website;

  public Store() {}

  public Store(int storeId, String name, String website) {
    this.storeId = storeId;
    this.name = name;
    this.website = website;
  }

  public int getStoreId() {
    return storeId;
  }

  public void setStoreId(int storeId) {
    this.storeId = storeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Store store = (Store) o;
    return storeId == store.storeId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(storeId);
  }
}
