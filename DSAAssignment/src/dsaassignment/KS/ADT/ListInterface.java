package dsaassignment.KS.ADT;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lee Khar Seng
 */
public interface ListInterface<T> {
    
    public void addEnd(T newEntry);
    
    public void addStart(T newEntry);
    
    public boolean addMiddle(int newPosition, T newEntry);
    
    public boolean contains(T anEntry);
            
    public T remove (T givenEntry);
    
    public T getEntry(int givenPosition);
    
    public void clear();
    
    int getNumberOfEntries();
    
    boolean isEmpty();

}
