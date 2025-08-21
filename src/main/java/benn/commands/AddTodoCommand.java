package benn.commands;

import benn.TaskManager;
import benn.exceptions.DukeException;
import benn.messages.MessageManager;
import benn.patterns.InputPattern;
import benn.tasks.Todo;

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
                throw new DukeException("Parsing error occurred");
            }
        } catch (DukeException exception) {
            return MessageManager.retrieveErrorMessageFrom(exception);
        }
    }
}
