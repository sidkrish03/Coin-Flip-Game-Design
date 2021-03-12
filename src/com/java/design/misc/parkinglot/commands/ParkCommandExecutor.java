package com.java.design.misc.parkinglot.commands;

import com.java.design.misc.parkinglot.OutputPrinter;
import com.java.design.misc.parkinglot.model.Command;
import com.java.design.misc.parkinglot.model.Car;
import com.java.design.misc.parkinglot.exception.NoFreeSlotAvailableException;
import com.java.design.misc.parkinglot.service.ParkingLotService;

/**
 * Executor to handle command of parking a car into the parking lot. This outputs the alloted slot in which the car
 * is parked.
 */
public class ParkCommandExecutor {
    public static String COMMAND_NAME = "park";

    public ParkingCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(final Command command) {
        return command.getParams().size() == 2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Command command) {
        final Car car = new Car(command.getParams().get(0), command.getParams().get(1));

        try {
            final Integer slot = parkingLotService.park(car);
            outputPrinter.printWithNewLine("Allocated slot number: " + slot);
        } catch(NoFreeSlotAvailableException exception) {
            output.Printer.parkingLotFull();
        }
    }
}
