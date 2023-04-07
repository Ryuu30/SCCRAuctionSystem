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
public class Fashion extends Item{
    private String size;
    
    public Fashion(){}

    public Fashion(String name, String size, double weight, double oriPrice, double startBidPrice) {
        super(name, weight, oriPrice, startBidPrice);
        this.size = size;
        this.category = "Fashion";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        // Size   Weight(kg)    Original Price(RM)    Starting Bid Price(RM)    Status 
        return super.toString() + String.format("%13s%20.2f%18.2f%24.2f%27s\n", size, weight, oriPrice, startBidPrice, status);
    }
    
}
