package Assinment1Lib;

import java.util.Scanner;

import static Assinment1Lib.books1.issuedBooks;

public class Member1 {
//    static String[] regNum = new String[50];
    static void menu() {
        Scanner s = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("--------------------------");
            System.out.println("\nMember Menu:");
            System.out.println("1. List Available Books");
            System.out.println("2. List My Books");
            System.out.println("3. Issue book");
            System.out.println("4. Return book");
            System.out.println("5. Pay Fine");
            System.out.println("0. Exit Member Menu");
            System.out.println("--------------------------");
            choice = s.nextInt();

            if(choice == 1){
                books1.viewAllBooks();
            }
            else if(choice == 2){
                books1.myBooks();
            }
            else if(choice == 3){
                books1.issueBook();
            }
            else if(choice == 4){
                System.out.println("Enter the name of the book you want to return:");
                s.nextLine();
                String bookName = s.nextLine();

                System.out.println("Enter the ID of the book you want to return:");
                int bookID = s.nextInt();

                // Call the returnBook method and pass the input values
                books1.returnBook(bookName, bookID);
            }
//            else if (choice == 5) {
//                System.out.print("Enter the Book ID to pay fines: ");
//                int payId = s.nextInt();
//                s.nextLine();
//                if (payId >= 1 && payId <= issuedBooks.length) {
//                    if (issuedBooks[payId - 1] != null) {
//                        System.out.print("Enter the amount to pay: ");
//                        int payAmount = s.nextInt();
//                        issuedBooks[payId - 1].payFine(payAmount);
//                        System.out.println("Paid " + payAmount + " Rupees for Book ID " + payId + ". Remaining fine: " + issuedBooks[payId - 1].getFine() + " Rupees.");
//                    } else {
//                        System.out.println("Book with ID " + payId + " was not issued.");
//                    }
//                } else {
//                    System.out.println("Invalid Book ID.");
//                }
//                break;
//            }
//            else if (choice == 5) {
//                s.nextLine();
//                System.out.print("Enter the Registration Number of the student to pay fines: ");
//                String regNum = s.nextLine();
//
//
//                // Check if the student is registered
//                boolean studentFound = false;
//                for (int i = 0; i < students.count; i++) {
//                    if (students.theStudents[i] != null && students.theStudents[i].getRegNum() != null && students.theStudents[i].getRegNum().equalsIgnoreCase(regNum)) {
//                        studentFound = true;
//                        break;
//                    }
//                }
//
//                if (studentFound) {
//                    System.out.print("Enter the amount to pay: ");
//                    int payAmount = s.nextInt();
//
//                    // Call the payFine method to handle fine payment
//                    books1.payFine(regNum, payAmount);
//                    System.out.println("Paid " + payAmount + " Rupees for Member with Reg Num " + regNum + ". Remaining fine: " + books1.getFine(regNum) + " Rupees.");
//                } else {
//                    System.out.println("Member with Reg Num " + regNum + " was not found.");
//                }
//
//                s.nextLine(); // Consume the newline character
//                break;
//            }
//            else if (choice == 5) {
//                Scanner a = new Scanner(System.in);
//
//                System.out.println("Enter the Registration Number of the student to pay fines: ");
//                a.nextLine();
//                String regNum = a.nextLine();
//
//
//                // Check if the student is registered
//                boolean studentFound = false;
//                for (int i = 0; i < students.count; i++) {
//                    if (students.theStudents[i] != null && students.theStudents[i].getRegNum() != null && students.theStudents[i].getRegNum().equalsIgnoreCase(regNum)) {
//                        studentFound = true;
//                        break;
//                    }
//                }
//
//                if (studentFound) {
//                    int payAmount = -1;
//                    boolean validAmount = false;
//
//                    do {
//                        try {
//                            System.out.print("Enter the amount to pay: ");
//                            payAmount = Integer.parseInt(s.nextLine());
//                            validAmount = true;
//                        } catch (NumberFormatException e) {
//                            System.out.println("Invalid input. Please enter a valid number.");
//                        }
//                    } while (!validAmount);
//
//                    // Call the payFine method to handle fine payment
//                    books1.payFine(regNum, payAmount);
//                    System.out.println("Paid " + payAmount + " Rupees for Member with Reg Num " + regNum + ". Remaining fine: " + books1.getFine(regNum) + " Rupees.");
//                } else {
//                    System.out.println("Member with Reg Num " + regNum + " was not found.");
//                }
//
//                break;
//            }
            else if(choice == 5){
                Scanner a = new Scanner(System.in);

                System.out.println("Enter the Registration Number of the student to pay fines: ");
                String regNum = a.nextLine();

                Scanner f = new Scanner(System.in);

                System.out.println("enter amount: ");
                int amount = f.nextInt();
                // Call the payFine method to handle fine payment
                students.payFine(regNum, amount); // Pass 's' Scanner object to payFine
                break;
            }




        }
    }
}

