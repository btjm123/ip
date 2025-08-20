package benn.commands;

import benn.TaskManager;
import benn.patterns.InputPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddItemCommand extends Command {
    public AddItemCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        Pattern pattern = Pattern.compile(InputPattern.ADD_ITEM);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String description = matcher.group("description");
            taskManager.add(description);
            return "    ____________________________________________________________\n" +
                    "     added: " + description + "\n" +
                    "    ____________________________________________________________";
        } else {
            return "    ____________________________________________________________\n" +
                    "   parsing error occured"  + "\n" +
                    "    ____________________________________________________________";
        }
    }
}

