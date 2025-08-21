package benn;

import benn.commands.*;
import benn.patterns.InputPattern;

import java.util.regex.Matcher;

public class Parser {
    public static Command parse(String input) {
        if (InputPattern.ADD_TODO.matcher(input).matches()) {
            return new AddTodoCommand(input);
        } else if (InputPattern.ADD_DEADLINE.matcher(input).matches()) {
            return new AddDeadlineCommand(input);
        } else if (InputPattern.ADD_EVENT.matcher(input).matches()) {
            return new AddEventCommand(input);
        } else if (InputPattern.LIST.matcher(input).matches()) {
            return new ListCommand(input);
        } else if (InputPattern.MARK_TASK.matcher(input).matches()) {
            return new MarkCommand(input);
        } else if (InputPattern.UNMARK_TASK.matcher(input).matches()) {
            return new UnmarkCommand(input);
        } else if (InputPattern.BYE.matcher(input).matches()) {
            return new ExitCommand(input);
        } else {
            return new InvalidCommand(input);
        }
    }
}

