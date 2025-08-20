package benn.commands;

import benn.TaskManager;
import benn.patterns.InputPattern;
import benn.tasks.Event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEventCommand extends Command {
    public AddEventCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        Pattern pattern = Pattern.compile(InputPattern.ADD_EVENT);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String description = matcher.group("description");
            String startDateTime = matcher.group("startDateTime");
            String endDateTime = matcher.group("endDateTime");
            Event event = taskManager.addEvent(description, startDateTime, endDateTime);
            return "    ____________________________________________________________\n"
                    + "     Got it. I've added this task:\n"
                    + "       " + event.toString() + "\n"
                    + "     Now you have " + taskManager.size() + " tasks in the list.\n"
                    + "    ____________________________________________________________";
        } else {
            return "    ____________________________________________________________\n" +
                    "   parsing error occurred"  + "\n" +
                    "    ____________________________________________________________";
        }
    }
}
