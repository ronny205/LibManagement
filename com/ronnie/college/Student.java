package com.ronnie.college;

import java.util.Scanner;

public class Student {

    String studentName;
    String regNum;

    Book borrowBooks[] = new Book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);

    public Student() {
        System.out.println("Enter student name: ");
        this.studentName = input.nextLine();

        System.out.println("Enter Registeration Number: ");
        this.regNum = input.nextLine();
    }
    
}
