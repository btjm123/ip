package benn;

import benn.commands.*;

public class Parser {
    public static Command parse(String input) {
        if (input.equals("add")) {
            return new AddItemCommand(input);
        } else if (input.equals("list")) {
            return new ListCommand(input);
        } else if (input.equals("bye")) {
            return new ExitCommand(input);
        } else {
            return new InvalidCommand(input);
        }
    }
}
