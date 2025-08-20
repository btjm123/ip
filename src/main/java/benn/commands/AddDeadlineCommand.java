package benn.commands;

import benn.TaskManager;
import benn.patterns.InputPattern;
import benn.tasks.Deadline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddDeadlineCommand extends Command {
    public AddDeadlineCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        Pattern pattern = Pattern.compile(InputPattern.ADD_DEADLINE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String description = matcher.group("description");
            String dateTimeDue = matcher.group("dateTimeDue");
            Deadline deadline = taskManager.addDeadline(description, dateTimeDue);
            return "    ____________________________________________________________\n"
                    + "     Got it. I've added this task:\n"
                    + "       " + deadline.toString() + "\n"
                    + "     Now you have " + taskManager.size() + " tasks in the list.\n"
                    + "    ____________________________________________________________";
        } else {
            return "    ____________________________________________________________\n" +
                    "   parsing error occurred"  + "\n" +
                    "    ____________________________________________________________";
        }
    }
}

