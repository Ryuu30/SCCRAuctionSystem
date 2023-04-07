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
public class Address {
    private String street;
    private String area;
    private String postCode;
    private String city;
    private String state;
    
    public Address(){
        
    }
    public Address(String street,String area,String postCode,String city,String state){
        this.area= area;
        this.city = city;
        this.postCode= postCode;
        this.street = street;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String toString() {
        return street + ", " + area + ", " + postCode + ", " + city + ", " + state;
    }
    
    
}
