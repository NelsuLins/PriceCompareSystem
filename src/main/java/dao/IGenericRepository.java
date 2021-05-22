package main.java.dao;

import java.util.List;

import main.java.dao.impl.exception.ElementAlreadyExistsException;
import main.java.dao.impl.exception.ElementDoesNotExistException;

public interface IGenericRepository<T> {
    
    void insert(T obj) throws ElementAlreadyExistsException;
    
    List<T> list();
    
    void remove(T obj) throws ElementDoesNotExistException;

    void update(T newObj) throws ElementDoesNotExistException;

}
