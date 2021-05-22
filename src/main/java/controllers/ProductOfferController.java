package main.java.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import main.java.dao.IGenericRepository;
import main.java.dao.RepositoryFactory;
import main.java.dao.impl.exception.ElementAlreadyExistsException;
import main.java.dao.impl.exception.ElementDoesNotExistException;
import main.java.models.PriceAlert;
import main.java.models.Product;
import main.java.models.ProductCategory;
import main.java.models.ProductOffer;
import main.java.models.Store;
import main.java.models.User;

public class ProductOfferController {

  private IGenericRepository<ProductOffer> productOfferRepository;
  private static ProductOfferController instance;

  private ProductOfferController(){
    this.productOfferRepository = RepositoryFactory.createProductOfferRepository();
  }

  public static ProductOfferController getInstance() {

    if (instance == null) {
      instance = new ProductOfferController();
    }

    return instance;
  }

  public void insertProductOffer(ProductOffer productOffer) throws ElementAlreadyExistsException {
    productOfferRepository.insert(productOffer);
  }

  public List<ProductOffer> getAllProductOffers() {
    return new ArrayList<>(productOfferRepository.list());
  }

  public IGenericRepository<ProductOffer> getProductOfferRepository() {
    return productOfferRepository;
  }

  public void updateProductOffer(ProductOffer newProductOffer)
      throws ElementDoesNotExistException {
    productOfferRepository.update(newProductOffer);
  }

  public void removeProductOffer(ProductOffer productOffer) throws ElementDoesNotExistException {
    productOfferRepository.remove(productOffer);
  }

  public List<ProductOffer> listOffersOrderedByPrice(Product product, LocalDate date){

    ArrayList<ProductOffer> listOffersOrderedByPrice = new ArrayList<>();

    for (ProductOffer u : getAllProductOffers()){
      if(u.getProduct().equals(product) && u.getOfferDate().equals(date)){
        listOffersOrderedByPrice.add(u);
      }
    }

    Collections.sort(listOffersOrderedByPrice);
    return listOffersOrderedByPrice;
  }

  public Map<LocalDate, List<ProductOffer>> offerHistory(Product product, LocalDate initialD, LocalDate finalD){

    LocalDate tempD1 = initialD;
    LocalDate tempD2 = finalD.plusDays(1);

    Map<LocalDate, List<ProductOffer>> tempMap = new HashMap<LocalDate, List<ProductOffer>>();
    List<ProductOffer> tempList = new ArrayList<>();

    while (tempD1.isBefore(tempD2)){

      for (ProductOffer u : getAllProductOffers()){
        if(u.getProduct().equals(product) && u.getOfferDate().equals(tempD1)){
          tempList.add(u);
        }
      }

      Collections.sort(tempList);

      if (!tempList.isEmpty()) {
        tempMap.put(LocalDate.from(tempD1), (List<ProductOffer>) ((ArrayList<ProductOffer>) tempList).clone());
      }
      tempD1 = tempD1.plusDays(1);
      tempList.clear();
    }

    return tempMap;
  }

  List<PriceAlert> verifyPriceAlert(User u){

    ArrayList<PriceAlert> listAlerts = new ArrayList<>();

    for (ProductOffer v : getAllProductOffers()){
      for(PriceAlert w : u.getPriceAlerts()){
        if(w.getPrice() >= v.getPrice()){
          listAlerts.add(w);
        }
      }
    }

    return listAlerts;
  }

  public static void main(String[] args) throws ElementAlreadyExistsException {

    Product product1 = new Product(1,"Celular","aaaaaa", ProductCategory.ELECTRONIC);
    Store store1 = new Store(2,"Kabum","www.kabum.com");
    DateTimeFormatter formatadorTraco = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate d1 = LocalDate.parse("01-05-2021",formatadorTraco);
    LocalDate d2 = LocalDate.parse("02-05-2021",formatadorTraco);
    LocalDate d3 = LocalDate.parse("03-05-2021",formatadorTraco);
    LocalDate d4 = LocalDate.parse("04-05-2021",formatadorTraco);
    ProductOffer p1 = new ProductOffer(3,product1,store1,d1,300);
    ProductOffer p2 = new ProductOffer(4,product1,store1,d2,350);
    ProductOffer p3 = new ProductOffer(5,product1,store1,d3,320);
    ProductOffer p4 = new ProductOffer(6,product1,store1,d4,325);
    ProductOffer p5 = new ProductOffer(7,product1,store1,d4,310);

    /*ProductOfferController.getInstance().insertProductOffer(p1);
    ProductOfferController.getInstance().insertProductOffer(p2);
    ProductOfferController.getInstance().insertProductOffer(p3);
    ProductOfferController.getInstance().insertProductOffer(p4);
    ProductOfferController.getInstance().insertProductOffer(p5);*/

    Map<LocalDate, List<ProductOffer>> test = ProductOfferController.getInstance().offerHistory(product1,d1,d4);

    List<LocalDate> test2 = new ArrayList<>();

    for (LocalDate u : test.keySet()){
      test2.add(u);
    }

    Collections.sort(test2);

    for (LocalDate u : test2){
      List<ProductOffer> tempList;
      tempList = test.get(u);
      System.out.println(u);
      for (ProductOffer v : tempList){
        System.out.println(v);
      }
      tempList.clear();
      System.out.println("--------------------------------------------");
    }


  }
}
