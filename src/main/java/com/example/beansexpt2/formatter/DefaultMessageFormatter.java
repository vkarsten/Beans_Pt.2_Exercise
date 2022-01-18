package com.example.beansexpt2.formatter;

public class DefaultMessageFormatter implements MessageFormatter {
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";


    @Override
    public String format(String message) {
        return String.format(
                "%sThe message is: [%s%s%s].%s",
                ANSI_PURPLE, ANSI_YELLOW, message, ANSI_PURPLE, ANSI_RESET);
    }
}
