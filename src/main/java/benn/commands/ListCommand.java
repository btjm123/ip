package benn.commands;

import benn.TaskManager;
import benn.tasks.Task;

public class ListCommand extends Command {
    public ListCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        return "    ____________________________________________________________\n"
                + taskManager
                + "    ____________________________________________________________";
    }
}
