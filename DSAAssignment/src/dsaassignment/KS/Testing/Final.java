/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.KS.Testing;

/**
 *
 * @author Lee Khar Seng
 */
import dsaassignment.Caleb.ADT.LinkInterface;
import dsaassignment.Caleb.ADT.LinkedList;
import dsaassignment.Caleb.ADT.Stack;
import dsaassignment.Caleb.ADT.StackInterface;
import dsaassignment.Caleb.Client.Bid;
import dsaassignment.Caleb.Entity.BidItem;
import dsaassignment.Caleb.Entity.BidReport;
import dsaassignment.Caleb.Entity.BidResult;
import dsaassignment.Courtney.ADT.DoublyLinkedList;
import dsaassignment.Courtney.Entity.Item;
import dsaassignment.Courtney.Client.ItemManagement;
import dsaassignment.Courtney.Entity.Collectibles;
import dsaassignment.Courtney.Entity.Electronics;
import dsaassignment.Courtney.Entity.Fashion;
import dsaassignment.Hr.ADT.ArrayQueue;
import dsaassignment.Hr.ADT.QueueInterface;
import dsaassignment.Hr.Client.TestDelivery;
import dsaassignment.Hr.Entity.Delivery;
import dsaassignment.KS.User.Address;
import dsaassignment.KS.User.Staff;
import dsaassignment.KS.User.Customer;
import dsaassignment.KS.ADT.CircularLinkedList;
import dsaassignment.KS.ADT.ListInterface;


import java.util.Scanner;

public class Final {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
//        int customerIndex=0; //declare in main program, erase then when move to main program
//        int option =0;
//        boolean valid = false;

        ListInterface<Customer> customerList = new CircularLinkedList(); //initiate a linked list. ADD TO MAIN PROGRAM
        ListInterface<Staff> staffList = new CircularLinkedList();

        staffList.addEnd(new Staff("Admin", "Admin7777", "0000000000", "staff@Company.com")); //create an admin acc

        staffList.addEnd(new Staff("GIGISA", "GG889897", "012132108", "doggy@gmail.com"));

        customerList.addEnd(new Customer("Fiona", "A87577", "017982008", "song@yahoo.com",
                new Address("12", "Taman Seri Bangsa", "27600", "Raub", "Pahang")));

        customerList.addEnd(new Customer("Sofia", "aileaile", "0121216508", "insurance@yahoo.com",
                new Address("99", "Taman Negara", "69699", "Ampang", "Kuala Lumpur")));

        customerList.addEnd(new Customer("Shoigu", "chubais", "17979799", "dada@gmail.com",
                new Address("996", "Taman Aman", "69520", "Setapak", "Kuala Lumpur")));
        
        // List of items
        dsaassignment.Courtney.ADT.ListInterface<Item> itemList = new DoublyLinkedList<Item>();
        //Add items
        itemList.add(new Collectibles("BNHA Aizawa Shouta Figurine", "10cm x 10cm x 18cm", 0.4, 70.00, 50.00));
        itemList.add(new Electronics("XiaoMi Automated Vacumm Cleaner", "30cm x 30cm x 10cm", 5.2, 500.00, 350.00));
        itemList.add(new Electronics("Lenovo Smart TV", "100cm x 5cm x 70cm", 20.1, 1250.00, 850.00));
        itemList.add(new Fashion("Gucci Polo Shirt", "L", 0.4, 1550.00, 1050.00));
        itemList.add(new Fashion("Adidas Mesh Shirt", "Free", 0.3, 150.00, 100.00));

        LinkInterface<BidReport> allRecord = new LinkedList<BidReport>();
        LinkInterface<BidItem> item = new LinkedList<BidItem>();
        StackInterface<BidResult> amt1 = new Stack<BidResult>();
        StackInterface<BidResult> amt2 = new Stack<BidResult>();
        StackInterface<BidResult> amt3 = new Stack<BidResult>();
        QueueInterface<Delivery> delivery = new ArrayQueue<Delivery>();

        firstPage(customerList, staffList, itemList, allRecord, item, amt1, amt2, amt3, delivery);
    }

    public static void firstPage(ListInterface<Customer> customerList, ListInterface<Staff> staffList, dsaassignment.Courtney.ADT.ListInterface<Item> itemList, LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item, StackInterface<BidResult> amt1, StackInterface<BidResult> amt2, StackInterface<BidResult> amt3, QueueInterface<Delivery> delivery) {
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        System.out.println("Welcome to SCCR Auction System.");
        do {
            System.out.println("\n1. Login");
            System.out.println("2. Register account");
            System.out.println("Enter option (0 to exit): ");
            opt = sc.nextInt();   //Or opt = Integer.parseInt(sc.nextLine());

            if (opt == 1) {
                login(customerList, staffList, itemList, allRecord, item, amt1, amt2, amt3, delivery);
            } else if (opt == 2) {
                registerAccount(customerList, staffList);
     
            } else if (opt == 0) {
                System.out.println("Bye");
            } else {
                System.out.println("Invalid Option. Please try again.");
            }

        } while (opt != 0);
    }

    public static void registerAccount(ListInterface<Customer> customerList, ListInterface<Staff> staffList) {
        String name;
        String password;
        String passwordAgain;
        String contactNum;
        String email;
        String street;
        String area;
        String postCode;
        String city;
        String state;
        boolean valid = false;
        String confirm;
        boolean flag = true;
        boolean custFlag = true;//check customer emails
        boolean staffFlag = true; //check Staff emails

        do {
            System.out.print("\nAccount Registration\nEnter name (enter 0 to exit): ");
            name = input.nextLine();
            if (!name.equals("0")) {
                do {
                    System.out.print("Enter password: ");
                    password = input.nextLine();
                    System.out.print("Re-enter the password: ");
                    passwordAgain = input.nextLine();
                    if (passwordAgain.equals(password)) {
                        valid = true; //same password
                    } else {
                        System.out.println("\nError, inconsistent password. Please enter again.\n");
                        valid = false;
                    }
                } while (valid == false);

                System.out.print("Enter phone number: ");
                contactNum = input.nextLine();

                System.out.print("Enter your email address: ");
                email = input.nextLine();

                System.out.println("\nDelivery Address Details");
                System.out.print("Enter street: ");
                street = input.nextLine();
                System.out.print("Enter area: ");
                area = input.nextLine();
                System.out.print("Enter post code: ");
                postCode = input.nextLine();
                System.out.print("Enter city: ");
                city = input.nextLine();
                System.out.print("Enter state: ");
                state = input.nextLine();

                System.out.println("Do you confirm to create this account? (YES/NO): ");
                confirm = input.nextLine();
                confirm = confirm.toUpperCase();

                if (confirm.equals("YES")) {
                    Customer newCustomer = new Customer(name, password, contactNum, email, new Address(street, area, postCode, city, state));
                    if (!customerList.contains(newCustomer)) { // if the customer does not exist yet
                        //check for staff email
                        staffFlag = true;
                        for (int i = 1; i <= staffList.getNumberOfEntries(); i++) {
                            if (email.equals(staffList.getEntry(i).getEmail())) {//if there is a staff email matched
                                staffFlag = false;
                                
                            }
                        }

                        //if email is not found in staff
                        if (staffFlag) {
                            customerList.addEnd(newCustomer);
                            System.out.println("\nYour accouunt has been registered sucessfully!\n");
                            System.out.println(customerList.getEntry(customerList.getNumberOfEntries()).toString());
                            flag = true;//exit the loop
                        } else {
                            System.out.println("\nError, the account already exist!\n");
                            flag = false;//start the loop again
                        }
                    } else {
                        System.out.println("\nError, the account already exist!\n");
                        flag = false;
                    }
                } else {//if user choose no
                    System.out.println("\nNo account has been registered\n");
                    flag = true; // exit the loop
                }

            } else {
                flag = true; //exit the loop
            }
        } while (flag == false);

    }

    public static void customerMenu(int customerIndex, ListInterface<Customer> customerList, ListInterface<Staff> staffList, dsaassignment.Courtney.ADT.ListInterface<Item> itemList, LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item, StackInterface<BidResult> amt1, StackInterface<BidResult> amt2, StackInterface<BidResult> amt3) {

        int option = 0;
        boolean valid = false;

        do {
            System.out.println("\nWelcome to Main menu.");

            System.out.println("1. My account");
            System.out.println("2. Bidding");
            System.out.println("0. Log Out");

            //Error handling
            do {
                try {
                    System.out.print("\nPlease select the option: ");
                    option = input.nextInt();
                    input.nextLine();
                    if (option < 0 || option > 2) {
                        System.out.println("Option out of range. Please enter number from 0 to 2 only");
                        valid = false;
                    } else {
                        valid = true;//end the loop
                    }
                    //if not integer
                } catch (Exception e) {
                    System.out.print("Please enter integer only.\n");
                    input.next(); //clear error input
                    valid = false;
                }
            } while (valid == false);

            switch (option) {
                case 0:
                    option = 0; // exit thie module loop
                    break;
                case 1:
                    //check existence of account
                    boolean existence;
                    existence = customerModule(customerIndex, customerList, staffList);

                    //if customer already delete his account, exit to login page
                    if (!existence) {
                        option = 0;
                    }
                    break;
                case 2:
                    Bid.main(itemList, customerList, customerIndex, allRecord, item, amt1, amt2, amt3);
                    break;
            }

        } while (option != 0);
    }

    public static boolean customerModule(int customerIndex, ListInterface<Customer> customerList, ListInterface<Staff> staffList) {
        boolean existence = true;
        int option = 0;
        boolean valid = false;
        do {
            System.out.println("\nWelcome to Customer Module.");

            System.out.println("1. View my account");
            System.out.println("2. Update account");
            System.out.println("3. Delete account");
            System.out.println("0. Exit");

            //Error handling
            do {
                try {
                    System.out.print("\nPlease select the option: ");
                    option = input.nextInt();
                    input.nextLine();
                    if (option < 0 || option > 3) {
                        System.out.println("Option out of range. Please enter number from 0 to 3 only");
                        valid = false;
                    } else {
                        valid = true;//end the loop
                    }
                    //if not integer
                } catch (Exception e) {
                    System.out.print("Please enter integer only.\n");
                    input.next(); //clear error input
                    valid = false;
                }
            } while (valid == false);

            switch (option) {
//               case 4:
//                   registerAccount(customerList);
//                   break;
                case 0:
                    option = 0; // exit thie module loop
                    break;
                case 1:
                    viewAccount(customerIndex, customerList);
                    break;
                case 2:
                    updateAccount(customerIndex, customerList, staffList);
                    break;
                case 3:
                    existence = deleteAccount(customerIndex, customerList);
                    //if user deleted this account
                    if (!existence) {
                        option = 0; //exit loop
                    }
                    break;
            }

        } while (option != 0);

        return existence;//existense == false means account deleted
    }

    public static void staffMenu(int customerIndex, ListInterface<Staff> staffList, dsaassignment.Courtney.ADT.ListInterface<Item> itemList, LinkInterface<BidReport> allRecord, QueueInterface<Delivery> delivery) {
        int option = 0;
        boolean valid = false;

        do {
            System.out.println("\nWelcome to Main menu.");

            System.out.println("1. Item Management");
            System.out.println("2. Delivery Management");
            System.out.println("0. Log Out");

            //Error handling
            do {
                try {
                    System.out.print("\nPlease select the option: ");
                    option = input.nextInt();
                    input.nextLine();
                    if (option < 0 || option > 2) {
                        System.out.println("Option out of range. Please enter number from 0 to 2 only");
                        valid = false;
                    } else {
                        valid = true;//end the loop
                    }
                    //if not integer
                } catch (Exception e) {
                    System.out.print("Please enter integer only.\n");
                    input.next(); //clear error input
                    valid = false;
                }
            } while (valid == false);

            switch (option) {
                case 0:
                    option = 0; // exit thie module loop
                    break;
                case 1:
                    ItemManagement.main(itemList);
                    break;
                case 2:
                    TestDelivery.main(allRecord, delivery);
                    break;
            }

        } while (option != 0);
    }

    public static void login(ListInterface<Customer> customerList, ListInterface<Staff> staffList, dsaassignment.Courtney.ADT.ListInterface<Item> itemList, LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item, StackInterface<BidResult> amt1, StackInterface<BidResult> amt2, StackInterface<BidResult> amt3, QueueInterface<Delivery> delivery) {
        String inputEmail;
        String inputPassword;
        int customerIndex = 0;
        int staffIndex = 0;
        boolean flag = false;

        do {
            System.out.print("\nUser login\nEnter the email (Enter 0 to exit): ");
            inputEmail = input.nextLine();

            //if user enter email
            if (!inputEmail.equals("0")) {
                System.out.print("Enter the password: ");
                inputPassword = input.nextLine();

                staffIndex = loginStaff(staffList, inputEmail, inputPassword);//search thru staff database

                //if staffIndex =0, staff not found  
                if (staffIndex == 0) {
                    customerIndex = loginCustomer(customerList, inputEmail, inputPassword);
                    //if customerIndex =0, customer not found 
                    if (customerIndex == 0) {
                        //if customer enter invalid login details
                        System.out.println("Login failed, please try again");
                        flag = true; //start loop
                    } else {

                        //user account found
                        customerMenu(customerIndex, customerList, staffList, itemList, allRecord, item, amt1, amt2, amt3);

                        flag = false; // exit loop
                    }
                } else {
                    //user account found
                    staffMenu(staffIndex, staffList, itemList, allRecord, delivery);
                    flag = false; // exit loop
                }
            } else {
                flag = false;// user enter 0, exit loop
            }
        } while (flag == true);
    }

    public static int loginCustomer(ListInterface<Customer> customerList, String inputEmail, String inputPassword) {
        boolean valid = false;
        //boolean match = false;
        int customerIndex = 0;

//        System.out.println("Enter your registered email address: ");
//        inputEmail = input.nextLine();
//        System.out.println("Enter your password: ");
//        inputPassword = input.nextLine();
        for (int i = 1; i <= customerList.getNumberOfEntries(); i++) {
            if (customerList.getEntry(i).getEmail().equals(inputEmail)) {
                if (customerList.getEntry(i).getPassword().equals(inputPassword)) {
                    //match = true;
                    //System.out.println(match);
                    customerIndex = i;
                    i = customerList.getNumberOfEntries() + 1; //end the loop
                }
            }
        }

        return customerIndex; //if customerIndex == 0 means acocunt not found.
    }

    public static int loginStaff(ListInterface<Staff> staffList, String inputEmail, String inputPassword) {
        boolean valid = false;
        //boolean match = false;
        int staffIndex = 0;

//        System.out.println("Enter your registered email address: ");
//        inputEmail = input.nextLine();
//        System.out.println("Enter your password: ");
//        inputPassword = input.nextLine();
        for (int i = 1; i <= staffList.getNumberOfEntries(); i++) {
            if (staffList.getEntry(i).getEmail().equals(inputEmail)) {
                if (staffList.getEntry(i).getPassword().equals(inputPassword)) {
//                    match = true;
//                    System.out.println(match);
                    staffIndex = i;
                    i = staffList.getNumberOfEntries() + 1; //end the loop
                }
            }
        }

        return staffIndex; //if customerIndex == 0 means acocunt not found.
    }

    public static void updateAccount(int customerIndex, ListInterface<Customer> customerList, ListInterface<Staff> staffList) {

        int option = 0;

        do {
            System.out.println("\n" + customerList.getEntry(customerIndex).toString());
            System.out.println("\nUpdate Account");
            System.out.println("1. Name ");
            System.out.println("2. Contact Number ");
            System.out.println("3. Email");
            System.out.println("4. Password ");
            System.out.println("5. Delivery address ");
            System.out.println("0. Exit ");
            System.out.print("\nPlease choose the part that you want to update (enter 0 to exit): ");

            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    updateName(customerIndex, customerList);
                    break;
                case 2:
                    updateContactNum(customerIndex, customerList);
                    break;
                case 3:
                    updateEmail(customerIndex, customerList, staffList);
                    break;
                case 4:
                    updatePassword(customerIndex, customerList);
                    break;

                case 5:
                    updateAddress(customerIndex, customerList);
                    break;
                default:
                    option = 0;
                    break;
            }
        } while (option != 0);

    }

    public static void updateName(int customerIndex, ListInterface<Customer> customerList) {
        String name;
        System.out.println("Enter the name: ");
        name = input.nextLine();

        customerList.getEntry(customerIndex).setName(name);
        System.out.println("\nThe name has been updated sucessfully.");

    }

    public static void updateContactNum(int customerIndex, ListInterface<Customer> customerList) {
        String contactNum;
        System.out.println("Enter the contact number: ");
        contactNum = input.nextLine();

        customerList.getEntry(customerIndex).setContactNum(contactNum);
        System.out.println("\nThe contact number has been updated sucessfully.");

    }

    public static void updateEmail(int customerIndex, ListInterface<Customer> customerList, ListInterface<Staff> staffList) {
        boolean valid = true;

        do {
            valid = true;
            String email;
            System.out.println("Enter the new email address (Enter 0 to exit): ");
            email = input.nextLine();

            if (email.equals("0")) {
                valid = true; //exit loop
            } else {

                for (int i = 1; i <= customerList.getNumberOfEntries(); i++) {
                    if (email.equals(customerList.getEntry(i).getEmail())) {
                        valid = false;
                    }
                }

                for (int i = 1; i <= staffList.getNumberOfEntries(); i++) {
                    if (email.equals(staffList.getEntry(i).getEmail())) {
                        valid = false;
                    }
                }
                if (valid == false) {
                    System.out.println("\nEmail has already been registered!");
                } else {
                    customerList.getEntry(customerIndex).setEmail(email);
                    System.out.println("\nThe email has been updated successfully.");
                    valid = true;
                }
            }

        } while (valid == false);

    }

    public static void updatePassword(int customerIndex, ListInterface<Customer> customerList) {
        String newPassword, confirmNewPassword, oldPassword;
        int option = 0;
        boolean valid = false;

        do {
            System.out.println("Please enter the current password (enter 0 to exit): ");
            oldPassword = input.nextLine();
            //make sure the user is the owner
            if (oldPassword.equals(customerList.getEntry(customerIndex).getPassword())) {
                do {
                    System.out.print("Enter the new password: ");
                    newPassword = input.nextLine();
                    System.out.print("Re-enter the new password: ");
                    confirmNewPassword = input.nextLine();
                    if (confirmNewPassword.equals(newPassword)) {
                        valid = true; //same password
                        customerList.getEntry(customerIndex).setPassword(newPassword);
                        System.out.println("\nThe password has been updated sucessfully.");
                    } else {
                        System.out.println("\nError, inconsistent password. Please enter again.\n");
                        valid = false;
                    }
                } while (valid == false);
            } else if (oldPassword.equals("0")) {//user chooses to exit
                valid = true; // exit loop
            } else {
                System.out.println("Incorrect Password, please try again.\n");
                valid = false;
            }
        } while (valid == false);

    }

    public static void updateAddress(int customerIndex, ListInterface<Customer> customerList) {
        String street;
        String area;
        String postCode;
        String city;
        String state;

        System.out.print("Enter street: ");
        street = input.nextLine();
        System.out.print("Enter area: ");
        area = input.nextLine();
        System.out.print("Enter post code: ");
        postCode = input.nextLine();
        System.out.print("Enter city: ");
        city = input.nextLine();
        System.out.print("Enter state: ");
        state = input.nextLine();

        customerList.getEntry(customerIndex).setAddress(new Address(street, area, postCode, city, state));
        System.out.println("\nThe delivery address has been updated sucessfully.");

    }

    //customerIndex obtained when logged in
    public static void viewAccount(int customerIndex, ListInterface<Customer> customerList) {
        System.out.println(customerList.getEntry(customerIndex).toString() + "\n\nPress enter to exit.\n");
        input.nextLine();

    }

    public static boolean deleteAccount(int customerIndex, ListInterface<Customer> customerList) {
        String confirm = "NO";
        boolean existence = true;

        System.out.println("Caution! All your information will be lost FOREVER and couldn't be retrieved again\n\n"
                + customerList.getEntry(customerIndex).toString()
                + "\n\nDo you confirm you want to delete this account? (YES/NO): ");

        confirm = input.nextLine();
        confirm = confirm.toUpperCase();
        if (confirm.equals("YES")) {
            customerList.remove(customerList.getEntry(customerIndex));
            System.out.println("\nThe account has been deleted successfully T.T\n");
            existence = false;
        } else {
            System.out.println("\nNo account has been deleted. :D\n");
        }
        return existence; // existence == false means this account is deleted
    }

}
