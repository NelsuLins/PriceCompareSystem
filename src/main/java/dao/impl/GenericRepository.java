package main.java.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.java.dao.IGenericRepository;
import main.java.dao.impl.exception.ElementAlreadyExistsException;
import main.java.dao.impl.exception.ElementDoesNotExistException;

public class GenericRepository<T> implements IGenericRepository<T> {
    
    protected List<T> elements;
    private String filename;

    public GenericRepository(String filename) {
        this.filename = filename;
        this.elements = new ArrayList<>();
        
        Object elementsList = FileUtilRepository.readFile(this.filename);
        if (elementsList != null && elementsList instanceof List<?>){
            this.elements = (List<T>) elementsList;
        }
    }

    public GenericRepository() {}

    @Override
    public void insert(T newObj) throws ElementAlreadyExistsException {
        if (!this.elements.contains(newObj)) {
            this.elements.add(newObj);
        } else {
            throw new ElementAlreadyExistsException(newObj);
        }
        
        FileUtilRepository.saveFile(elements, this.filename);
    }

    @Override
    public List<T> list() {
        return Collections.unmodifiableList(this.elements);
    }

    @Override
    public void remove(T obj) throws ElementDoesNotExistException {
        if (this.elements.contains(obj)) {
            this.elements.remove(this.elements.indexOf(obj));
        } else {
            throw new ElementDoesNotExistException(obj);
        }
        
        FileUtilRepository.saveFile(elements, this.filename);
    }

    @Override
    public void update(T newObj) throws ElementDoesNotExistException {
        if (this.elements.contains(newObj)) {
            int index = this.elements.indexOf(newObj);
            this.elements.set(index, newObj);
        } else {
            throw new ElementDoesNotExistException(newObj);
        }
        
        FileUtilRepository.saveFile(elements, this.filename);
    }
    
}
