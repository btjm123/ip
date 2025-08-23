package benn.commands;

import benn.TaskManager;
import benn.exceptions.BennException;
import benn.messages.MessageManager;
import benn.patterns.InputPattern;
import benn.tasks.Task;

import java.io.IOException;
import java.util.regex.Matcher;

public class DeleteCommand extends Command {
    public DeleteCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        Matcher matcher = InputPattern.DELETE_TASK.matcher(input);
        try {
            if (matcher.find()) {
                int index = Integer.parseInt(matcher.group("index"));
                Task task = taskManager.deleteTaskAt(index);
                return MessageManager.retrieveDeletedTaskMessageFrom(task, taskManager);
            } else {
                throw new BennException("Parsing error occurred");
            }
        } catch (NumberFormatException | BennException | IOException exception){
            return MessageManager.retrieveErrorMessageFrom(exception);
        }
    }
}
