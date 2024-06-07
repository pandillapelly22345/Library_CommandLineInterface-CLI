package Assinment1Lib;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.Date;

import static Assinment1Lib.students.fines;
import static Assinment1Lib.students.theStudents;

public class books1 {
    private static boolean isIssued; // A flag to track if the book is issued
    private static String dueDate;
    private static int fine;
    static book1[] issuedBooks = new book1[50]; // Create an array to store issued books
    private static int issuedCount = 0; // Keep track of the count of issued books

    static book1 theBooks[] = new book1[50];
    static book1[] books = new book1[50];
    public static int count = 0;

    books1() {
        this.isIssued = false;
    }

    public static void addBook(book1 book) {
//        count = 0;
//        if (count < books.length) {
//            books[count] = book;
//            count++;
//        } else {
//            System.out.println("Library is full. Cannot add more books.");
//        }
        if (book == null || book.getAuthor() == null || book.getTitle() == null) {
            System.out.println("Invalid");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (theBooks[i] != null && theBooks[i].getTitle() == null && book.getTitle().equalsIgnoreCase(theBooks[i].getTitle())) {
                theBooks[i].incrementTotalCopies();
                return;
            }
        }
        if (count < 50) {
            theBooks[count] = book;
            count++;
        }


    }

    public static void removeBook(int bookIdToRemove) {
        boolean found = false;
        int indexToRemove = -1;

        for (int i = 0; i < count; i++) {
            if (books[i].getID() == bookIdToRemove) {
                indexToRemove = i;
                found = true;
                break;
            }
        }

        if (found) {
            if (indexToRemove != -1) {
                if (indexToRemove == count - 1) {
                    books[indexToRemove] = null;
                } else {
                    for (int i = indexToRemove; i < count - 1; i++) {
                        books[i] = books[i + 1];
                    }
                    books[count - 1] = null;
                }
                count--;
                System.out.println("Book removed successfully.");
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public static void viewAllBooks() {
        if (count == 0) {
            System.out.println("No books in the library.");
            return;
        }

//        System.out.println("Serial No\tBook Name\tAuthor Name\tQuantity");
//        for (int i = 0; i < count; i++) {
//            System.out.println(theBooks[i].getID() + "\t\t" + theBooks[i].getTitle() + "\t\t" +
//                    theBooks[i].getAuthor() + "\t\t" + theBooks[i].getTotalCopies());
//        }
        for (int i = 0; i < count; i++) {
            System.out.println("--------------------------");
            System.out.println("Book ID - " + theBooks[i].getID());
            System.out.println("Name - " + theBooks[i].getTitle());
            System.out.println("Author - " + theBooks[i].getAuthor());
            System.out.println();
            System.out.println("--------------------------");
        }
    }

    public static int getFine(String regNum) {
        // Iterate through the issuedBooks array to find the student by registration number
        for (int i = 0; i < issuedCount; i++) {
            if (theStudents[i] != null && theStudents[i].getRegNum().equalsIgnoreCase(regNum)) {
                // If the student is found, get their fine amount from the book1 object
                if (issuedBooks[i] != null) {
                    return issuedBooks[i].getFine();
                }
            }
        }
        // If the student is not found or has no fine, return 0
        return 0;
    }

    public book1[] getBooks() {
        return books;
    }

    public static book1[] getIssuedBooks() {
        return issuedBooks;
    }

    public static void issueBook() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of the book you want to issue");
        String bookName = s.nextLine();
        System.out.println("Enter your registration number:");
        String memberRegNum = s.nextLine();

        // Find the book by its name
        int bookIndex = -1;
        for (int i = 0; i < count; i++) {
            if (theBooks[i].getTitle().equalsIgnoreCase(bookName)) {
                bookIndex = i;
                break;
            }
        }

        if (bookIndex != -1) {
            // Check if the book is available
            if (theBooks[bookIndex].getTotalCopies() > 0) {
                // Find the member by their registration number
                int memberIndex = -1;
                for (int i = 0; i < students.count; i++) {
                    if (students.theStudents[i].getRegNum().equalsIgnoreCase(memberRegNum)) {
                        memberIndex = i;
                        break;
                    }
                }

                if (memberIndex != -1) {
                    // Check if the member's fine is 0
                    // if(students.totalFine == 0)
                    if (students.fines[memberIndex] == 0) {
                        // Issue the book
                        theBooks[bookIndex].setTotalCopies(theBooks[bookIndex].getTotalCopies() - 1);
                        issuedBooks[issuedCount] = theBooks[bookIndex];
                        issuedCount++;
                        System.out.println("Book has been issued successfully.");
                        isIssued = true;

                        // Update due date and time
                        LocalDateTime issueDateTime = LocalDateTime.now();
                        LocalDateTime dueDateTime = issueDateTime.plusSeconds(10); // 10 seconds from issue time
                        dueDate = dueDateTime.toString(); // Store due date as a string
                        System.out.println("Due date and time: " + dueDate);
                    } else {
                        System.out.println("You have a fine. Please clear your fine to issue a book.");
                    }
                } else {
                    System.out.println("Member not found.");
                }
            } else {
                System.out.println("All copies of the book are already issued.");
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }


    public static void myBooks() {
        if (issuedCount == 0) {
            System.out.println("You have not issued any books.");
            return;
        }
        System.out.println("--------------------------");
        System.out.println("Issued Books:");
        System.out.println("Book Name\t\tAuthor");
        for (int i = 0; i < issuedCount; i++) {
            if (issuedBooks[i] != null) {
                System.out.println(issuedBooks[i].getTitle() + "\t\t" + issuedBooks[i].getAuthor());
            }
        }
        System.out.println("--------------------------");
    }


//    public static void returnBook(String bookName, int bookID) {
//
//
//        if (issuedCount == 0) {
//            System.out.println("You have not issued any book");
//            return;
//        }
//        for (int i = 0; i < issuedCount; i++) {
//            if (issuedBooks[i].getTitle().equalsIgnoreCase(bookName) && issuedBooks[i].getID() == bookID) {
//                issuedBooks[i].decrementTotalCopies();
//
//
//                // Add the book back to the library's collection
//                books1.addBook(issuedBooks[i]);
//
//                // Increment the total copies in the library
//                issuedBooks[i].incrementTotalCopies();
//                issuedBooks[i] = null; // Mark the slot as empty
//
//                if (isIssued) {
//                    isIssued = false;
//
//                    // Calculate fine for late return
//                    long currentTimeSeconds = System.currentTimeMillis() / 1000; // Current time in seconds
//                    long daysLate = (currentTimeSeconds - dueDate.getTime() / 1000) / (60 * 60 * 24); // Convert due date to seconds
//
//                    fine = (int) Math.max(0, daysLate - 10); // Fine starts after 10 days of delay
//
//
//                    fines[i] += fine;
//
//                    System.out.println("Book ID: " + book1.getID() + " successfully returned. " + fine + " Rupees has been charged for a delay of " + daysLate + " days.");
//                } else {
//                    System.out.println("Book is not issued.");
//                }
//
////                long currentTimeMillis = System.currentTimeMillis();
////
////                // Calculate the number of days late (assuming 1 day = 1 second)
////                long daysLate = (currentTimeMillis - book1.getDueDate().getTime()) / (1000 * 60 * 60 * 24);
////
////                if (daysLate <= 0) {
////                    System.out.println("Book ID: " + bookID + " successfully returned. No fine for on-time return.");
////                }
////                else {
////                    // Calculate the fine (e.g., 1 Rupee per day late)
////                    int fine = (int) daysLate; // You can adjust the fine calculation as needed
//
//
//                // Mark the book as returned
//
//
//                // Print the result
////                    System.out.println("Book ID: " + book1.getID() + " successfully returned. " +
////                            fine + " Rupees has been charged for a delay of " + daysLate + " days.");
//
//
//                System.out.println("Book '" + bookName + "' with ID " + bookID + " has been returned.");
//                return;
//            }
//        }
//    }
public static void returnBook(String bookName, int bookID) {

    if (issuedCount == 0) {
        System.out.println("You have not issued any book");
        return;
    }


    LocalDateTime currentDateTime = LocalDateTime.now();
    for (int i = 0; i < issuedCount; i++) {
        if (issuedBooks[i].getTitle().equalsIgnoreCase(bookName) && issuedBooks[i].getID() == bookID) {
            issuedBooks[i].decrementTotalCopies();

            // Add the book back to the library's collection
            books1.addBook(issuedBooks[i]);

            // Increment the total copies in the library
            issuedBooks[i].incrementTotalCopies();
            issuedBooks[i] = null; // Mark the slot as empty

            if (isIssued) {
                isIssued = false;

                // Calculate fine for late return in seconds
                LocalDateTime dueDateTime = LocalDateTime.parse(dueDate);
                long secondsLate = ChronoUnit.SECONDS.between(dueDateTime, currentDateTime);

                fine = (int) Math.max(0, secondsLate - 10); // Fine starts after 10 seconds of delay

                fines[i] += fine;

                if(secondsLate<=10){
                    System.out.println("Book ID: " + book1.getID() + " successfully returned. " + (fine*3) + " Rupees has been charged for " + (secondsLate) + " seconds.");
                }
                else{
                    System.out.println("Book ID: " + book1.getID() + " successfully returned. " + (fine*3) + " Rupees has been charged for a delay of " + (secondsLate+10) + " seconds.");
//                    student.getHasFine();

                }

            } else {
                System.out.println("Book is not issued.");
            }

            System.out.println("Book '" + bookName + "' with ID " + bookID + " has been returned.");
            return;
        }
    }
}

    // ...

    public static void payFine(String regNum, int amount) {
        // Find the student by their registration number
        int studentIndex = -1;
        for (int i = 0; i < count; i++) {
            if (theStudents[i] != null && theStudents[i].getRegNum() != null && theStudents[i].getRegNum().equalsIgnoreCase(regNum)) {
                studentIndex = i;
                break;
            }
        }

        if (studentIndex != -1) {
            // Update the fine associated with the student
            fines[studentIndex] -= amount;

            // Ensure the fine doesn't go negative
            if (fines[studentIndex] < 0) {
                fines[studentIndex] = 0;
            }

            System.out.println("Paid " + amount + " Rupees for Student with Reg Num " + regNum + ". Remaining fine: " + fines[studentIndex] + " Rupees.");
        } else {
            System.out.println("Student with Reg Num " + regNum + " not found.");
        }
    }
}


