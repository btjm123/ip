package benn.commands;

import benn.TaskManager;
import benn.patterns.InputPattern;
import benn.tasks.Todo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddTodoCommand extends Command {
    public AddTodoCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        Pattern pattern = Pattern.compile(InputPattern.ADD_TODO);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String description = matcher.group("description");
            Todo todo = taskManager.addTodo(description);
            return "    ____________________________________________________________\n"
                    + "     Got it. I've added this task:\n"
                    + "       " + todo.toString() + "\n"
                    + "     Now you have " + taskManager.size() + " tasks in the list.\n"
                    + "    ____________________________________________________________";
        } else {
            return "    ____________________________________________________________\n" +
                    "   parsing error occurred"  + "\n" +
                    "    ____________________________________________________________";
        }
    }
}
