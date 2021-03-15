package com.java.design.misc.parkinglot.commands;

import com.java.design.misc.parkinglot.OutputPrinter;
import com.java.design.misc.parkinglot.model.Command;
import com.java.design.misc.parkinglot.model.ParkingLot;
import com.java.design.misc.parkinglot.model.parking.strategy.NaturalOrderingParkingStrategy;
import com.java.design.misc.parkinglot.service.ParkingLotService;
import com.java.design.misc.parkinglot.validator.IntegerValidator;
import java.util.List;

/**
 * Executor to handle command of creating the initial parking lot.
 */
public class CreateParkingLotCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(final Command command) {
        final List<String> params = command.getParams();
        if(params.size() != 1) {
            return false;
        }

        return IntegerValidator.isInteger(params.get(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
        outputPrinter.printWithNewLine("Created a Parking Lot with " + parkingLot.getCapacity() + " slots");
    }
}
