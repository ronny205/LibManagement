package com.ronnie.college;

import java.util.Scanner;

public class StudentOperations {

    Scanner input = new Scanner(System.in);
    Student theStudents[] = new Student[50];

    public static int count = 0;

    public void addStudent(Student student){

        for (int i = 0; i < count; i++){

            if(student.regNum.equalsIgnoreCase(theStudents[i].regNum)) {
                System.out.println("Student of Reg Num " + student.regNum + " is Already Registered.");
                return;
            }
        }

        if(count <= 50){
            theStudents[count] = student;
            count++;
        }
    }

    public void showAllStudents(){

        System.out.println("Student Name\t\tReg Number");
        for ( int i = 0; i < count; i++){
            System.out.println(
                theStudents[i].studentName
                + "\t\t"
                + theStudents[i].regNum);
        }
    }

    public int isStudent(){

        System.out.println("Enter Reg Number: ");
        String regNum = input.nextLine();

        for ( int i = 0; i < count; i++) {
            if(theStudents[i].regNum.equalsIgnoreCase(regNum)){
                return i;
            }
        }
        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");
        return -1;
    }

    public void checkOutBook(BookOperations Book){
        int studentIndex = this.isStudent();

        if(studentIndex != -1 ) {
            System.out.println("Checking Out.");

            Book.showAllBooks();
            Book book = Book.checkOutBook();

            System.out.println("Checking Out.");
            if(book != null) {
                if ( theStudents[studentIndex].booksCount <= 3) {

                    System.out.println("Adding Book.");
                    theStudents[studentIndex].borrowBooks[theStudents[studentIndex].booksCount] = book ;
                    theStudents[studentIndex].booksCount++;

                    return;
                } else {
                    System.out.println("Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }
    
    public void chekInBook (BookOperations book) {
        int studentIndex = this.isStudent();
        if(studentIndex != -1) {
            System.out.println("S.No\t\tBook Name\t\tAuthor Name");

            Student student = theStudents[studentIndex];

            for ( int i = 0; i < student.booksCount; i++){
                System.out.println(
                    student.borrowBooks[i].sNo + "\t\t\t" 
                    + student.borrowBooks[i].bookName + "\t\t\t"
                    + student.borrowBooks[i].authorName
                );
            }
            System.out.println("Enter Serial Number of Book to be Checked In:");

            int sNo = input.nextInt();

            for ( int i = 0; i < student.booksCount; i++) {
                if (sNo == student.borrowBooks[i].sNo) {
                    Book.checkInBook(student.borrowBooks[i]);
                    student.borrowBooks[i] = null;

                    return;
                }
            }

            System.out.println("Book of Serial No " + sNo + " not Found");
        }
    }
}
