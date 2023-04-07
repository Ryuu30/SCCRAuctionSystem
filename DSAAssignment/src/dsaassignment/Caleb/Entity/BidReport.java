/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.Caleb.Entity;

import dsaassignment.Courtney.Entity.Item;
import dsaassignment.KS.User.Customer;
import java.util.Objects;

/**
 *
 * @author Caleb Chu Ken Lun
 */
public class BidReport {
    private Customer customer;
    private Item item;
    private String status;
    private double bidPrice;   //Starting bidding price
    private int noOfItems = 0;
    private int regNo = 1000;
    private static int countReg = 1001;
    private static int count = 1;

    
    
    public BidReport() {}
    
    public BidReport(Customer customer, Item item, double bidPrice, String status) {
        this.customer = customer;
        this.item = item;
        this.bidPrice = bidPrice;
        this.status = status;
        this.regNo = countReg++;
        this.noOfItems = count++;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public static int getCountReg() {
        return countReg;
    }

    public static void setCountReg(int countReg) {
        BidReport.countReg = countReg;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        BidReport.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            if (obj.equals(this.getStatus())) {
                return true;
            } else {
                return false;
            }
        }
        
        return true;
    }

    
    
    @Override
    public String toString() {
        // Item ID     Name     Minimum Bid Price(RM)    
        return String.format("%15s %15s %40s %15.2f %15s %n", regNo, customer.getName(),  item.getName(), bidPrice,  status);
    }
    
}




