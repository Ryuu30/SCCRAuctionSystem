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
public interface LinkInterface<T> {
    public boolean add(T newEntry);
    public boolean add(int newPosition, T newEntry);
    public T remove(int givenPosition);
    public T remove();
    public boolean replace(int givenPosition, T newEntry);
    public T getEntry(int givenPosition);
    public boolean contains(T anEntry);
    public boolean checkNumberOfEntries(int givenPosition);
    public int getNumberOfEntries();
    public boolean isFull();
    public boolean isEmpty();
    public void clear();
}
