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
public class DoublyLinkedList<T> implements ListInterface<T> {

    private Node firstNode;         //First node
    private Node lastNode;          //Last node
    private int numberOfEntries;    //Number of entries in list

    public DoublyLinkedList() {
        clear();    //Clear the list
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);  //Save data into node

        if (isEmpty()) {
            firstNode = newNode;            //Assign node to firstNode
            lastNode = newNode;             //Assign node to lastNode
        } else {
            lastNode.next = newNode;        //Point current lastNode to newNode
            newNode.prev = lastNode;        //Point current lastNode as the previous node of newNode
            lastNode = newNode;             //Assign newNode as the lastNode
        }
        numberOfEntries++;                  //Increase the number of entries + 1
    }

    @Override
    public boolean add(int newPosition, T newEntry) {

        if (newPosition >= 1 && newPosition <= numberOfEntries + 1) { //To ensure newPosition is between first position and the position after lastNode
            Node newNode = new Node(newEntry);  //Save data into node

            if (newPosition == 1) {
                addFront(newEntry);             //Add to the front of the list
            } else if (newPosition == (numberOfEntries + 1)) {
                add(newEntry);                  //Add to end of list
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < newPosition - 1; i++) {
                    nodeBefore = nodeBefore.next;
                }
                
                newNode.next = nodeBefore.next; //Point newNode to the node after nodeBefore
                nodeBefore.next = newNode;      //Point nodeBefore to the newNode
                newNode.prev = nodeBefore;      //Point nodeBefore as the previous node of newNode
                
                numberOfEntries++;              //Increase the number of entries + 1
            }

        } else {
            return false;                       //Return false if invalid position
        }

        return true;
    }

    @Override
    public void addFront(T newEntry) {
        Node newNode = new Node(newEntry);  //Save data into newNode

        if (isEmpty()) {
            firstNode = newNode;            //Assign node to firstNode
            lastNode = newNode;             //Assign node to lastNode
        } else {
            firstNode.prev = newNode;       //Point newNode as the previous node of the current firstNode
            newNode.next = firstNode;       //Point newNode to firstNode
            firstNode = newNode;            //Assign newNode as firstNode
        }

        numberOfEntries++;                  //Increase the number of entries + 1

    }

    @Override
    public T remove(int givenPosition) {
        T removed = null;                                    //To store value to be removed

        if (!isEmpty()) {
            if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
                if (givenPosition == 1) {
                    if (numberOfEntries == 1) {
                        clear();
                    } else {
                        removed = firstNode.data;                   //Assign data of first node to removed
                        firstNode = firstNode.next;                 //Assign firstNode to the node after firstNode
                        firstNode.prev = null;                      //Assign null as previous node of firstNode
                    }
                } else if (givenPosition == numberOfEntries) {
                    removed = lastNode.data;                    //Assign data of first node to removed
                    lastNode = lastNode.prev;                   //Assign firstNode to the node after firstNode
                    lastNode.next = null;                       //Assign null as previous node of firstNode
                } else {
                    Node nodeBefore = firstNode;

                    for (int i = 1; i < givenPosition - 1; i++) {
                        nodeBefore = nodeBefore.next;
                    }

                    removed = nodeBefore.next.data;             //Assign data of the data of the node after nodeBefore to removed
                    nodeBefore.next = nodeBefore.next.next;     //Point nodeBefore to the node 2 times after it
                    nodeBefore.next.prev = nodeBefore;          //Point nodeBefore as the previous node of the node after nodeBefore
                }
            }
            numberOfEntries--;                              //Deduct 1 from number of entries;
        }

        return removed;                                     //Return the removed value / null
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {

        if (!isEmpty()) {
            if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
                if (givenPosition == 1) {
                    firstNode.data = newEntry;                //Replace data of firstNode with newEntry
                } else {
                    Node currentNode = firstNode;

                    for (int i = 1; i < givenPosition; i++) { //Go to node in 2nd position
                        currentNode = currentNode.next;
                    }

                    currentNode.data = newEntry;         //Replace data in currentNode with newEntry
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean shift(int currentPosition, int newPosition) {

        if (!isEmpty()) {
            Node nodeToShift = new Node(remove(currentPosition));       //Remove the node from currentPosition
            add(newPosition, nodeToShift.data);                         //Add the node to newPosition

            return true;
        }

        return false;
    }

    @Override
    public T getEntry(int givenPosition) {
        T returnEntry = null;

        if (!isEmpty()) {
            if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
                if (givenPosition == 1) {
                    returnEntry = firstNode.data;           //Assign data of firstNode to returnEntry
                } else {
                    Node currentNode = firstNode;

                    for (int i = 1; i < givenPosition; i++) { //Go to node in 2nd position
                        currentNode = currentNode.next;
                    }

                    returnEntry = currentNode.data;         //Replace data in currentNode with newEntry
                }
            }
        }

        return returnEntry;
    }

    @Override
    public T getEntry(String anElement) {
        T returnEntry = null;
        Node currentNode = firstNode;
        boolean found = false;

        if (!isEmpty()) {
            for (int i = 1; i <= numberOfEntries; i++) {
                if (currentNode.data.equals(anElement)) {   //If put anElement in front will call equal() of String instead of Item's
                    returnEntry = currentNode.data;         //Assign the data of currentNode to returnEntry
                    found = true;
                    break;
                }
                currentNode = currentNode.next;
            }
        }

        return returnEntry;
    }

    @Override
    public boolean contains(T anEntry) {
        Node currentNode = firstNode;

        if (!isEmpty()) {

            for (int i = 1; i <= numberOfEntries; i++) {
                if (anEntry.equals(currentNode.data)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    @Override
    public final void clear() {     //Clear the linked list
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        String outStr = "";
        int num = 1;    //Item No.
        Node currentNode = firstNode;

        if (currentNode != null) {
            while (currentNode != null) {
                outStr += String.format(" %3d", num);
                outStr += (currentNode.data + "\n");    //Store the data together to return
                currentNode = currentNode.next;
                num++;
            }
        } else {
            return "List is empty.";        //If list is empty
        }

        return outStr;
    }

    private class Node {

        private T data;         //Data of the node
        private Node next;      //Next node of current node
        private Node prev;      //Previous node of current node

        private Node(T data) {
            this.data = data;
            this.next = null;     //Assign to empty value
            this.prev = null;     //Assign to empty value
        }

        private Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.prev = previous;
        }
    }

}
