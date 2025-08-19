package com.ronnie.college;

import java.util.Scanner;

public class Book {
    
    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;

    // read input 
    Scanner input = new Scanner(System.in);

    //Constructor to add Books
    public Book(){
        
        System.out.println("Enter Serial No of Book");

        this.sNo = input.nextInt();
        input.nextInt();

        System.out.println("Enter Book Name:");
        this.authorName = input.nextLine();

        System.out.println("Enter Quantity of Books");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;

    }

    public static void checkInBook(Book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkInBook'");
    }
}
