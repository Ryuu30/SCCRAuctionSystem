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
public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] array;
    private static final int FRONT = 0;
    private int rear;
    private static final int CAPACITY = 20;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        rear = -1;
    }

    @Override
    public T deQueue() {
        T element = null;
        if (!isEmpty()) {
            element = array[FRONT];
            for (int index = 0; index < rear; index++) {
                array[index] = array[index+1];
            }
            rear--;
        }
        return element;
    }

    @Override
    public void enQueue(T element) {
        if (!isFull()) {
            rear++;
            this.array[rear] = element;
        }
    }

    @Override
    public T getFront() {
        T firstElement = null;
        if (!isEmpty()) {
            firstElement = array[FRONT];
        }
        return firstElement;
    }

    @Override
    public void clear() {
        if (!isFull()) { //check if array is empty
            for (int index = FRONT; index <= rear; index++) {
                array[index] = null;
            }
            rear = -1;
        }
    }

    @Override
    public boolean isFull() {
        return rear == CAPACITY - 1;
    }

    @Override
    public boolean isEmpty() {
        return rear == -1;
    }

    public Iterator<T> getIterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<T> {
        private int next;
        private ArrayQueueIterator() {
            next = 0;
        }

        @Override
        public boolean hasNext() {
            return next <= rear;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T nextEntry = array[next];
                next++; //go to next
                return nextEntry;
            } else {
                return null;
            }
        }
    }

}
