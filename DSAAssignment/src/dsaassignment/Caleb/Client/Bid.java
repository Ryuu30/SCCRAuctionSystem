/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.Caleb.Client;

import dsaassignment.Caleb.ADT.LinkedList;
import dsaassignment.Caleb.ADT.LinkInterface;
import dsaassignment.Caleb.ADT.Stack;
import dsaassignment.Caleb.ADT.StackInterface;
import dsaassignment.Caleb.Entity.BidItem;
import dsaassignment.Caleb.Entity.BidResult;
import dsaassignment.Caleb.Entity.BidReport;
import dsaassignment.Courtney.ADT.ListInterface;
import dsaassignment.Courtney.Entity.Item;
import dsaassignment.KS.User.Customer;
import java.util.Scanner;

/**
 *
 * @author Caleb Chu Ken Lun
 */
public class Bid {

    /**
     * @param args the command line arguments
     */
    private Scanner sc = new Scanner(System.in);
    int count = 0;

    public void menu(ListInterface<Item> list, dsaassignment.KS.ADT.ListInterface<Customer> customerList, int customerIndex, LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item, StackInterface<BidResult> amt1, StackInterface<BidResult> amt2, StackInterface<BidResult> amt3) {
        boolean flag = false;
        int choose = 0;

        do {
            System.out.println("\n\n\n           Bidding!");
            System.out.println("  -----------------------------------");
            System.out.println("    1. Start to Bid");
            System.out.println("    2. View Bid Record");
            System.out.println("    3. Update Bid Item");
            System.out.println("    4. Delete Latest Bid Record");
            System.out.println("    5. Report");
            System.out.println("    6. Quit");
            System.out.print("    Enter your choice (number) : ");
            do {
                try {
                    choose = Integer.parseInt(sc.nextLine());

                    while (choose <= 0 || choose > 6) {
                        System.out.println("\nInvalid Number. Please enter from 1 to 6.");
                        System.out.print("Enter your choice again: ");
                        choose = Integer.parseInt(sc.nextLine());

                    }
                    flag = true;
                } catch (Exception e) {
                    System.out.println("\nInvalid Number. Please enter number.");
                    System.out.print("Enter your choice again: ");
                    flag = false;
                }

            } while (flag == false);

            switch (choose) {
                case 1:
                    getInput(list, customerList, customerIndex, allRecord, item, amt1, amt2, amt3);
                    break;
                case 2:
                    viewHighest(list, customerList, customerIndex, item, amt1, amt2, amt3);
                    break;
                case 3:
                    update(list, customerList, customerIndex, item, amt1, amt2, amt3);
                    break;
                case 4:
                    delete(list, customerList, customerIndex, allRecord, item, amt1, amt2, amt3);
                    break;
                case 5:
                    viewCustomerTrasaction(list, customerList, customerIndex, allRecord, item);
                    break;
            }

        } while (choose != 6);

    }

    public void getInput(ListInterface<Item> list, dsaassignment.KS.ADT.ListInterface<Customer> customerList, int customerIndex, LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item, StackInterface<BidResult> amt1, StackInterface<BidResult> amt2, StackInterface<BidResult> amt3) {
        boolean flag = false, gotSold = false, gotSold2 = false, gotSold3 = false;
        int item1 = 0;
        int countt = 0;
        int q = 0;
        int b = 0;
        double amount1 = 0.0;
        double amount2 = 0.0;
        double amount3 = 0.0;
        char go = 'Y';

        do {
            if (go == 'Y') {
                // display item //minimum bid amount

                for (int a = 1; a <= list.getNumberOfEntries(); a++) {
                    if (list.getEntry(a).getStatus() == "Sold") {
                        gotSold = true;
                    }
                }

                if (!gotSold) {

                    for (int i = 1; i <= list.getNumberOfEntries(); i++) {
                        if (list.getEntry(i).getStatus().equals("On Bid")) {
                            if (item.isEmpty()) {
                                item.add(new BidItem(list.getEntry(i).getItemID(), list.getEntry(i).getName(), list.getEntry(i).getStartBidPrice()));
                                amt1.addHighest(new BidResult("No", list.getEntry(i).getStartBidPrice())); //push minimun amount
                                System.out.print("1");
                            } else if (item.getNumberOfEntries() == 1) {
                                item.add(new BidItem(list.getEntry(i).getItemID(), list.getEntry(i).getName(), list.getEntry(i).getStartBidPrice()));
                                amt2.addHighest(new BidResult("No", list.getEntry(i).getStartBidPrice())); //push minimun amount
                                System.out.print("2");
                            } else if (item.getNumberOfEntries() == 2) {
                                item.add(new BidItem(list.getEntry(i).getItemID(), list.getEntry(i).getName(), list.getEntry(i).getStartBidPrice()));
                                amt3.addHighest(new BidResult("No", list.getEntry(i).getStartBidPrice())); //push minimun amount
                                System.out.print("3");
                            }
                            countt++;
                        }
                    }

                }

                int countitem = countt;

                for (int a = 1; a <= list.getNumberOfEntries(); a++) {
                    if (list.getEntry(a).getStatus() == "Sold") {
                        gotSold2 = true;
                    }
                }

                if (!gotSold2) {
                    for (int i = 1; i <= list.getNumberOfEntries(); i++) {
                        if (list.getEntry(i).getStatus().equals("On Bid")) {
                            int o = 3 - countt; //=2
                            for (int u = 1; u <= o; u++) {
                                list.getEntry(u).setStatus("On Bid");
                                countitem++;
                            }

                        } else if (countitem < 3) {
                            for (int l = 1; l < 4; l++) {
                                if (countitem < 3) {
                                    list.getEntry(l).setStatus("On Bid");
                                    countitem++;

                                }
                            }
                        }

                    }
                }

                dsaassignment.Courtney.Client.ItemManagement.displayItemList(list);

                System.out.println(String.format("%50s", "Bid List"));
                System.out.println("====================================================================================================================================================================");
                System.out.println(String.format("%4s%10s%19s%60s", " No.", "Item ID", "Name", "Minimum Bid Price(RM)"));
                System.out.println("====================================================================================================================================================================");
                switch (item.getNumberOfEntries()) {
                    case 0:
                        q = 0;
                        b = 1;
                        break;
                    case 1:
                        q = 1;
                        b = 2;
                        break;
                    case 2:
                        q = 2;
                        b = 3;
                        break;
                    case 3:
                        q = 3;
                        b = 0;
                        break;
                    default:
                        break;
                }

                for (int a = 1; a <= list.getNumberOfEntries(); a++) {
                    if (list.getEntry(a).getStatus() == "Sold") {
                        gotSold3 = true;
                    }
                }

                if (!gotSold3) {
                    for (int i = 1; i <= 3 - q; i++) {
                        switch (b) {
                            case 1:
                                item.add(new BidItem(list.getEntry(i).getItemID(), list.getEntry(i).getName(), list.getEntry(i).getStartBidPrice()));
                                amt1.addHighest(new BidResult("No", list.getEntry(i).getStartBidPrice())); //push minimun amount

                                break;
                            case 2:

                                item.add(new BidItem(list.getEntry(i).getItemID(), list.getEntry(i).getName(), list.getEntry(i).getStartBidPrice()));
                                amt2.addHighest(new BidResult("No", list.getEntry(i).getStartBidPrice()));
                                break;
                            case 3:

                                item.add(new BidItem(list.getEntry(i).getItemID(), list.getEntry(i).getName(), list.getEntry(i).getStartBidPrice()));
                                amt3.addHighest(new BidResult("No", list.getEntry(i).getStartBidPrice()));
                                break;
                            default:
                                break;
                        }
                        b++;
                    }
                }

                System.out.print(item);
                String custName = String.valueOf(customerList.getEntry(customerIndex).getName());
                Customer cust = customerList.getEntry(customerIndex);

                System.out.println("\nWelcome " + customerList.getEntry(customerIndex).getName() + "." + " You can start to bid now!"); //need to display name for this(combine)
                System.out.print("Enter the item you want to bid (number): ");
                do {
                    try {
                        item1 = Integer.parseInt(sc.nextLine());

                        while (item1 > item.getNumberOfEntries() || item1 < 1) {
                            System.out.print("You can only choose 1 to " + item.getNumberOfEntries()
                                    + "\n(Enter the item you want to bid (number): ");
                            item1 = Integer.parseInt(sc.nextLine());
                        }
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("\nInvalid Number. Please enter number.");
                        System.out.print("Enter the item you want to bid again(number): ");
                        flag = false;
                    }

                } while (flag == false);

                System.out.print("Enter the amount you want to bid"
                        + "\n(Amount have to bigger than the minimum amount) : RM");

                switch (item1) {
                    case 1:
                        do {
                            try {
                                amount1 = Double.parseDouble(sc.nextLine());
                                while (amount1 <= amt1.highest().getBidPrice()) {
                                    System.out.println("\nBid unsuccessfully.");
                                    System.out.println("Please try again!");
                                    System.out.print("Enter the amount you want to bid again"
                                            + "\n(Amount have to bigger than the minimum amount) : RM");
                                    amount1 = Double.parseDouble(sc.nextLine());
                                }
                                flag = true;
                            } catch (Exception e) {
                                System.out.println("\nInvalid Number. Please enter number.");
                                System.out.print("Enter the amount you want to bid again"
                                        + "\n(Amount have to bigger than the minimum amount) : RM");
                                flag = false;
                            }

                        } while (flag == false);

                        item.getEntry(1).setMinimumBidPrice(amount1);
                        System.out.println("\nYou had bid successfully.");
                        amt1.addHighest(new BidResult(custName, amount1));

                        System.out.println("The highest bid is " + amt1.highest().getCustomerName() + " with RM" + amt1.highest().getBidPrice() + "0.");
                        Item itemToAdd1 = list.getEntry(item.getEntry(1).getItemID());
                        allRecord.add(new BidReport(cust, itemToAdd1, amount1, "Lose"));
                        count++;

                        break;
                    case 2:
                        do {
                            try {
                                amount2 = Double.parseDouble(sc.nextLine());

                                while (amount2 <= amt2.highest().getBidPrice()) {
                                    System.out.println("\nBid unsuccessfully.");
                                    System.out.println("Please try again!");
                                    System.out.print("Enter the amount you want to bid again"
                                            + "\n(Amount have to bigger than the minimum amount) : RM");
                                    amount2 = Double.parseDouble(sc.nextLine());
                                }
                                flag = true;
                            } catch (Exception e) {
                                System.out.println("\nInvalid Number. Please enter number.");
                                System.out.print("Enter the amount you want to bid again"
                                        + "\n(Amount have to bigger than the minimum amount) : RM");
                                flag = false;
                            }

                        } while (flag == false);

                        item.getEntry(2).setMinimumBidPrice(amount2);
                        System.out.println("\nYou had bid successfully.");
                        amt2.addHighest(new BidResult(custName, amount2));
                        System.out.println("The highest bid is " + amt2.highest().getCustomerName() + " with RM" + amt2.highest().getBidPrice() + "0.");

                        Item itemToAdd2 = list.getEntry(item.getEntry(2).getItemID());
                        allRecord.add(new BidReport(cust, itemToAdd2, amount2, "Lose"));
                        count++;
                        break;
                    case 3:
                        do {
                            try {
                                amount3 = Double.parseDouble(sc.nextLine());

                                while (amount3 <= amt3.highest().getBidPrice()) {
                                    System.out.println("\nBid unsuccessfully.");
                                    System.out.println("Please try again!");
                                    System.out.print("Enter the amount you want to bid again"
                                            + "\n(Amount have to bigger than the minimum amount) : RM");
                                    amount3 = Double.parseDouble(sc.nextLine());
                                }
                                flag = true;
                            } catch (Exception e) {
                                System.out.println("\nInvalid Number. Please enter number.");
                                System.out.print("Enter the amount you want to bid again"
                                        + "\n(Amount have to bigger than the minimum amount) : RM");
                                flag = false;
                            }

                        } while (flag == false);

                        item.getEntry(3).setMinimumBidPrice(amount3);
                        System.out.println("\nYou had bid successfully.");
                        amt3.addHighest(new BidResult(custName, amount3));

                        System.out.println("The highest bid is " + amt3.highest().getCustomerName() + " with RM" + amt3.highest().getBidPrice() + "0.");
                        Item itemToAdd3 = list.getEntry(item.getEntry(3).getItemID());
                        allRecord.add(new BidReport(cust, itemToAdd3, amount3, "Lose"));
                        count++;

                        break;
                    default:
                        break;
                }
                System.out.println("\nDo you want to proceed to Payment? (Y/N)");
                System.out.print("-");
                String pay = sc.nextLine();
                if ("Y".equals(pay) || "y".equals(pay)) {
                    payment(list, customerList);
                    //list.getEntry(item1).setStatus("Sold"); 
                    for (int i = 1; i < list.getNumberOfEntries() + 1; i++) {
                        if (item.getEntry(item1).getName() == list.getEntry(i).getName()) {
                            list.getEntry(i).setStatus("Sold");
                        }
                    }
                    allRecord.getEntry(count).setStatus("Sold");
                    item.remove(item1);
                    switch (item1) {
                        case 1:
                            amt1.clear();
                            amt1.addHighest(new BidResult(amt2.highest().getCustomerName(), amt2.highest().getBidPrice()));
                            amt2.clear();
                            amt2.addHighest(new BidResult(amt3.highest().getCustomerName(), amt3.highest().getBidPrice()));
                            break;
                        case 2:
                            amt2.clear();
                            amt2.addHighest(new BidResult(amt3.highest().getCustomerName(), amt3.highest().getBidPrice()));
                            break;
                        case 3:
                            amt3.clear();
                            break;
                        default:
                            break;
                    }

                }
            }
            go = 'N';
        } while (go
                != 'N');

    }

    public void viewHighest(ListInterface<Item> list, dsaassignment.KS.ADT.ListInterface<Customer> customerList, int customerIndex, LinkInterface<BidItem> item, StackInterface<BidResult> amt1, StackInterface<BidResult> amt2, StackInterface<BidResult> amt3) {
        System.out.println("\n\n\n           ****The HIGHEST Bid****");
        System.out.println("  ----------------------------------------");
        //for loop to display item available

        for (int i = 1; i < item.getNumberOfEntries() + 1; i++) {
            System.out.println("\n" + i + "." + item.getEntry(i).getName());
            switch (i) {
                case 1:
                    if (!amt1.isEmpty()) {
                        if (!amt1.highest().getCustomerName().equals("No")) {
                            System.out.println("====================================================================================================================================================================");
                            System.out.println(String.format("%8s %20s  %20s", "No", "Customer Name", "Bid Price(RM)"));
                            System.out.println("====================================================================================================================================================================");
                            System.out.println(amt1.highest());
                        } else {
                            System.out.println("No record.");
                        }
                    } else {
                        System.out.println("No record.");
                    }
                    break;
                case 2:
                    if (!amt2.isEmpty()) {
                        if (!amt2.highest().getCustomerName().equals("No")) {
                            System.out.println("====================================================================================================================================================================");
                            System.out.println(String.format("%8s %20s  %20s", "No", "Customer Name", "Bid Price(RM)"));
                            System.out.println("====================================================================================================================================================================");
                            System.out.println(amt2.highest());
                        } else {
                            System.out.println("No record.");
                        }
                    } else {
                        System.out.println("No record.");
                    }
                    break;
                case 3:
                    if (!amt3.isEmpty()) {
                        if (!amt3.highest().getCustomerName().equals("No")) {
                            System.out.println("====================================================================================================================================================================");
                            System.out.println(String.format("%8s %20s  %20s", "No", "Customer Name", "Bid Price(RM)"));
                            System.out.println("====================================================================================================================================================================");
                            System.out.println(amt3.highest());
                        } else {
                            System.out.println("No record.");
                        }
                    } else {
                        System.out.println("No record.");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void update(ListInterface<Item> list, dsaassignment.KS.ADT.ListInterface<Customer> customerList, int customerIndex, LinkInterface<BidItem> item, StackInterface<BidResult> amt1, StackInterface<BidResult> amt2, StackInterface<BidResult> amt3) {
        int items = 0;
        int update = 0;
        boolean flag = false;

        System.out.println("\n\n Item List");
        if (item.getNumberOfEntries() > 2) {
            for (int i = 1; i < item.getNumberOfEntries() + 1; i++) {
                System.out.println(i + ". " + item.getEntry(i).getName());
            }
        } else if (item.getNumberOfEntries() == 2) {
            for (int i = 1; i < item.getNumberOfEntries() + 1; i++) {
                System.out.println(i + ". " + item.getEntry(i).getName());
            }
            System.out.println("3. None");
        } else if (item.getNumberOfEntries() == 1) {
            for (int i = 1; i < item.getNumberOfEntries() + 1; i++) {
                System.out.println(i + ". " + item.getEntry(i).getName());
            }
            System.out.println("2. None");
            System.out.println("3. None");
        } else if (item.getNumberOfEntries() == 0) {
            System.out.println("1. None");
            System.out.println("2. None");
            System.out.println("3. None");
        }

        //for loop to display item list
        System.out.print("Enter the item you want to update (number):");
        do {
            try {
                update = Integer.parseInt(sc.nextLine());

                while (update > 3 || update < 1) {
                    System.out.print("You can only choose 1 to 3"
                            + "\n(Enter the item you want to update (number): ");
                    items = Integer.parseInt(sc.nextLine());

                }
                flag = true;
            } catch (Exception e) {
                System.out.println("\nInvalid Number. Please enter number.");
                System.out.print("Enter the item you want to update (number): ");
                flag = false;
            }

        } while (flag == false);

        if (list.getNumberOfEntries() > 3) {
            System.out.println(String.format("%70s", "Item List"));
            System.out.println("=======================================================================================================================================================================================");
            System.out.println(String.format("%4s%10s%13s%24s%41s%22s%22s%26s%15s", " No.", "Item ID", "Category", "Name", "Size", "Weight(kg)", "Original Price(RM)", "Starting Bid Price(RM)", "Status"));
            System.out.println("=======================================================================================================================================================================================");
            System.out.println(list);

            System.out.print("Choose one item to update the old list(number) :");
            do {
                try {
                    items = Integer.parseInt(sc.nextLine());

                    while (items > list.getNumberOfEntries() || items < 1) {
                        System.out.print("You can only choose 1 to " + list.getNumberOfEntries()
                                + "\n(Enter the item you want to bid (number): ");
                        items = Integer.parseInt(sc.nextLine());
                    }
                    while ("On Bid".equals(list.getEntry(items).getStatus())) {
                        System.out.print("\nThe item is already available");
                        System.out.print("\nChoose one item to update the old list again(number) :");
                        items = Integer.parseInt(sc.nextLine());
                    }
                    while ("Sold".equals(list.getEntry(items).getStatus())) {
                        System.out.print("\nThe item is already sold");
                        System.out.print("\nChoose one item to update the old list again(number) :");
                        items = Integer.parseInt(sc.nextLine());
                    }
                    flag = true;
                } catch (Exception e) {
                    System.out.println("\nInvalid Number. Please enter number.");
                    System.out.print("Enter your choice again: ");
                    flag = false;
                }

            } while (flag == false);

            if (item.getNumberOfEntries() > 2) {
                list.getEntry(update).setStatus("Not Available");
                list.getEntry(items).setStatus("On Bid");
            } else if (item.getNumberOfEntries() == 2) {
                list.getEntry(items).setStatus("On Bid");
                item.add(new BidItem(list.getEntry(items).getItemID(), list.getEntry(items).getName(), list.getEntry(items).getStartBidPrice()));
                amt3.addHighest(new BidResult("No", list.getEntry(items).getStartBidPrice()));
            } else if (item.getNumberOfEntries() == 1) {
                list.getEntry(items).setStatus("On Bid");
                item.add(new BidItem(list.getEntry(items).getItemID(), list.getEntry(items).getName(), list.getEntry(items).getStartBidPrice()));
                amt2.addHighest(new BidResult("No", list.getEntry(items).getStartBidPrice()));
            } else if (item.getNumberOfEntries() == 0) {
                list.getEntry(items).setStatus("On Bid");
                item.add(new BidItem(list.getEntry(items).getItemID(), list.getEntry(items).getName(), list.getEntry(items).getStartBidPrice()));
                amt1.addHighest(new BidResult("No", list.getEntry(items).getStartBidPrice()));
            }

            BidItem newBiditem = new BidItem(list.getEntry(items).getItemID(), list.getEntry(items).getName(), list.getEntry(items).getStartBidPrice());
            for (int j = 0; j < item.getNumberOfEntries() + 1; j++) {
                if (j == update) {
                    item.replace(j, newBiditem);
                    switch (j) {
                        case 1:
                            amt1.clear();
                            amt1.addHighest(new BidResult("No", list.getEntry(items).getStartBidPrice()));
                            break;
                        case 2:
                            amt2.clear();
                            amt2.addHighest(new BidResult("No", list.getEntry(items).getStartBidPrice()));
                            break;
                        case 3:
                            amt3.clear();
                            amt3.addHighest(new BidResult("No", list.getEntry(items).getStartBidPrice()));
                            break;
                        default:
                            break;
                    }
                }
            }
        } else {
            System.out.println("\n\n\nNot enough item to update!");
        }
    }

    public void delete(ListInterface<Item> list, dsaassignment.KS.ADT.ListInterface<Customer> customerList, int customerIndex, LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item, StackInterface<BidResult> amt1, StackInterface<BidResult> amt2, StackInterface<BidResult> amt3) {
        String a = String.valueOf(amt1.highest().getCustomerName());
        String b = String.valueOf(amt2.highest().getCustomerName());
        String c = String.valueOf(amt3.highest().getCustomerName());

        if (!a.equals(customerList.getEntry(customerIndex).getName()) && !b.equals(customerList.getEntry(customerIndex).getName()) && !c.equals(customerList.getEntry(customerIndex).getName())) {
            System.out.println("\n\nYou are not the hightest bid!");
        } else {
            int i = 0;
            int o = allRecord.getNumberOfEntries();
            if (a.equals(customerList.getEntry(customerIndex).getName()) && amt1.highest().getBidPrice() == allRecord.getEntry(o).getBidPrice()) {
                i = 1;
            }
            if (b.equals(customerList.getEntry(customerIndex).getName()) && amt2.highest().getBidPrice() == allRecord.getEntry(o).getBidPrice()) {
                i = 2;
            }
            if (c.equals(customerList.getEntry(customerIndex).getName()) && amt3.highest().getBidPrice() == allRecord.getEntry(o).getBidPrice()) {
                i = 3;
            }
            System.out.println("Your latest bid....");
            System.out.println("====================================================================================================================================================================");
            System.out.println(String.format("%-15s%15s%45s", "Item ID", "Item Name", "Bid Price(RM)"));
            System.out.println("====================================================================================================================================================================");
            System.out.println(String.format("%-15s%20s%30.2f", item.getEntry(i).getItemID(), item.getEntry(i).getName(), item.getEntry(i).getMinimumBidPrice()));

            System.out.println("Are you sure you want to delete your latest bid? (Y/N)");
            System.out.print("-");
            String ans = sc.nextLine();
            if ("Y".equals(ans) || "y".equals(ans)) {
                switch (i) {
                    case 1:
                        amt1.remove();
                        item.getEntry(i).setMinimumBidPrice(amt1.highest().getBidPrice());
                        break;
                    case 2:
                        amt2.remove();
                        item.getEntry(i).setMinimumBidPrice(amt2.highest().getBidPrice());
                        break;
                    case 3:
                        amt3.remove();
                        item.getEntry(i).setMinimumBidPrice(amt3.highest().getBidPrice());
                        break;
                    default:
                        break;
                }
                int hihi = allRecord.getNumberOfEntries();
                allRecord.getEntry(hihi).setStatus("Cancel");
            }
        }
    }

    public void viewCustomerTrasaction(ListInterface<Item> list, dsaassignment.KS.ADT.ListInterface<Customer> customerList, int customerIndex, LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item) {
        boolean changestatus2 = false;
        boolean changestatus3 = false;

        changestatus1(allRecord, item);
        if (item.getNumberOfEntries() == 2) {
            changestatus2 = true;
        }
        if (changestatus2) {
            changestatus2(allRecord, item);
        }
        if (item.getNumberOfEntries() == 3) {
            changestatus3 = true;
        }
        if (changestatus3) {
            changestatus3(allRecord, item);
        }
        System.out.println("\n");
        System.out.printf("%-2s %15s %15s %40s %15s %15s %n", "No", "Bid ID", "Customer Name", "Item Name", "Bid Amount", "Status");
        System.out.println(allRecord);

        for (int a = 1; a <= allRecord.getNumberOfEntries(); a++) {
            if (!allRecord.getEntry(a).getStatus().equals("Sold") && !allRecord.getEntry(a).getStatus().equals("Cancel")) {
                allRecord.getEntry(a).setStatus("Lose");
            }

        }
    }

    private void changestatus1(LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item) {
        boolean checkstatus = false;

        for (int a = 1; a <= allRecord.getNumberOfEntries(); a++) {
            if (allRecord.getEntry(a).getStatus().equals("Lose") && allRecord.getEntry(a).getStatus() != "Cancel") {
                checkstatus = true;
            }

        }
        if (checkstatus) {
            for (int x = 0; x < allRecord.getNumberOfEntries(); x++) {
                if (allRecord.getEntry(1 + x).getBidPrice() == item.getEntry(1).getMinimumBidPrice() && allRecord.getEntry(1 + x).getItem().getName().equals(item.getEntry(1).getName())) {
                    allRecord.getEntry(1 + x).setStatus("Highest");

                }
            }
        }
    }

    private void changestatus2(LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item) {
        boolean checkstatus = false;

        for (int a = 1; a <= allRecord.getNumberOfEntries(); a++) {
            if (allRecord.getEntry(a).getStatus().equals("Lose") && allRecord.getEntry(a).getStatus() != "Cancel") {
                checkstatus = true;
            }

        }
        if (checkstatus) {
            for (int x = 0; x < allRecord.getNumberOfEntries(); x++) {
                if (allRecord.getEntry(1 + x).getBidPrice() == item.getEntry(2).getMinimumBidPrice() && allRecord.getEntry(1 + x).getItem().getName().equals(item.getEntry(2).getName())) {
                    allRecord.getEntry(1 + x).setStatus("Highest");

                }
            }
        }

    }

    private void changestatus3(LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item) {
        boolean checkstatus = false;

        for (int a = 1; a <= allRecord.getNumberOfEntries(); a++) {
            if (allRecord.getEntry(a).getStatus().equals("Lose") && allRecord.getEntry(a).getStatus() != "Cancel") {
                checkstatus = true;
            }

        }
        if (checkstatus) {
            for (int x = 0; x < allRecord.getNumberOfEntries(); x++) {
                if (allRecord.getEntry(1 + x).getBidPrice() == item.getEntry(3).getMinimumBidPrice() && allRecord.getEntry(1 + x).getItem().getName().equals(item.getEntry(3).getName())) {
                    allRecord.getEntry(1 + x).setStatus("Highest");

                }
            }
        }
    }

    public void payment(ListInterface<Item> list, dsaassignment.KS.ADT.ListInterface<Customer> customerList) {
        System.out.println("Enter your credit card 16 digit:");
        String digit = sc.nextLine();
        while (digit.length() != 16) {
            System.out.println("Your credit card must be 16 digit!");
            System.out.println("Enter your credit card 16 digit again:");
            digit = sc.nextLine();
        }
        System.out.println("Enter your card cvv: ");
        String cvv = sc.nextLine();
        while (cvv.length() != 3) {
            System.out.println("Your credit card cvv must be 3 digit!");
            System.out.println("Enter your card cvv again: ");
            cvv = sc.nextLine();
        }
        System.out.println("Enter your card expiry date: ");
        String date = sc.nextLine();
        while (date.length() != 4) {
            System.out.println("Your credit card expiry date must be 4 digit!");
            System.out.println("Enter your card expiry date again: ");
            date = sc.nextLine();
        }
        System.out.println("Payment Success!");
    }

    public static void main(ListInterface<Item> itemList, dsaassignment.KS.ADT.ListInterface<Customer> customerList, int customerIndex, LinkInterface<BidReport> allRecord, LinkInterface<BidItem> item, StackInterface<BidResult> amt1, StackInterface<BidResult> amt2, StackInterface<BidResult> amt3) {
        dsaassignment.Caleb.Client.Bid ass = new dsaassignment.Caleb.Client.Bid();

        ass.menu(itemList, customerList, customerIndex, allRecord, item, amt1, amt2, amt3);

    }

}
