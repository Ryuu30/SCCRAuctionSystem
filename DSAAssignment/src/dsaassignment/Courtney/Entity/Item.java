/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.Courtney.Entity;

/**
 *
 * @author Courtney Chew Cheah Ni
 */
public abstract class Item {
    protected String itemID;
    protected String category;
    protected String name;
    protected double weight;
    protected double startBidPrice;   //Starting bidding price
    protected double oriPrice;        //Original price of item
    protected String status;          //Status of bid - Available, On Bid, Sold
    protected static int noOfItems = 0;
    
    protected Item() {}
    
    protected Item(String name, double weight, double oriPrice, double startBidPrice) {
        noOfItems++;
        
        if (noOfItems < 10) {
            this.itemID = "P000" + noOfItems;
        } else if (noOfItems < 100 && noOfItems >= 10) {
            this.itemID = "P00" + noOfItems;
        } else if (noOfItems < 1000 && noOfItems >= 100) {
            this.itemID = "P0" + noOfItems;
        }
        
        this.name = name;
        this.weight = weight;
        this.startBidPrice = startBidPrice;
        this.oriPrice = oriPrice;
        this.status = "Not Available";
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getStartBidPrice() {
        return startBidPrice;
    }

    public void setStartBidPrice(double startBidPrice) {
        this.startBidPrice = startBidPrice;
    }

    public double getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(double oriPrice) {
        this.oriPrice = oriPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int getNoOfItems() {
        return noOfItems;
    }

    @Override
    public boolean equals(Object obj) {        
        if (obj == null) {                                  //Check if object is null
            return false;
        } else if (this.getClass() != obj.getClass()) {          //Check if object class is the same
            if (obj.equals(this.getItemID())) {             //Check if the object equals itemID
                return true;
            } else {
                return false;
            }
        } else if (!this.getItemID().equals(((Item)obj).getItemID())) { //Check if the itemIDs are the same
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // Item ID     Category   Name
        return String.format(" %8s     %-13s    %-40s    ", itemID, category, name);
    }
    
}

// Item ID     Name    Weight(kg)    Original Price(RM)    Starting Bid Price(RM)    Status 
//        return String.format(" %8s    %-40s    %13.2f%18.2f%24.2f%27s\n", itemID, name, weight, oriPrice, startBidPrice, status);