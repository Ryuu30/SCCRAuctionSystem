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
public class BidResult {
    
    private String CustomerName;
    private double BidPrice;   //bidding price
    private int no = 0;
    
   
    public BidResult() {}
    
    public BidResult(String CustomerName,double BidPrice) {

        this.CustomerName = CustomerName;
        this.BidPrice = BidPrice; 
        this.no = 1;
        
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public double getBidPrice() {
        return BidPrice;
    }

    public void setBidPrice(double BidPrice) {
        this.BidPrice = BidPrice;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    
    
    @Override
    public String toString() {
        //    Name      Bid Price(RM)    
        return String.format("%8s %20s  %20.2f\n",no, CustomerName,BidPrice);
    }
    
}


