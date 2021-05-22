package main.java.dao.impl.exception;

public class ElementAlreadyExistsException extends Exception {
	
	private Object element;
    
    public ElementAlreadyExistsException(Object obj) {
        super("Object is already registered in the repository and cannot be"
            + "added again");
        this.element = obj;
    }
    
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
    
}
