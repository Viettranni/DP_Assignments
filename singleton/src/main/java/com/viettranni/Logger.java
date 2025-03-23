package com.viettranni;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Logger {
    private static Logger logger;
    private BufferedWriter writer;
    private String fileName;

    // Constructor, private makes sure that it alligns with singleton and is the same everywhere
    private Logger() {
        this.fileName = "default_logger.txt";
        try {
            // Creates the file which to write to
            writer = new BufferedWriter(new FileWriter(this.fileName, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Returns the same instance across the application
    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    // Creating a new file or selecting the file according to the file name if it's not existing 
    public void setFileName(String fileName) {
        try {
            if (writer != null) {
                // Closing the current file if it's not null
                writer.close(); 
            }
            this.fileName = fileName;
            // Creating a new file
            writer = new BufferedWriter(new FileWriter(this.fileName, true)); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Writing the message to the file
    public void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Closing the writer
    public void close() {
        try {
            if (writer != null) {
                writer.close(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

