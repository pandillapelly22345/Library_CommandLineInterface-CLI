package Assinment1Lib;

import java.util.Scanner;

public class Librarian1 {
    static void menu() {
        Scanner s = new Scanner(System.in);
        int choice = -1;
        students stdManager = new students();

        while (choice != 0) {
            System.out.println("--------------------------");
            System.out.println("\nLibrarian Menu:");
            System.out.println("1. Register a member");
            System.out.println("2. Remove a member");
            System.out.println("3. Add a book");
            System.out.println("4. Remove a book");
            System.out.println("5. View all members along with their books and fines to be paid");
            System.out.println("6. View all books");
            System.out.println("0. Exit librarian Menu");
            System.out.println("--------------------------");
            choice = s.nextInt();

            if(choice == 1){
                students obStudent = new students();
                student j = new student();
                String p = new String();
                obStudent.addStudent(j,p);
                break;
            }
            else if(choice == 2){

                students studentManager = new students();
                System.out.println("Enter the student's registration number to remove:");
                s.nextLine();
                String regNumToRemove = s.nextLine();
                studentManager.removeStudentByID(regNumToRemove);
                break;
            }
            else if(choice == 3){
                book1 newBook = new book1();
                books1.addBook(newBook);
                break;
            }
            else if(choice == 4){
                System.out.println("Enter the Serial No of the book to remove:");
                int bookIdToRemove = s.nextInt();
                books1.removeBook(bookIdToRemove);
            }
            else if(choice == 5){
                students.ShowStudents();
            }
            else if(choice == 6){
                books1.viewAllBooks();
            }
//        for (;;) {
//            System.out.println("\nLibrarian Menu:");
//            System.out.println("1. Register a member");
//            System.out.println("2. Remove a member");
//            System.out.println("3. Add a book");
//            System.out.println("4. Remove a book");
//            System.out.println("5. View all members along with their books and fines to be paid");
//            System.out.println("6. View all books");
//            System.out.println("0. Exit librarian Menu");
//            choice = s.nextInt();
//    }
        }
    }
}
