package benn.commands;

import benn.TaskManager;
import benn.patterns.InputPattern;
import benn.tasks.Task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnmarkCommand extends Command{
    public UnmarkCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        Pattern pattern = Pattern.compile(InputPattern.UNMARK_TASK);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            int index = Integer.parseInt(matcher.group("index"));
            Task task = taskManager.unmark(index);
            return "    ____________________________________________________________\n"
                    + "     Nice! I've unmarked this task as done:\n"
                    + "       " + task + "\n"
                    + "    ____________________________________________________________";
        } else {
            return "    ____________________________________________________________\n" +
                    "   parsing error occurred"  + "\n" +
                    "    ____________________________________________________________";
        }
    }
}