package Assinment1Lib;

import java.util.Scanner;

import static Assinment1Lib.books1.issuedBooks;

public class students {
    Scanner input = new Scanner(System.in);
    static student[] theStudents = new student[50];
    static String[] phoneNumbers = new String[50];
    static int[] fines = new int[50];

    public static int count = 0;

    // Method 1
    // add new librarian
    public void addStudent(student s,String phoneNumber) {
        if (s == null || s.getRegNum() == null || s.getLibName() == null || phoneNumber == null) {
            System.out.println("Invalid Member or registration number.");
            return;
        }

        for (int i = 0; i < count; i++) {

            if (theStudents[i] != null && theStudents[i].getRegNum() != null &&
                    s.getRegNum().equalsIgnoreCase(theStudents[i].getRegNum())) {
                System.out.println("Member of Reg Num " + s.getRegNum() + " is Already Registered.");
                return;
            }
        }

        if (count < 50) {
            theStudents[count] = s;
            phoneNumbers[count] = phoneNumber;
            fines[count] = 0;
            count++;
        }
    }

    public void removeStudentByID(String regNum) {
        int studentIndex = -1;

        for (int i = 0; i < count; i++) {
            if (theStudents[i].getRegNum().equalsIgnoreCase(regNum)) {
                studentIndex = i;
                continue;
            }
        }

        if (studentIndex != -1) {
            // Remove the student by shifting array elements
            for (int i = studentIndex; i < count - 1; i++) {
                theStudents[i] = theStudents[i + 1];
            }
            count--;

            System.out.println("Member removed successfully.");
        } else {
            System.out.println("Member with given ID not found.");
        }
    }

    public static void ShowStudents() {
        if (count == 0) {
            System.out.println("No Members are registered yet.");
            return;
        }
        System.out.println("Member Name\t\tReg Number\t\tPhone Number\t\tIssued books\t\tFines");
        for (int i = 0; i < count; i++) {
            System.out.print(theStudents[i].getLibName() + "\t\t" + theStudents[i].getRegNum() + "\t\t" + theStudents[i].getPhoneNumber() + "\t\t");

            // Check if there is an issued book and get its title
            if (issuedBooks[i] != null) {
                System.out.print(issuedBooks[i].getTitle() + "\t\t");
            } else {
                System.out.print("N/A\t\t");
            }

            // Check and display the fine associated with the student
            System.out.println((fines[i]*3) + " Rupees");
        }
    }

    public boolean isStudentRegistered(String name, String phoneNumber) {
        for (int i = 0; i < count; i++) {
            if (theStudents[i] != null && theStudents[i].getLibName() != null &&
                    phoneNumbers[i] != null && theStudents[i].getLibName().equals(name) &&
                    theStudents[i].getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public static void payFine(String regNum, int amount) {
        // Check if the student with the provided registration number exists
        int studentIndex = -1;
        for (int i = 0; i < students.count; i++) {
            if (students.theStudents[i] != null && students.theStudents[i].getRegNum() != null && students.theStudents[i].getRegNum().equalsIgnoreCase(regNum)) {
                studentIndex = i;
                break;
            }
        }

        if (studentIndex != -1) {
            // Get the current fine amount for the student
            int currentFine = students.fines[studentIndex];

            if (currentFine > 0 && amount > 0) {
                // Calculate the new fine amount after payment
                int newFine = currentFine - amount;

                if (newFine > 0) {

                    students.fines[studentIndex] = newFine;
                    System.out.println("Paid " + amount + " Rupees for Member with Reg Num " + regNum + ". Remaining fine: " + newFine + " Rupees.");
                } else if (newFine == 0) {
                    // Full fine has been paid
                    students.fines[studentIndex] = 0;
                    System.out.println("Paid " + amount + " Rupees for Member with Reg Num " + regNum + ". Full fine has been paid.");
                } else {

                    students.fines[studentIndex] = 0;
                    int extraAmount = Math.abs(newFine);
                    System.out.println("Paid " + amount + " Rupees for Member with Reg Num " + regNum + ". Full fine has been paid. Overpaid amount: " + extraAmount + " Rupees.");
                }
            } else {
                System.out.println("Invalid payment amount or no outstanding fine for Member with Reg Num " + regNum + ".");
            }
        } else {
            System.out.println("Member with Reg Num " + regNum + " was not found.");
        }
    }



}
