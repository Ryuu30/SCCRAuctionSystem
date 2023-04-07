/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.Caleb.ADT;

/**
 *
 * @author Caleb Chu Ken Lun
 */
public interface StackInterface<T> {
    public void addHighest(T newEntry);
    public T highest();
    public T remove();
    public boolean isEmpty();
    public void clear();
    public T secondnode() ;
    public T thirdnode();
    public boolean isFull();
    public int numberofStack();
    
}
