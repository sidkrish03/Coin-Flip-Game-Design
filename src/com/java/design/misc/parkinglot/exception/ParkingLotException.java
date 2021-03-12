package com.java.design.misc.parkinglot.exception;

/**
 * Generic exception for general parking lot exceptions.
 */
public class ParkingLotException extends Throwable {
    public ParkingLotException() {
    }

    public ParkingLotException(String message) {
        super(message);
    }
}
