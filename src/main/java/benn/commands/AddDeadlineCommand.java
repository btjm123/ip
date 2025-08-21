package benn.commands;

import benn.TaskManager;
import benn.exceptions.DukeException;
import benn.messages.MessageManager;
import benn.patterns.InputPattern;
import benn.tasks.Deadline;

import java.util.regex.Matcher;

public class AddDeadlineCommand extends Command {
    public AddDeadlineCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        Matcher matcher = InputPattern.ADD_DEADLINE.matcher(input);
        try {
            if (matcher.find()) {
                String description = matcher.group("description");
                String dateTimeDue = matcher.group("dateTimeDue");
                Deadline deadline = taskManager.addDeadline(description, dateTimeDue);
                return MessageManager.retrieveTaskMessageFrom(deadline, taskManager);
            } else {
                throw new DukeException("Parsing error occurred");
            }
        } catch (DukeException exception) {
            return MessageManager.retrieveErrorMessageFrom(exception);
        }
    }
}

