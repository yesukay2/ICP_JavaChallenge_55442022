package com.company;

//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.Serializable;
//import java.util.Scanner;
//
//public class Main {
//
//    public void writingTextToFile() {
//
//        PrintWriter printWriter = null;
//
//        try {
//            //Note that we are able to append to the file because of the "true" parameter
//            printWriter = new PrintWriter(new FileOutputStream("fileName1.txt", true));
//        }catch(FileNotFoundException fnfe) {
//            fnfe.getMessage();
//        }
//
//        printWriter.print("Some String");
//        printWriter.println();
//
//        //Note the use of "printf()"
//        printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
//        printWriter.println();
//
//        //Close Writer
//        printWriter.close();
//    }
//
//
//    public static void main(String[] args) {
//
//
//
//    }
//}

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import java.util.Scanner;
import java.io.File;
public class Main{

    private static int quantity;
    private static String item;
    private static float price;


    public Main(String item, int quantity, float price) {


        // TODO Auto-generated constructor stub
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public static String getItem() {
        return item;
    }

    //this function returns the int value of parameter quantity.
    public static int getQuantity() {
        return quantity;
    }

    //this function returns the float value of parameter price.
    public static float getPrice() {
        return price;
    }





    public static void Do() throws FileNotFoundException {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter the item in the stock: ");
        String item = stdin.next();
        System.out.println("Enter the quantity: ");
        int quant = stdin.nextInt();
        System.out.println("Enter the price: ");
        float price = stdin.nextFloat();

        Main store = new Main(item, quant, price);
        PrintWriter printWriter= null;


        try{
            printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));


            printWriter.println(getItem() + " " + getQuantity() + " " + getPrice());
            printWriter.println();
            printWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        try{
        printWriter = new PrintWriter(new FileOutputStream("backup_essentials_stock.txt", true));

            printWriter.println(getItem() + " " + getQuantity() + " " + getPrice());
            printWriter.println();
            printWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }


    public static int Cont() throws FileNotFoundException {
        System.out.println("Essentials Inventory Stock" + "\n Is there another item on the list" + "\n1.Yes" + "\n2.No");
        Scanner log = new Scanner(System.in);
        int logs = log.nextInt();
        while (true) {
            if (logs == 1 || logs == 2) {
                break;
            } else {
                System.out.println("Option not available");
                System.out.println("Essentials Inventory Stock" + "\n Is there another item on the list" + "\n1.Yes" + "\n2.No)");
                logs = log.nextInt();
            }
        }
        if (logs == 1) {
            Do();
            Cont();
        }
        else if (logs == 2) {
            System.out.println("Ending inventory....................");

        }
        return logs;
    }


    public static void main(String[] args) throws FileNotFoundException {


        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter the first item in the stock: ");
        String item = stdin.next();
        System.out.println("Enter the quantity: ");
        int quant = stdin.nextInt();
        System.out.println("Enter the price: ");
        float price = stdin.nextFloat();

        Main stock= new Main(item, quant, price );
PrintWriter printWriter=null;

        try{
            printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));


            printWriter.println(getItem() + " " + getQuantity() + " " + getPrice());
            printWriter.println();
            printWriter.close();
            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        try{
            printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));

            printWriter.println(getItem() + " " + getQuantity() + " " + getPrice());
            printWriter.println();
            printWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }


        Cont();
    }
}
