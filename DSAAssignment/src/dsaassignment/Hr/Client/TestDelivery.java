/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.Hr.Client;

import dsaassignment.Caleb.ADT.LinkInterface;
import dsaassignment.Caleb.Entity.BidReport;
import dsaassignment.Hr.ADT.ArrayQueue;
import dsaassignment.Hr.ADT.QueueInterface;
import dsaassignment.Hr.Entity.Delivery;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Tang Hang Rong
 */
public class TestDelivery {


    public static void main(LinkInterface<BidReport> allRecord, QueueInterface<Delivery> delivery) {
        Scanner input = new Scanner(System.in);
        boolean session = true;

        while (session) {
            int choose;
            System.out.println("\n\n==============================================");
            System.out.println("                Delivery Module               ");
            System.out.println("==============================================");

            System.out.println("1. Create Delivery");
            System.out.println("2. Update Delivery Order");
            System.out.println("3. View Delivery details");
            System.out.println("4. Exit");
            System.out.print("Please choose from 1-4: ");
            choose = input.nextInt();
            System.out.println("\n");

            switch (choose) {
                case 1:
                    createDelivery(allRecord, delivery);
                    break;
                case 2:
                    updateDelivery(delivery);
                    break;
                case 3:
                    displayDeliveryDetails(delivery);
                    break;
                case 4:
                    session = false;
            }

        }

    }

    public static void createDelivery(LinkInterface<BidReport> bidReport, QueueInterface<Delivery> delivery) {
        Iterator<Delivery> it = delivery.getIterator();
        BidReport brep = new BidReport();
        boolean newItem = false, exist = false;

        
        System.out.println(bidReport);
        
        if (bidReport.isEmpty()) {
            System.out.println("\nNo items to deliver...\n");
        } else {
            if (delivery.isEmpty()) {
                for (int i = 1; i <= bidReport.getNumberOfEntries(); i++) {
                    if (bidReport.getEntry(i).getStatus().equals("Sold")) {
                        delivery.enQueue(new Delivery(bidReport.getEntry(i)));
                        newItem = true;
                    }
                }
            } else {
                while (it.hasNext()) {
                    Delivery del = it.next();
                    for (int j = 1; j <= bidReport.getNumberOfEntries(); j++) {
                        if (bidReport.getEntry(j).getStatus().equals("Sold")) {
                            brep = bidReport.getEntry(j);
                            if (del.getBid().getRegNo() == (bidReport.getEntry(j).getRegNo())) {
                                exist = true;
                                break;
                            }
                        }

                    }
                    if (!exist) {
                        delivery.enQueue(new Delivery(brep));
                        newItem = true;
                    }

                }
            }

        }

        if (newItem) {
            System.out.println("New delivery created...\n");
        } else {
            System.out.println("\nNo new items to deliver...\n");
        }

        displayDeliveryDetails(delivery);

        System.out.println("\n\n");

    }

    public static void updateDelivery(QueueInterface<Delivery> delivery) {
        Iterator<Delivery> it = delivery.getIterator();
        Scanner sc = new Scanner(System.in);
        int upOpt = 0;
        String status = "";
        boolean validOpt = false;

        do {
            displayDeliveryDetails(delivery);

            if (!delivery.isEmpty()) {

                System.out.println("\n Update Delivery Status");
                System.out.println("=======================");
                System.out.println("1. Packing");
                System.out.println("2. Out for Delivery");
                System.out.println("3. Received");
                System.out.println("4. Cancelled");
                System.out.print("Enter option (0 to exit): ");

                do {
                    try {
                        upOpt = Integer.parseInt(sc.nextLine());

                        while (upOpt < 0 || upOpt > 4) {
                            System.out.println("\nInvalid Number. Must be from 0 to 4.");
                            System.out.print("Enter option again: ");
                            upOpt = Integer.parseInt(sc.nextLine());
                        }

                        validOpt = true;
                    } catch (Exception e) {
                        System.out.println("\nInvaid input! Please enter a number.");
                        System.out.print("Enter option again: ");
                        validOpt = false;
                    }
                } while (validOpt == false);

                System.out.println("\n");
                Delivery del = delivery.deQueue();

                switch (upOpt) {
                    case 0:
                        break;
                    case 1:
                        status = "Packing";
                        break;
                    case 2:
                        status = "Out for Delivery";
                        break;
                    case 3:
                        status = "Received";
                        break;
                    case 4:
                        status = "Cancelled";
                        break;
                }

                del.setStatus(status);
                delivery.enQueue(del);

            }
        } while (upOpt != 0);

    }

    public static void displayDeliveryDetails(QueueInterface<Delivery> delivery) {
        Iterator<Delivery> it = delivery.getIterator();

        if (delivery.isEmpty()) {
            System.out.println("\nNo deliveries...\n");
        } else {
            System.out.println(String.format("%8s%12s %24s%30s%29s%30s%48s", " Delivery ID", "Date", "Customer Name", "Item Name", "Weight (kg)", "Address", "Status"));
            System.out.println("=====================================================================================================================================================================================================");
            while (it.hasNext()) {
                Delivery del = it.next();
                System.out.println(del);
            }
            System.out.println("\n\n");
        }
    }

}
