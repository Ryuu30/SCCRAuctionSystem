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
public class CircularLinkedList <T> implements ListInterface<T> {
    
    private Node lastNode;
    private int numberOfEntries;
    
    public CircularLinkedList(){
        clear();
    }
    
    //more like add at the back
    public void addEnd(T newEntry) {
        
        Node newNode = new Node(newEntry); // create a new node with data only, next = null
       
        //if add to an empty list
        if(isEmpty()){
            addToEmpty(newNode);
        }
        //if the link is not empty
        else{
            newNode.next = lastNode.next; //newNode points to first node
            lastNode.next = newNode;      // lastNode point to NewNode
            lastNode = newNode; 
            numberOfEntries++;
                                 
//            newNode.next = lastNode.next;  //newNode points to first Node
//            lastNode.next = newNode;       //current last node points to newNode 
//            lastNode = newNode;            //lastNode reference points to newNode. or lastNode = lastNode.next
//            numberOfEntries++; 
        }
    }
    
    public void addStart(T newEntry) {
        Node newNode = new Node(newEntry);

        //if add to an empty list
        if(isEmpty()){
            addToEmpty(newNode);
        }
        else{
            newNode.next = lastNode.next;
            lastNode.next = newNode;
            numberOfEntries ++; 
        } 
    }

   public boolean addMiddle(int newPosition, T newEntry) {
        Node newNode= new Node(newEntry);
        boolean flag = true;
        
        if (newPosition >= 1 && newPosition <= numberOfEntries +1){
            if(newPosition ==1 && isEmpty()){
                addToEmpty(newNode);
            }
            else{
                Node nodeBefore = lastNode.next;  //firstNode
                
                for(int i=1; i< newPosition-1;i++){
                    nodeBefore = nodeBefore.next;
                }
                
                newNode.next = nodeBefore.next;  //new node point to the node at the newPosition
                nodeBefore.next = newNode;      // node before points at new node, complete the link
                numberOfEntries++;
            }
        }
        else{          //invalid number
            flag =false;
        }
        return flag;
    }
    
                               //item
    public boolean contains(T anEntry){
        boolean isFound = false;
        Node currentNode = lastNode.next; //firstNode
        
                            //data = entry, use the object.equals  
        if (anEntry.equals(currentNode.data)){  // check first Node
            isFound =true;
        }
        else{
            currentNode = currentNode.next;
            while (!(isFound ||currentNode.equals(lastNode.next))){ //as long as there is a next node to tranverse and didn't reach first Node.
                if(currentNode.data.equals(anEntry)){
                    isFound = true;
                }else{
                    currentNode = currentNode.next;
                }  
            }
        }      
        return isFound;
    }
    
    
                    //T givenEntry = T data 
    public T remove (T givenEntry) {
        
        T result = null;
        
        if(isEmpty()){
            return result;
        }
        
        
        else if(lastNode.next.data.equals(givenEntry)){ //check first node
            result = lastNode.next.data;
            lastNode.next = lastNode.next.next; // first node points to second node
            numberOfEntries--;
            
        }
        else {
            Node nodeBefore = lastNode.next; //first node
            
            //while haven't reach first node and result = null
                    //lastNode.next.next
            while (!(nodeBefore.next.equals(lastNode.next)) && result == null){
                    if(nodeBefore.next.data.equals(givenEntry)){ //if there is a match
                        result = nodeBefore.next.data;           //extract the data
                        nodeBefore.next = nodeBefore.next.next; //skip the node
                    if (result.equals(lastNode.data))
                        lastNode = nodeBefore; 
                        numberOfEntries--;
                    }else{
                        nodeBefore = nodeBefore.next;
                    }    
            }
        }
        
        return result;
    }
    
//    public boolean replace(int givenEntry, T anEntry){
//        boolean flag;
//        
//    }
    
    public T getEntry(int givenPosition) {
        T result=null;
        
        if (givenPosition >=1 && givenPosition <= numberOfEntries){
            Node currentNode = lastNode.next;  //first node
            
            for(int i=1; i< givenPosition; i++){
                currentNode= currentNode.next;
            }
            
            result = currentNode.data;
        }
        
        return result;
    }

        
    
    public void clear() {
        lastNode = null;
        numberOfEntries =0;
    }

    
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    
    public boolean isEmpty() {
        return lastNode ==null;
    }
    
    private void addToEmpty(Node newNode){
            newNode.next = newNode; //points to itself
            lastNode = newNode;
//            lastNode = newNode;
//            lastNode.next = lastNode;  //points to itself
            numberOfEntries ++;
    }
    
    
    
    private class Node{
        private T data;
        private Node next;
        
        //to carry a data or a new node
        public Node(T data){
            this.data = data;
            this.next =null;
        }
        
        //for add in middle later
        public Node (T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}

