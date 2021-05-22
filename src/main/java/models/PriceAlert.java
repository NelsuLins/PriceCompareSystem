package main.java.models;

import java.io.Serializable;
import java.util.Objects;

public class PriceAlert implements Serializable {

  private int priceAlertId;
  private User user;
  private Product product;
  private double price;

  public PriceAlert() {}

  public PriceAlert(User user, Product product, double price) {
    this.user = user;
    this.product = product;
    this.price = price;
  }

  public int getPriceAlertId() {
    return priceAlertId;
  }

  public void setPriceAlertId(int priceAlertId) {
    this.priceAlertId = priceAlertId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceAlert that = (PriceAlert) o;
    return Double.compare(that.price, price) == 0 &&
        product.equals(that.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, price);
  }
}
