package benn.commands;

import benn.TaskManager;
import benn.exceptions.DukeException;
import benn.messages.MessageManager;
import benn.patterns.InputPattern;
import benn.tasks.Event;

import java.io.IOException;
import java.util.regex.Matcher;

public class AddEventCommand extends Command {
    public AddEventCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        Matcher matcher = InputPattern.ADD_EVENT.matcher(input);
        try {
            if (matcher.find()) {
                String description = matcher.group("description");
                String startDateTime = matcher.group("startDateTime");
                String endDateTime = matcher.group("endDateTime");
                Event event = taskManager.addEvent(description, startDateTime, endDateTime);
                return MessageManager.retrieveTaskMessageFrom(event, taskManager);
            } else {
                throw new DukeException("Parsing error occurred");
            }
        } catch (DukeException | IOException exception) {
            return MessageManager.retrieveErrorMessageFrom(exception);
        }
    }
}
