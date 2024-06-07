package Assinment1Lib;

import java.util.Scanner;
import java.util.Date;

public class book1 {
    // Class data members
//    private boolean isIssued;
//    private int fine;
    private static int fine;
    private static int ID;
    private String Title;
    private String Author;
    private int TotalCopies;
//    public int bookQtyCopy;

    // Creating object of Scanner class to
    // read input from users
    Scanner input = new Scanner(System.in);

    public static int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTotalCopies(int totalCopies) {
        TotalCopies = totalCopies;
    }

    public String getAuthor() {
        return Author;
    }

    public int getTotalCopies() {
        return TotalCopies;
    }

//    public boolean getIsIssued() {
//        return isIssued;
//    }


//    public void setIssued(boolean issued) {
//        isIssued = issued;
//    }



    // Method
    // To add book details
    public book1() {
        // Display message for taking input later
        // taking input via
        // nextInt() and nextLine() standard methods
        System.out.println("Enter Book ID:");
        this.ID = input.nextInt();
        input.nextLine();

        System.out.println("Enter Book Name:");
        this.Title = input.nextLine();

        System.out.println("Enter Author Name:");
        this.Author = input.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.TotalCopies = input.nextInt();
//        bookQtyCopy = this.bookQty;

//        this.isIssued = false;
//        this.fine = 0; // Initialize fine to 0
    }

    public void incrementTotalCopies() {
        TotalCopies++;
    }

    public void decrementTotalCopies() {
        TotalCopies--;
    }

    private static Date dueDate; // A Date field to store the due date

    // Constructor to set the due date when a book is issued
    public book1(Date dueDate) {
        this.dueDate = dueDate;
    }

    public static void setDueDate(Date newDueDate) {
        dueDate = newDueDate;
    }

    // Getter method to retrieve the due date
    public static Date getDueDate() {
        return dueDate;
    }


//    public void payFine(int amount) {
//        if (amount > 0) {
//            fine -= amount; // Deduct the paid amount from the fine
//            if (fine < 0) {
//                fine = 0; // Ensure the fine doesn't go negative
//            }
//        }
//    }

    public static int getFine() {
        return fine;
    }
}
