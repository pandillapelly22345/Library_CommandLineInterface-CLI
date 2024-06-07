package Assinment1Lib;

import java.util.Scanner;

public class student {
    private String libName;
    private static String regNum;
    private String phoneNumber;
    private int fine;



    Scanner input = new Scanner(System.in);

    public student(String regNum, String name) {

    }

//    public static int getHasFine() {
//        return hasfine;
//    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public student() {
        System.out.println("Enter Student Name:");
        this.libName = input.nextLine();

        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();

        System.out.println("Enter Phone Number");
        this.phoneNumber = input.nextLine();
//        this.hasfine=0;
        this.fine = 0;

    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fineDue) {
        this.fine = fineDue;
    }

    public String getLibName() {
        return libName;
    }

//    public int getHasfine() {
//        return hasfine;
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getRegNum() {
        return regNum;
    }


//    public void hasFine(){
//        hasfine=1;
//    }
//    public void noFine(){
//        hasfine=0;
//
//    }
}

