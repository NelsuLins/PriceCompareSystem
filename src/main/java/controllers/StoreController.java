package main.java.controllers;

import java.util.ArrayList;
import java.util.List;
import main.java.dao.IGenericRepository;
import main.java.dao.RepositoryFactory;
import main.java.dao.impl.exception.ElementAlreadyExistsException;
import main.java.dao.impl.exception.ElementDoesNotExistException;
import main.java.models.Store;

public class StoreController {

  private IGenericRepository<Store> storeRepository;
  private static StoreController instance;

  private StoreController(){
    this.storeRepository = RepositoryFactory.createStoreRepository();
  }

  public static StoreController getInstance() {

    if (instance == null) {
      instance = new StoreController();
    }

    return instance;
  }

  public void insertStore(Store store) throws ElementAlreadyExistsException {
    storeRepository.insert(store);
  }

  public List<Store> getAllStores() {
    return new ArrayList<>(storeRepository.list());
  }

  public IGenericRepository<Store> getStoreRepository() {
    return storeRepository;
  }

  public void updateStore(Store newStore)
      throws ElementDoesNotExistException {
    storeRepository.update(newStore);
  }

  public void removeStore(Store store) throws ElementDoesNotExistException {
    storeRepository.remove(store);
  }

}
