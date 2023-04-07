/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.Hr.Entity;

import dsaassignment.Caleb.Entity.BidReport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Tang Hang Rong
 */
public class Delivery {
    private int deliveryID;
    private BidReport bid;
    private String status;
    private LocalDate date;
    private static int count = 1001;
    
    public Delivery() {}

    public Delivery(BidReport bid) {
        this.deliveryID = count++;
        this.bid = bid;
        this.status = "Packing";
        this.date = LocalDate.now();
        
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public BidReport getBid() {
        return bid;
    }

    public void setBid(BidReport bid) {
        this.bid = bid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            if (this.bid.equals(obj)) {
                return true;
            }
            return false;
        }
        
        return true;
    }
    
    

    @Override
    public String toString() {
        // Delivery ID    Date    Customer     Item Name    Weight (kg)    Address   Status  
        return String.format("%8s%18s%7s%-26s%-32s%14.2f%12s%-63s%-20s", deliveryID, date.format(DateTimeFormatter.ofPattern("dd-MM-uuuu")), "", bid.getCustomer().getName(), bid.getItem().getName(), bid.getItem().getWeight(), "", bid.getCustomer().getAddress(), status);
    }
    
}
   
