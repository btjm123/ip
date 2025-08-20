package benn.commands;

import benn.TaskManager;
import benn.exceptions.DukeException;
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
        try {
            int index = Integer.parseInt(matcher.group("index"));
            Task task = taskManager.unmarkAsDone(index);
            return "    ____________________________________________________________\n"
                    + "     Nice! I've unmarked this task as done:\n"
                    + "       " + task + "\n"
                    + "    ____________________________________________________________";
        } catch (NumberFormatException | DukeException exception){
            return "    ____________________________________________________________\n" +
                    exception.getMessage() + "\n" +
                    "    ____________________________________________________________";
        }
    }
}