package main.java.controllers;

import java.util.ArrayList;
import java.util.List;
import main.java.dao.IGenericRepository;
import main.java.dao.RepositoryFactory;
import main.java.dao.impl.exception.ElementAlreadyExistsException;
import main.java.dao.impl.exception.ElementDoesNotExistException;
import main.java.models.Product;


public class ProductController {

  private IGenericRepository<Product> productRepository;
  private static ProductController instance;

  private ProductController(){
    this.productRepository = RepositoryFactory.createProductRepository();
  }

  public static ProductController getInstance() {

    if (instance == null) {
      instance = new ProductController();
    }

    return instance;
  }

  public void insertProduct(Product product) throws ElementAlreadyExistsException {
    productRepository.insert(product);
  }

  public List<Product> getAllProducts() {
    return new ArrayList<>(productRepository.list());
  }

  public IGenericRepository<Product> getProductRepository() {
    return productRepository;
  }

  public void updateProduct(Product newProduct)
      throws ElementDoesNotExistException {
      productRepository.update(newProduct);
  }

  public void removeProduct(Product product) throws ElementDoesNotExistException {
    productRepository.remove(product);
  }

  /*public static void main(String[] args)
      throws ElementAlreadyExistsException, ElementDoesNotExistException {
    Product product01 = new Product(1,"Celular","aaaaaaa", ProductCategory.ELECTRONIC);
    Product product02 = new Product(2,"Bola","aaababasdaa", ProductCategory.TOY);

    ProductController.getInstance().insertProduct(product01);
    ProductController.getInstance().insertProduct(product02);

    for(Product t : ProductController.getInstance().getAllProducts()){
      System.out.println(t);
      System.out.println("--------------------------------------------------------------");
    }

    Product product03 = new Product(3,"Nada","aaa2aaassa", ProductCategory.ELECTRONIC);
    ProductController.getInstance().updateProduct(product01,product03);

    for(Product t : ProductController.getInstance().getAllProducts()){
      System.out.println(t);
      System.out.println("--------------------------------------------------------------");
    }
  }*/
}


