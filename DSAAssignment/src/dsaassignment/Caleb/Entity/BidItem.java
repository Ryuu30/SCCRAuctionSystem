/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.Caleb.Entity;

/**
 *
 * @author Caleb Chu Ken Lun
 */
public class BidItem {
    
    private String itemID;
    private String name;
    private double minimumBidPrice;   //Starting bidding price
    

    public BidItem() {}
    
    public BidItem(String itemID, String name, double minimumBidPrice) {

        this.itemID = itemID;
        this.name = name;
        this.minimumBidPrice = minimumBidPrice;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinimumBidPrice() {
        return minimumBidPrice;
    }

    public void setMinimumBidPrice(double minimumBidPrice) {
        this.minimumBidPrice = minimumBidPrice;
    }

    @Override
    public String toString() {
        // Item ID     Name     Minimum Bid Price(RM)    
        return String.format(" %8s    %-40s    %25.2f\n", itemID, name, minimumBidPrice);
    }
    
}


