/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.Courtney.ADT;

/**
 *
 * @author Courtney Chew Cheah Ni
 */
public interface ListInterface<T> {
    //Add the newEntry to the end of the list
    public void add(T newEntry);
    //Add the newEntry to the any position in the list
    public boolean add(int newPosition, T newEntry);
    //Add the newEntry to the front of the list
    public void addFront(T newEntry);
    //Remove the entry from the given position
    public T remove(int givenPosition);
    //Replace the entry at the given position with the new entry
    public boolean replace(int givenPosition, T newEntry);
    //Move the entry at the current position to the new position
    public boolean shift(int currentPosition, int newPosition);
    //Retrieve the entry at the given position
    public T getEntry(int givenPosition);
    //Retrieve the entry that has the given element
    public T getEntry(String anElement);
    //Check if the list contains the given entry
    public boolean contains(T anEntry);
    //Clear the list
    public void clear();
    //Return the number of entries in the list
    public int getNumberOfEntries();
    //Check if the list is empty
    public boolean isEmpty();
    //Check if the list is full
    public boolean isFull();
}
