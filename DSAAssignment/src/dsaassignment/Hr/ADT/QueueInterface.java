/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.Hr.ADT;

import java.util.Iterator;

/**
 *
 * @author Tang Hang Rong
 */
public interface QueueInterface<T> {

    public Iterator<T> getIterator();
    public void enQueue(T element);
    public T deQueue();
    public T getFront();
    public boolean isEmpty();
    public boolean isFull();
    public void clear();
}
