package com.java.design.misc.parkinglot.mode;

import com.java.design.misc.parkinglot.OutputPrinter;
import com.java.design.misc.parkinglot.commands.CommandExecutorFactory;
import com.java.design.misc.parkinglot.model.Command;
import com.java.io.BufferedReader;
import com.java.io.File;
import com.java.io.FileNotFoundException;
import com.java.io.FileReader;
import com.java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Mode running in which input commands are given from a file.
 */
public class FileMode extends Mode{
    private String fileName;

    public FileMode(final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter,
        final String fileName) {
        super(commandExecutorFactory, outputPrinter);
        this.fileName = fileName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void process() throws IOException {
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch(FileNotFoundException e) {
            outputPrinter.invalidFile();
            return;
        }

        String input = reader.readLine();
        while(input != null) {
            final Command command = new Command(input);
            processCommand(command);
            input = reader.readLine();
        }
    }
}
