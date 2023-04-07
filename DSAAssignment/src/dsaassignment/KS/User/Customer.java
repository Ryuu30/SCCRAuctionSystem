package dsaassignment.KS.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lee Khar Seng
 */
public class Customer extends User{
    private String custID;
    private Address address;
    
    private static int noOfCust=0;
    
    public Customer(){
        
    }
    
    public Customer(String name, String password, String contactNum, String email, Address address){
        super(name, password, contactNum, email);
        noOfCust++;
        this.custID = "C00" + noOfCust; 
        this.address = address;

         
    }
    
    public String getCustID(){
        return custID;
    }
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public static int getNoOfCust(){
        return noOfCust;
    }
    
    
     
    
    public String toString(){
        return "Customer ID: " + custID + super.toString() +
                "\nDelivery address: " + address.toString();
    }
    
}
