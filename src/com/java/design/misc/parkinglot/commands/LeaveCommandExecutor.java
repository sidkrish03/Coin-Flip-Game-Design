package com.java.design.misc.parkinglot.commands;

import com.java.design.misc.parkinglot.OutputPrinter;
import com.java.design.misc.parkinglot.model.Command;
import com.java.design.misc.parkinglot.service.ParkingLotService;
import com.java.design.misc.parkinglot.validator.IntegerValidator;

import java.util.List;

/**
 * Executor to handle command of freeing of slot from a car.
 */

public class LeaveCommandExecutor extends CommandExecutor {
    public static final String COMMAND_NAME = "leave";

    public LeaveCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
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
        final int slotNumber = Integer.parseInt(command.getParams().get(0));
        parkingLotService.makeSlotFree(slotNumber);
        outputPrinter.printWithNewLine("Slot number " + slotNumber + " is free");
    }
}
