package main.java.dao;

import main.java.dao.impl.GenericRepository;
import main.java.models.PriceAlert;
import main.java.models.Product;
import main.java.models.ProductOffer;
import main.java.models.Store;
import main.java.models.User;

public class RepositoryFactory {

  private static IGenericRepository<Product> productRepository;
  private static IGenericRepository<User> userRepository;
  private static IGenericRepository<ProductOffer> productOfferRepository;
  private static IGenericRepository<PriceAlert> priceAlertRepository;
  private static IGenericRepository<Store> storeRepository;


  public static IGenericRepository createProductRepository() {

    if (productRepository == null) {
      productRepository = new GenericRepository<>("./localStorage/products.dat");
    }

    return productRepository;
  }

  public static IGenericRepository createPriceAlertRepository() {

    if (priceAlertRepository == null) {
      priceAlertRepository = new GenericRepository<>("./localStorage/priceAlerts.dat");
    }

    return priceAlertRepository;
  }

  public static IGenericRepository createProductOfferRepository() {

    if (productOfferRepository == null) {
      productOfferRepository = new GenericRepository<>("./localStorage/productOffers.dat");
    }

    return productOfferRepository;
  }

  public static IGenericRepository createUserRepository() {

    if (userRepository == null) {
      userRepository = new GenericRepository<>("./localStorage/users.dat");
    }

    return userRepository;
  }

  public static IGenericRepository createStoreRepository() {

    if (storeRepository == null) {
      storeRepository = new GenericRepository<>("./localStorage/store.dat");
    }

    return storeRepository;
  }

}
