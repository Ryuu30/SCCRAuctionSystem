/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.KS.User;

/**
 *
 * @author Lee Khar Seng
 */
public class Staff extends User{
    private String staffID;
    
    private static int noOfStaff=0;
    
    public Staff(){
        
    }
    
    public Staff(String name, String password, String contactNum, String email){
        super(name, password, contactNum, email);
        noOfStaff++;
        this.staffID= "S0" + noOfStaff;
    }
    
    public String getStaffID(){
        return staffID;   
    }
    
    public static int getNoOfStaff(){
        return noOfStaff;
    }
    
    public String toString(){
        return "Staff ID: " + staffID + super.toString();
    }
    
}
