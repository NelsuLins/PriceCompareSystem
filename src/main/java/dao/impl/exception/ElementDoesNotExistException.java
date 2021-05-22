package main.java.dao.impl.exception;

public class ElementDoesNotExistException extends Exception {
	
	private Object element;
    
    public ElementDoesNotExistException(Object obj) {
        super("Object does not exist in the repository");
        this.element = obj;
    }
    
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
    
}
