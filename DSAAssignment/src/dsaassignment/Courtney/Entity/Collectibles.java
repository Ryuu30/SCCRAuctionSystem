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
public class Collectibles extends Item{

    private String dimension;

    public Collectibles() {}

    public Collectibles(String name, String dimension, double weight, double oriPrice, double startBidPrice) {
        super(name, weight, oriPrice, startBidPrice);
        this.dimension = dimension;
        this.category = "Collectibles";
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        // Dimension    Weight(kg)    Original Price(RM)    Starting Bid Price(RM)    Status 
        return super.toString() + String.format("%20s%13.2f%18.2f%24.2f%27s\n", dimension, weight, oriPrice, startBidPrice, status);
    }
}
