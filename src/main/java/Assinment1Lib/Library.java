package Assinment1Lib;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        students studentManager = new students();


        while (true) {
            System.out.println("--------------------------");
            System.out.println("\nOptions:");
            System.out.println("1. Enter as a librarian");
            System.out.println("2. Enter as a member");
            System.out.println("0. Exit");
            System.out.println("--------------------------");
            int choice = s.nextInt();

            if(choice == 0){
                System.out.println("Thanks for visiting!");
                System.exit(0);
            }
            else if(choice == 1){
                Librarian1.menu();
            }
            else if(choice == 2){
                System.out.println("--------------------------");
                s.nextLine();  // Clear the newline left in the buffer
                System.out.println("Enter your name:");
                String name = s.nextLine();
                System.out.println("Enter your phone number:");
                String phoneNumber = s.nextLine();

                boolean isRegistered = studentManager.isStudentRegistered(name, phoneNumber);
                if (isRegistered) {
                    System.out.println("Welcome, " + name + "Member Id:"+ student.getRegNum());
                    Member1.menu();
                } else {
                    System.out.println("Member with name: "+ name + "and Phone No: "+ phoneNumber + "dosen't exist.");
                }
                System.out.println("--------------------------");
            }
        }
    }
}
