package com.java.design.misc.parkinglot;

/**
 * Printer to help in printing the output back to the user. Output medium can be changed here anytime without
 * affecting any of the other code. Currently, System.out is used. Tomorrow if the file has to be used to output, it
 * can be changed here easily.
 */

public class OutputPrinter {
    public void welcome() {
        printWithNewLine("Welcome to Prime Heights Parking Lot");
    }

    public void end() {
        printWithNewLine("Thanks for using Prime Heights Parking Lot Service");
    }

    public void notFound() {
        printWithNewLine("Not Found");
    }

    public void statusHeader() {
        printWithNewLine("Slot No.      Registration No.      Color");
    }

    public void parkingLotFull() {
        printWithNewLine("Sorry, parking lot is full");
    }

    public void parkingLotEmpty() {
        printWithNewLine("Parking lot is empty");
    }

    public void invalidFile() {
        printWithNewLine("Invalid file given.");
    }

    public void printWithNewLine(final String message) {
        System.out.println(message);
    }
}
