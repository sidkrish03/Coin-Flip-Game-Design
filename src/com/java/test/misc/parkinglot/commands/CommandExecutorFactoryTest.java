package com.java.test.misc.parkinglot.commands;


import com.java.design.misc.parkinglot.commands.CommandExecutor;
import com.java.design.misc.parkinglot.commands.CommandExecutorFactory;
import com.java.design.misc.parkinglot.commands.LeaveCommandExecutor;
import com.java.design.misc.parkinglot.exception.InvalidCommandException;
import com.java.design.misc.parkinglot.model.Command;
import com.java.design.misc.parkinglot.service.ParkingLotService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class CommandExecutorFactoryTest {

    private CommandExecutorFactory factory;

    @Before
    public void setUp() throws Exception {
        final ParkingLotService parkingLotService = mock(ParkingLotService.class);
        factory = new CommandExecutorFactory(parkingLotService);
    }

    @Test
    public void testFetchingExecutorForValidCommand() {
        final CommandExecutor commandExecutor = factory.getCommandExecutor(new Command("leave 1"));
        assertNotNull(commandExecutor);
        assertTrue(commandExecutor instanceof LeaveCommandExecutor);
    }

    @Test(expected = InvalidCommandException.class)
    public void testFetchingExecutorForInvalidCommand() {
        factory.getCommandExecutor(new Command("some-random-command random-param1 random-param2"));
    }
}
© 2021 GitHub, Inc.
