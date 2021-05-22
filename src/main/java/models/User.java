package main.java.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable {

  private int userId;
  private String email;
  private String name;
  private LocalDate birthDate;
  private ArrayList<PriceAlert> priceAlerts;

  public User() {}

  public User(String email, String name, LocalDate birthDate) {
    this.email = email;
    this.name = name;
    this.birthDate = birthDate;

  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public ArrayList<PriceAlert> getPriceAlerts() {
    return priceAlerts;
  }

  public void setPriceAlerts(ArrayList<PriceAlert> priceAlerts) {
    this.priceAlerts = priceAlerts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return email.equals(user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  @Override
  public String toString() {
    return "User{" +
        "userId=" + userId +
        ", email='" + email + '\'' +
        ", name='" + name + '\'' +
        ", birthDate=" + birthDate +
        '}';
  }
}
