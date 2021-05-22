package main.java.controllers;

import java.util.ArrayList;
import java.util.List;
import main.java.dao.IGenericRepository;
import main.java.dao.RepositoryFactory;
import main.java.dao.impl.exception.ElementAlreadyExistsException;
import main.java.dao.impl.exception.ElementDoesNotExistException;
import main.java.models.PriceAlert;

public class PriceAlertController {

  private IGenericRepository<PriceAlert> priceAlertRepository;
  private static PriceAlertController instance;

  private PriceAlertController(){
    this.priceAlertRepository = RepositoryFactory.createPriceAlertRepository();
  }

  public static PriceAlertController getInstance() {

    if (instance == null) {
      instance = new PriceAlertController();
    }

    return instance;
  }

  public void insertPriceAlert(PriceAlert priceAlert) throws ElementAlreadyExistsException {
    priceAlertRepository.insert(priceAlert);
  }

  public List<PriceAlert> getAllPriceAlerts() {
    return new ArrayList<>(priceAlertRepository.list());
  }

  public IGenericRepository<PriceAlert> getPriceAlertRepository() {
    return priceAlertRepository;
  }

  public void updatePriceAlert(PriceAlert newPriceAlert)
      throws ElementDoesNotExistException {
    priceAlertRepository.update(newPriceAlert);
  }

  public void removePriceAlert(PriceAlert priceAlert)
      throws ElementDoesNotExistException {
    priceAlertRepository.remove(priceAlert);
  }
}
