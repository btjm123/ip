package benn;

import benn.commands.*;
import benn.patterns.InputPattern;

public class Parser {
    public static Command parse(String input) {
        if (input.matches(InputPattern.ADD_ITEM)) {
            return new AddItemCommand(input);
        } else if (input.matches(InputPattern.LIST)) {
            return new ListCommand(input);
        } else if (input.matches(InputPattern.BYE)) {
            return new ExitCommand(input);
        } else {
            return new InvalidCommand(input);
        }
    }
}

