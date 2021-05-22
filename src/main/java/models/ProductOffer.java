package main.java.models;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

public class ProductOffer implements Comparable<ProductOffer>, Serializable {

  private int productOfferId;
  private Product product;
  private Store store;
  private LocalDate offerDate;
  private double price;

  public ProductOffer() {}

  public ProductOffer(int productOfferId, Product product, Store store, LocalDate offerDate, double price) {
    this.productOfferId = productOfferId;
    this.product = product;
    this.store = store;
    this.offerDate = offerDate;
    this.price = price;
  }

  public int getProductOfferId() {
    return productOfferId;
  }

  public void setProductOfferId(int productOfferId) {
    this.productOfferId = productOfferId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }

  public LocalDate getOfferDate() {
    return offerDate;
  }

  public void setOfferDate(LocalDate offerDate) {
    this.offerDate = offerDate;
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
    ProductOffer that = (ProductOffer) o;
    return Double.compare(that.price, price) == 0 &&
        product.equals(that.product) &&
        store.equals(that.store) &&
        offerDate.equals(that.offerDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, store, offerDate, price);
  }

  @Override
  public String toString() {

    DecimalFormat df = new DecimalFormat("0.00");

    return "ProductOffer{" +
        "Store: " + store.getName() +
        " | Price: R$ " + df.format(price) +
        " | Website: " + store.getWebsite() +
        '}';
  }

  public int compareTo(ProductOffer offer) {
    return Double.compare(getPrice(), offer.getPrice());
  }
}
