package com.java.design.misc.parkinglot.mode;

import com.java.design.misc.parkinglot.OutputPrinter;
import com.java.design.misc.parkinglot.commands.CommandExecutorFactory;
import com.java.design.misc.parkinglot.commands.ExitCommandExecutor;
import com.java.design.misc.parkinglot.model.Command;
import com.java.io.BufferedReader;
import com.java.io.InputStreamReader;
import com.java.io.IOException;

import java.io.BufferedReader;

/**
 * Mode running in which input commands are given from an interactive shell.
 */
public class InteractiveMode {
    public InteractiveMode(final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
        super(commandExecutorFactory, outputPrinter);
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void process() throws IOException {
        outputPrinter.welcome();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            final String input = reader.readLine();
            final Command command = new Command(input);
            processCommand(command);

            // Improvement - Can move to exit command executor instead of this hard code to kill the process
            if(command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }
}
