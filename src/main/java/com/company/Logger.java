package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String logFileName = "simulation.log";
    private static FileWriter writer;

    static {
        try {
            writer = new FileWriter(logFileName, true);
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    public static synchronized void log(String message) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(timestamp + " - " + message + System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }

    public static void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing logger: " + e.getMessage());
        }
    }
}