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
public abstract class User {
    //private String userID;
    protected String name;
    protected String contactNum;
    protected String email;
    //private Address address;
    protected String password;
    
    protected User(){
    }
    
    protected User(String name, String password,String contactNum, String email){
        this.name = name;
        this.contactNum = contactNum;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }else if (getClass() != obj.getClass()){ // if class different
            return false;
        }else if (!this.getEmail().equals(((Customer)obj).getEmail())){ // if email different
            return false;
        }
            return true;
    }
    
    public String toString(){
        return "\nName: " + name + "\nContact number: " + contactNum + "\nEmail address: " + email;
    }
    
}
