package edu.miracosta.cs112.aort;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int quotes = 0;
        double price, average, lowest=Double.MAX_VALUE, highest=Double.MIN_VALUE,total = 0;
        //Max value since zero would be lowest value
        //min value for opposite reason
        try {

            Scanner file = new Scanner(new File("bitcoin_prices_full.txt"));
            if (file.hasNextLine())
            file.nextLine();
            //Getting rid of "Weighted price" header
            // to read through a file, use a while loop
             while(file.hasNextDouble())
             {
                //Read price from file
                 price = file.nextDouble();
                 ///add price to total
                 total+= price;
                 //Make number of quotes go  up
                 quotes++;
                //Determine if price is lowest
                 if(price < lowest)
                     lowest = price;
                 //Determine if price is highest
                 if(price>highest)
                     highest = price;

             }
             //After while loop (DONE with file)
            //Be sure to close file
            file.close();
             //After reading all prices, calculate average
             average = total/quotes;
             NumberFormat currency = NumberFormat.getCurrencyInstance();
            System.out.println("number of price quotes is " + quotes);
            System.out.println("The average price is "+ currency.format(average));
            System.out.println("The highest price is " +currency.format(highest));
            System.out.println("The lowest price is " + currency.format(lowest));
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found");
        }
    }
}
