/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaassignment.Courtney.Client;

/**
 *
 * @author Courtney Chew Cheah Ni
 */
import dsaassignment.Courtney.Entity.Item;
import dsaassignment.Courtney.Entity.Fashion;
import dsaassignment.Courtney.Entity.Collectibles;
import dsaassignment.Courtney.Entity.Electronics;
import dsaassignment.Courtney.ADT.ListInterface;
import java.util.Scanner;

public class ItemManagement {

    public static void main(ListInterface<Item> itemList) {

        Scanner sc = new Scanner(System.in);
        int opt = 5;
        boolean validOpt = false;

        do {
            displayItemList(itemList);
            itemMenu();

            do {
                try {
                    opt = Integer.parseInt(sc.nextLine());

                    while (opt <= 0 || opt > 5) {
                        System.out.println("\nInvalid Number. Must be from 1 to 5.");
                        System.out.print("Enter your choice again: ");
                        opt = Integer.parseInt(sc.nextLine());
                    }

                    validOpt = true;
                } catch (Exception e) {
                    System.out.println("\nInvaid input! Please enter a number.");
                    System.out.print("Enter your choice again: ");
                    validOpt = false;
                }
            } while (validOpt == false);

            System.out.println("\n\n\n");

            switch (opt) {
                case 1:
                    //Add new item
                    addItem(itemList);
                    break;
                case 2:
                    //Remove item
                    removeItem(itemList);
                    break;
                case 3:
                    //Update item
                    updateItem(itemList);
                    break;
                case 4:
                    //Search item
                    searchItem(itemList);
            }

        } while (opt != 5);
    }

    public static void itemMenu() {
        System.out.println("    Item Menu ");
        System.out.println("=====================");
        System.out.println(" 1. Add new items");
        System.out.println(" 2. Remove items");
        System.out.println(" 3. Update items");
        System.out.println(" 4. Search items");
        System.out.println(" 5. Exit");
        System.out.print("\nEnter your choice: ");
    }

    public static void addItem(ListInterface<Item> list) {
        Scanner sc = new Scanner(System.in);
        boolean valid = false, itemExist = false;
        int catOpt = 0;
        char opt = 'N';
        String name = "", dimension = "", size = "", goNext = "";
        double weight = 0, oriPri = 0, bidPri = 0;

        do {
            displayItemList(list);
            System.out.print("Add new item (Y/N)? ");
            opt = Character.toUpperCase(sc.nextLine().charAt(0));

            while (opt != 'Y' && opt != 'N') {
                System.out.println("Invalid Input! Please enter only Y or N.");
                System.out.print("Add new item (Y/N)? ");
                opt = Character.toUpperCase(sc.nextLine().charAt(0));
            }

            if (opt == 'Y') {
                //Select item category
                System.out.println("\nSelect category to add: ");
                System.out.println("1. Fashion \n2. Electronics \n3. Collectibles");
                System.out.print("Enter option: ");

                do {
                    try {
                        catOpt = Integer.parseInt(sc.nextLine());

                        while (catOpt <= 0 || catOpt > 3) {
                            System.out.println("\nInvaid input! Please enter number between 1 to 3.");
                            System.out.print("Enter option: ");
                            catOpt = Integer.parseInt(sc.nextLine());
                        }

                        valid = true;

                    } catch (Exception e) {
                        System.out.println("\nInvaid input! Please enter a number.");
                        System.out.print("Enter option: ");
                        valid = false;
                    }

                } while (valid == false);

                //Item name
                System.out.print("\n\nEnter new item name: ");
                name = sc.nextLine();

                if (catOpt == 1) {
                    //Size  
                    System.out.print("Enter size: ");
                    size = sc.nextLine();
                } else {
                    //Dimension  
                    System.out.print("Enter dimension: ");
                    dimension = sc.nextLine();
                }

                //Weight(kg)   
                System.out.print("Enter weight(kg): ");
                do {
                    try {
                        weight = Double.parseDouble(sc.nextLine());

                        while (weight <= 0.0) {
                            System.out.println("\nInvaid input! Please enter value more than 0.");
                            System.out.print("Enter weight (kg) again: ");
                            weight = Double.parseDouble(sc.nextLine());
                        }

                        valid = true;

                    } catch (Exception e) {
                        System.out.println("\nInvaid input! Please enter a number.");
                        System.out.print("Enter weight (kg) again: ");
                        valid = false;
                    }

                } while (valid == false);

                //Original Price(RM) 
                System.out.print("Enter original price (RM): ");
                do {
                    try {
                        oriPri = Double.parseDouble(sc.nextLine());

                        while (oriPri <= 0.0) {
                            System.out.println("\nInvaid input! Please enter value more than 0.");
                            System.out.print("Enter original price (RM) again: ");
                            oriPri = Double.parseDouble(sc.nextLine());
                        }

                        valid = true;

                    } catch (Exception e) {
                        System.out.println("\nInvaid input! Please enter a number.");
                        System.out.print("Enter original price (RM) again: ");
                        valid = false;
                    }

                } while (valid == false);

                //Starting Bid Price(RM)   
                System.out.print("Enter starting bid price (RM): ");
                do {
                    try {
                        bidPri = Double.parseDouble(sc.nextLine());

                        while (bidPri <= 0.0) {
                            System.out.println("\nInvaid input! Please enter value more than 0.");
                            System.out.print("Enter starting bid price (RM) again: ");
                            bidPri = Double.parseDouble(sc.nextLine());
                        }

                        valid = true;

                    } catch (Exception e) {
                        System.out.println("\nInvaid input! Please enter a number.");
                        System.out.print("Enter starting bid price (RM) again: ");
                        valid = false;
                    }

                } while (valid == false);

                //Add new item into list
                switch (catOpt) {
                    //Fashion
                    case 1:
                        Fashion newFItem = new Fashion(name, size, weight, oriPri, bidPri);
                        list.add(newFItem);
                        itemExist = list.contains(newFItem);
                        break;
                    //Electronics
                    case 2:
                        Electronics newEItem = new Electronics(name, dimension, weight, oriPri, bidPri);
                        list.add(newEItem);
                        itemExist = list.contains(newEItem);
                        break;
                    //Collectibles
                    case 3:
                        Collectibles newCItem = new Collectibles(name, dimension, weight, oriPri, bidPri);
                        list.add(newCItem);
                        itemExist = list.contains(newCItem);
                        break;
                }

                //Check if new item is inside list
                if (itemExist) {
                    System.out.println("\n\n");
                    displayItemList(list);  //Display new list
                    System.out.println("New item added successfully... (Enter to continue)\n");
                } else {
                    System.out.println("New item failed to be added... (Enter to continue)\n");
                }

                goNext = sc.nextLine(); //To stop for a moment before continuing
            }

        } while (opt != 'N');

        System.out.println("\n\n");
    }

    public static void removeItem(ListInterface<Item> list) {
        Scanner sc = new Scanner(System.in);
        int itemNo = 0, removeOpt = 0;
        String goNext = "";
        char confirm = 'N';
        boolean validNo = false, validOpt = false;

        do {

            if (list.isEmpty()) {
                System.out.println("Item List is empty... Remove operation not allowed. (Enter to continue)\n\n");
                goNext = sc.nextLine(); //To stop for a moment before continuing
                itemNo = 0;
            } else {
                displayItemList(list);
                System.out.println("Options to remove item(s) (0 to exit): ");
                System.out.println("1. Remove 1 item \n2. Remove all");
                System.out.print("Enter option: ");

                do {
                    try {
                        removeOpt = Integer.parseInt(sc.nextLine());

                        while (removeOpt < 0 || removeOpt > 2) {
                            System.out.println("\nInvalid Number. Must be from 0 or 2.");
                            System.out.print("Enter your choice again: ");
                            removeOpt = Integer.parseInt(sc.nextLine());
                        }

                        validOpt = true;
                    } catch (Exception e) {
                        System.out.println("\nInvaid input! Please enter a number.");
                        System.out.print("Enter your choice again: ");
                    }
                } while (validOpt == false);

                if (removeOpt == 1) {
                    System.out.print("Enter item no. to remove (0 to exit): ");
                    do {
                        try {   //Check item no. entered is a number within the range
                            itemNo = Integer.parseInt(sc.nextLine());

                            while (itemNo < 0 || itemNo > list.getNumberOfEntries()) {
                                System.out.println("\nInvalid Number. Must be from 1 to " + list.getNumberOfEntries() + ".");
                                System.out.print("Enter item no. to remove again: ");
                                itemNo = Integer.parseInt(sc.nextLine());
                            }

                            validNo = true;

                        } catch (Exception e) {
                            System.out.println("\nInvaid input! Please enter a number.");
                            System.out.print("Enter item no. to remove again: ");
                            validNo = false;
                        }
                    } while (validNo == false);

                    if (itemNo > 0) {   //Check if item number is bigger than 0
                        System.out.print("Confirm remove (Y/N)? ");
                        confirm = Character.toUpperCase(sc.nextLine().charAt(0));
                        if (confirm == 'Y') {
                            Item removedItem = list.remove(itemNo); //Store removed item into removedItem

                            System.out.println("\n\n");
                            displayItemList(list);  //Display new list

                            if (!list.contains(removedItem)) {   //Check if item removed successfully
                                System.out.println("New item removed successfully... (Enter to continue)\n");
                            } else {
                                System.out.println("New item failed to be removed... (Enter to continue)\n");
                            }
                        } else {
                            System.out.println("\nAction cancelled... (Enter to continue)\n");
                        }

                    }
                } else if (removeOpt == 2) {
                    System.out.print("Confirm remove (Y/N)?");
                    confirm = Character.toUpperCase(sc.nextLine().charAt(0));
                    if (confirm == 'Y') {
                        list.clear();   //Remove all items in list
                        itemNo = 1;     //To prevent from 
                        System.out.println("\n\n");
                        displayItemList(list);  //Display new list

                        if (list.isEmpty()) {   //Check if item removed successfully
                            System.out.println("Items removed successfully... (Enter to continue)\n");
                        } else {
                            System.out.println("Items failed to be removed... (Enter to continue)\n");
                        }
                    } else {
                        System.out.println("\nAction cancelled... (Enter to continue)\n");
                    }

                }

                if (itemNo != 0 && removeOpt != 0) {
                    goNext = sc.nextLine(); //To stop for a moment before continuing
                }
            }

        } while (itemNo != 0 && removeOpt != 0);

        System.out.println("\n\n");

    }

    public static void updateItem(ListInterface<Item> list) {
        Scanner sc = new Scanner(System.in);
        int upOpt = 8, itemNo = 0;
        boolean validOpt = false, validInp = false;
        String[] status = {"Not Available", "On Bid", "Sold"};
        Fashion fashionItemToUpdate = new Fashion();
        Electronics electronicsItemToUpdate = new Electronics();
        Collectibles collectiblesItemToUpdate = new Collectibles();

        if (list.isEmpty()) {
            System.out.println("Item List is empty... Update operation not allowed.\n\n");
        } else {
            do {
                displayItemList(list);
                System.out.println("    Update");
                System.out.println("=====================");
                System.out.println(" 1. Update name");
                System.out.println(" 2. Update size/dimension");
                System.out.println(" 3. Update weight");
                System.out.println(" 4. Update original price");
                System.out.println(" 5. Update starting bid price");
                System.out.println(" 6. Update status");
                System.out.println(" 7. Shift items");
                System.out.println(" 8. Exit");
                System.out.print("\nEnter update option: ");

                do {
                    try {
                        upOpt = Integer.parseInt(sc.nextLine());

                        while (upOpt <= 0 || upOpt > 8) {
                            System.out.println("\nInvalid Number. Must be from 1 to 8.");
                            System.out.print("Enter item no. again: ");
                            upOpt = Integer.parseInt(sc.nextLine());
                        }

                        validOpt = true;
                    } catch (Exception e) {
                        System.out.println("\nInvaid input! Please enter a number.");
                        System.out.print("Enter item no. again: ");
                    }
                } while (validOpt == false);

                if (upOpt < 7) {
                    System.out.print("Enter item no. to update: ");

                    do {
                        try {
                            itemNo = Integer.parseInt(sc.nextLine());

                            while (itemNo <= 0 || itemNo > list.getNumberOfEntries()) {
                                System.out.println("\nInvalid Number. Must be from 1 to " + list.getNumberOfEntries() + ".");
                                System.out.print("Enter item no. again: ");
                                itemNo = Integer.parseInt(sc.nextLine());
                            }

                            validOpt = true;
                        } catch (Exception e) {
                            System.out.println("\nInvaid input! Please enter a number.");
                            System.out.print("Enter item no. again: ");
                            validOpt = false;
                        }
                    } while (validOpt == false);

                    if (list.getEntry(itemNo) instanceof Fashion) {
                        fashionItemToUpdate = (Fashion) list.getEntry(itemNo);
                    } else if (list.getEntry(itemNo) instanceof Electronics) {
                        electronicsItemToUpdate = (Electronics) list.getEntry(itemNo);
                    } else if (list.getEntry(itemNo) instanceof Collectibles) {
                        collectiblesItemToUpdate = (Collectibles) list.getEntry(itemNo);
                    }

                    System.out.println("\n\nItem No. selected: " + itemNo);
                }

                switch (upOpt) {
                    case 1:
                        //Update name
                        System.out.print("Enter new name: ");
                        String name = sc.nextLine();

                        if (list.getEntry(itemNo) instanceof Fashion) {
                            fashionItemToUpdate.setName(name);
                            list.replace(itemNo, fashionItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Electronics) {
                            electronicsItemToUpdate.setName(name);
                            list.replace(itemNo, electronicsItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Collectibles) {
                            collectiblesItemToUpdate.setName(name);
                            list.replace(itemNo, collectiblesItemToUpdate);
                        }
                        System.out.println("\n");
                        break;
                    case 2:
                        //Update dimension
                        if (list.getEntry(itemNo) instanceof Fashion) {
                            System.out.print("Enter new size: ");
                            String size = sc.nextLine();
                            fashionItemToUpdate.setSize(size);
                            list.replace(itemNo, fashionItemToUpdate);

                        } else if (list.getEntry(itemNo) instanceof Electronics) {
                            System.out.print("Enter new dimension: ");
                            String dimension = sc.nextLine();
                            electronicsItemToUpdate.setDimension(dimension);
                            list.replace(itemNo, electronicsItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Collectibles) {
                            System.out.print("Enter new dimension: ");
                            String dimension = sc.nextLine();
                            collectiblesItemToUpdate.setDimension(dimension);
                            list.replace(itemNo, collectiblesItemToUpdate);
                        }
                        System.out.println("\n");
                        break;
                    case 3:
                        //Update weight   
                        System.out.print("Enter new weight(kg): ");
                        double weight = 0;
                        do {
                            try {
                                weight = Double.parseDouble(sc.nextLine());

                                while (weight <= 0.0) {
                                    System.out.println("\nInvaid input! Please enter value more than 0.");
                                    System.out.print("Enter new weight (kg) again: ");
                                    weight = Double.parseDouble(sc.nextLine());
                                }

                                validInp = true;

                            } catch (Exception e) {
                                System.out.println("\nInvaid input! Please enter a number.");
                                System.out.print("Enter new weight (kg) again: ");
                                validInp = false;
                            }

                        } while (validInp == false);

                        if (list.getEntry(itemNo) instanceof Fashion) {
                            fashionItemToUpdate.setWeight(weight);
                            list.replace(itemNo, fashionItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Electronics) {
                            electronicsItemToUpdate.setWeight(weight);
                            list.replace(itemNo, electronicsItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Collectibles) {
                            collectiblesItemToUpdate.setWeight(weight);
                            list.replace(itemNo, collectiblesItemToUpdate);
                        }
                        System.out.println("\n");
                        break;
                    case 4:
                        //Update original price
                        System.out.print("Enter new original price (RM): ");
                        double oriPri = 0;
                        do {
                            try {
                                oriPri = Double.parseDouble(sc.nextLine());

                                while (oriPri <= 0.0) {
                                    System.out.println("\nInvaid input! Please enter value more than 0.");
                                    System.out.print("Enter new original price (RM) again: ");
                                    oriPri = Double.parseDouble(sc.nextLine());
                                }

                                validInp = true;

                            } catch (Exception e) {
                                System.out.println("\nInvaid input! Please enter a number.");
                                System.out.print("Enter new original price (RM) again: ");
                                validInp = false;
                            }

                        } while (validInp == false);

                        if (list.getEntry(itemNo) instanceof Fashion) {
                            fashionItemToUpdate.setOriPrice(oriPri);
                            list.replace(itemNo, fashionItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Electronics) {
                            electronicsItemToUpdate.setOriPrice(oriPri);
                            list.replace(itemNo, electronicsItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Collectibles) {
                            collectiblesItemToUpdate.setOriPrice(oriPri);
                            list.replace(itemNo, collectiblesItemToUpdate);
                        }
                        System.out.println("\n");
                        break;
                    case 5:
                        //Update starting bid price
                        System.out.print("Enter starting bid price (RM): ");
                        double bidPri = 0;
                        do {
                            try {
                                bidPri = Double.parseDouble(sc.nextLine());

                                while (bidPri <= 0.0) {
                                    System.out.println("\nInvaid input! Please enter value more than 0.");
                                    System.out.print("Enter starting bid price (RM) again: ");
                                    bidPri = Double.parseDouble(sc.nextLine());
                                }

                                validInp = true;

                            } catch (Exception e) {
                                System.out.println("\nInvaid input! Please enter a number.");
                                System.out.print("Enter starting bid price (RM) again: ");
                                validInp = false;
                            }

                        } while (validInp == false);

                        if (list.getEntry(itemNo) instanceof Fashion) {
                            fashionItemToUpdate.setStartBidPrice(bidPri);
                            list.replace(itemNo, fashionItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Electronics) {
                            electronicsItemToUpdate.setStartBidPrice(bidPri);
                            list.replace(itemNo, electronicsItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Collectibles) {
                            collectiblesItemToUpdate.setStartBidPrice(bidPri);
                            list.replace(itemNo, collectiblesItemToUpdate);
                        }
                        System.out.println("\n");

                        break;
                    case 6:
                        //Update status
                        int staOpt = 0;
                        System.out.println("\n\n     Status");
                        System.out.println("=================");
                        System.out.println("1. Not Available");
                        System.out.println("2. On Bid");
                        System.out.println("3. Sold");
                        System.out.print("\nEnter option: ");

                        do {
                            try {
                                staOpt = Integer.parseInt(sc.nextLine());

                                while (staOpt <= 0 || staOpt > 3) {
                                    System.out.println("\nInvalid Number. Must be from 1 to 3.");
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

                        String stat = status[staOpt - 1];

                        if (list.getEntry(itemNo) instanceof Fashion) {
                            fashionItemToUpdate.setStatus(stat);
                            list.replace(itemNo, fashionItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Electronics) {
                            electronicsItemToUpdate.setStatus(stat);
                            list.replace(itemNo, electronicsItemToUpdate);
                        } else if (list.getEntry(itemNo) instanceof Collectibles) {
                            collectiblesItemToUpdate.setStatus(stat);
                            list.replace(itemNo, collectiblesItemToUpdate);
                        }

                        System.out.println("\n\n");

                        break;
                    case 7:
                        //Shift position of items
                        shiftItem(list);
                        System.out.println("\n\n");
                }

            } while (upOpt != 8);

            System.out.print("\n");

        }
    }

    public static void shiftItem(ListInterface<Item> list) {
        Scanner sc = new Scanner(System.in);
        int itemNo = 0, newPosition = 0;
        boolean validOpt = false;

        System.out.println("\n");
        displayItemList(list);
        if (list.getNumberOfEntries() == 1) {
            System.out.println("Only 1 item in list. Unable to shift... (Enter to continue)\n");
            sc.nextLine();
        } else {
            System.out.print("Enter item no. to shift position: ");

            do {
                try {
                    itemNo = Integer.parseInt(sc.nextLine());

                    while (itemNo <= 0 || itemNo > list.getNumberOfEntries()) {
                        System.out.println("\nInvalid Number. Must be from 1 to " + list.getNumberOfEntries() + ".");
                        System.out.print("Enter item no. again: ");
                        itemNo = Integer.parseInt(sc.nextLine());
                    }

                    validOpt = true;
                } catch (Exception e) {
                    System.out.println("\nInvaid input! Please enter a number.");
                    System.out.print("Enter item no. again: ");
                    validOpt = false;
                }
            } while (validOpt == false);

            System.out.print("Enter new position: ");

            do {
                try {
                    newPosition = Integer.parseInt(sc.nextLine());

                    while (newPosition <= 0 || newPosition > list.getNumberOfEntries()) {
                        System.out.println("\nInvalid Number. Must be from 1 to " + list.getNumberOfEntries() + ".");
                        System.out.print("Enter new position again: ");
                        newPosition = Integer.parseInt(sc.nextLine());
                    }

                    validOpt = true;
                } catch (Exception e) {
                    System.out.println("\nInvaid input! Please enter a number.");
                    System.out.print("Enter new position again: ");
                    validOpt = false;
                }
            } while (validOpt == false);

            list.shift(itemNo, newPosition);
        }

    }

    public static void searchItem(ListInterface<Item> list) {
        Scanner sc = new Scanner(System.in);
        String searchID = "";

        do {
            displayItemList(list);

            System.out.print("Enter the itemID to search (0 to exit): ");
            searchID = sc.nextLine();

            if (!searchID.equals("0")) {    //Check if searchID is 0
                System.out.println("\n\nSearch Result: \n");
                if (list.getEntry(searchID) != null) {
                    System.out.println(String.format("%4s%10s%13s%24s%41s%22s%22s%26s%15s", " No.", "Item ID", "Category", "Name", "Size", "Weight(kg)", "Original Price(RM)", "Starting Bid Price(RM)", "Status"));
                    System.out.println("=======================================================================================================================================================================================");
                    System.out.println(list.getEntry(searchID));    //Print out the search result
                } else {
                    System.out.println("No result for \"" + searchID + "\"");
                }

                System.out.print("Enter to continue....");      //Pause until enter is pressed
                sc.nextLine();
            }

            System.out.println("\n");

        } while (!searchID.equals("0"));
    }

    public static void displayItemList(ListInterface<Item> list) {
        if (list.isEmpty()) {
            System.out.println("Item List is empty...\n");
        } else {
            System.out.println(String.format("%70s", "Item List"));
            System.out.println("=======================================================================================================================================================================================");
            System.out.println(String.format("%4s%10s%13s%24s%41s%22s%22s%26s%15s", " No.", "Item ID", "Category", "Name", "Size", "Weight(kg)", "Original Price(RM)", "Starting Bid Price(RM)", "Status"));
            System.out.println("=======================================================================================================================================================================================");
            System.out.println(list);
        }
    }
}
