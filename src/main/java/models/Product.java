package main.java.models;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

  private int productId;
  private String name;
  private String description;
  private ProductCategory productCategory;

  public Product() {}

  public Product(int productId, String name, String description,
      ProductCategory productCategory) {

    this.productId = productId;
    this.name = name;
    this.description = description;
    this.productCategory = productCategory;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductCategory getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(ProductCategory productCategory) {
    this.productCategory = productCategory;
  }

  @Override
  public String toString() {
    return "Product{" +
        "productId=" + productId +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", productCategory=" + productCategory +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return name.equals(product.name) &&
        description.equals(product.description) &&
        productCategory == product.productCategory;
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId);
  }
}
