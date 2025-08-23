package benn.commands;

import benn.tasks.TaskManager;
import benn.exceptions.BennException;
import benn.messages.MessageManager;
import benn.patterns.InputPattern;
import benn.tasks.Todo;

import java.io.IOException;
import java.util.regex.Matcher;

public class AddTodoCommand extends Command {
    public AddTodoCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        Matcher matcher = InputPattern.ADD_TODO.matcher(input);
        try {
            if (matcher.find()) {
                String description = matcher.group("description");
                Todo todo = taskManager.addTodo(description);
                return MessageManager.retrieveTaskMessageFrom(todo, taskManager);
            } else {
                throw new BennException("Parsing error occurred");
            }
        } catch (BennException | IOException exception) {
            return MessageManager.retrieveErrorMessageFrom(exception);
        }
    }
}
