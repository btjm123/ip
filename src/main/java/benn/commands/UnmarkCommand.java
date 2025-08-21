package benn.commands;

import benn.TaskManager;
import benn.exceptions.DukeException;
import benn.messages.MessageManager;
import benn.patterns.InputPattern;
import benn.tasks.Task;

import java.util.regex.Matcher;

public class UnmarkCommand extends Command{
    public UnmarkCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        Matcher matcher = InputPattern.UNMARK_TASK.matcher(input);
        try {
            if (matcher.find()) {
                int index = Integer.parseInt(matcher.group("index"));
                Task task = taskManager.unmarkAsDone(index);
                return MessageManager.retrieveUnmarkTaskAsDoneMessageFrom(task);
            } else {
                throw new DukeException("Parsing error occurred");
            }
        } catch (NumberFormatException | DukeException exception){
            return MessageManager.retrieveErrorMessageFrom(exception);
        }
    }
}