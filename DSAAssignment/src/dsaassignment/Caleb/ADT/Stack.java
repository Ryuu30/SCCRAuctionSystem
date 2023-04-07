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
public class Stack<T> implements StackInterface<T> {
    private Node topNode;
    private Node secondNode;
    private Node tenthNode;
    private int count = -1;

    public Stack() {
        topNode = null;
    }

    @Override
    public void addHighest(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
        count++;
    }

    @Override
    public T highest() {
        T top = null;

        if (!isEmpty()) {
            top = topNode.data;
        }
        return top;
    }

    @Override
    public T secondnode() {
        T top = highest();

        //check if stack null
        if (topNode != null) {
            secondNode = topNode.next;
            top = secondNode.data;
        }
        return top;
    }

    @Override
    public T thirdnode() {
        T third = null;

        //check if stack null
        if (topNode != null) {
            secondNode = topNode.next.next;
            third = secondNode.data;
        }
        return third;
    }

    @Override
    public T remove() {
        T top = highest();

        //check if stack null
        if (topNode != null) {
            topNode = topNode.next;
            count--;
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }
    
    @Override
    public int numberofStack() {
        return count;
    }

    @Override
    public boolean isFull() {
        if (count == 10) {
            return tenthNode != null;
        }
        else
            return tenthNode == null;
    }
    
    @Override
    public void clear(){
        topNode = null;
    }
    
    private class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      this.next = null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

    
}
