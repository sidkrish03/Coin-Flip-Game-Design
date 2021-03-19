package com.java.test.misc.parkinglot.commands;

import com.java.design.misc.parkinglot.OutputPrinter;
import com.java.design.misc.parkinglot.commands.ExitCommandExecutor;
import com.java.design.misc.parkinglot.model.Command;
import com.java.design.misc.parkinglot.service.ParkingLotService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExitCommandExecutorTest {
    private ParkingLotService parkingLotService;
    private OutputPrinter outputPrinter;
    private ExitCommandExecutor exitCommandExecutor;

    @Before
    public void setUp() throws Exception {
        parkingLotService = mock(ParkingLotService.class);
        outputPrinter = mock(OutputPrinter.class);
        exitCommandExecutor = new ExitCommandExecutor(parkingLotService, outputPrinter);
    }

    @Test
    public void testValidCommand() {
        assertTrue(exitCommandExecutor.validate(new Command("exit")));
    }

    @Test
    public void testInvalidCommand() {
        assertFalse(exitCommandExecutor.validate(new Command("exit 1")));
        assertFalse(exitCommandExecutor.validate(new Command("exit 1 2")));
        assertFalse(exitCommandExecutor.validate(new Command("exit a")));
    }

    @Test
    public void textCommandExecution() {
        exitCommandExecutor.execute(new Command("exit"));
        verify(outputPrinter).end();
    }
}
