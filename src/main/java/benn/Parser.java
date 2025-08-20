package benn;

import benn.commands.*;
import benn.patterns.InputPattern;

public class Parser {
    public static Command parse(String input) {
        if (input.matches(InputPattern.ADD_TODO)) {
            return new AddTodoCommand(input);
        } else if (input.matches(InputPattern.ADD_DEADLINE)) {
            return new AddDeadlineCommand(input);
        } else if (input.matches(InputPattern.ADD_EVENT)) {
            return new AddEventCommand(input);
        } else if (input.matches(InputPattern.LIST)) {
            return new ListCommand(input);
        } else if (input.matches(InputPattern.MARK_TASK)) {
            return new MarkCommand(input);
        } else if (input.matches(InputPattern.UNMARK_TASK)) {
            return new UnmarkCommand(input);
        } else if (input.matches(InputPattern.BYE)) {
            return new ExitCommand(input);
        } else {
            return new InvalidCommand(input);
        }
    }
}

