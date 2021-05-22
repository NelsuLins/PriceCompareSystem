package main.java.controllers;

import java.util.ArrayList;
import java.util.List;
import main.java.dao.IGenericRepository;
import main.java.dao.RepositoryFactory;
import main.java.dao.impl.exception.ElementAlreadyExistsException;
import main.java.dao.impl.exception.ElementDoesNotExistException;
import main.java.models.User;

public class UserController {

  private IGenericRepository<User> userRepository;
  private static UserController instance;

  private UserController(){
    this.userRepository = RepositoryFactory.createUserRepository();
  }

  public static UserController getInstance() {

    if (instance == null) {
      instance = new UserController();
    }

    return instance;
  }

  public void insertUser(User user) throws ElementAlreadyExistsException {
    userRepository.insert(user);
  }

  public List<User> getAllUsers() {
    return new ArrayList<>(userRepository.list());
  }

  public IGenericRepository<User> getUserRepository() {
    return userRepository;
  }

  public void updateUser(User newUser)
      throws ElementDoesNotExistException {
    userRepository.update(newUser);
  }

  public void removeStore(User user) throws ElementDoesNotExistException {
    userRepository.remove(user);
  }

}
