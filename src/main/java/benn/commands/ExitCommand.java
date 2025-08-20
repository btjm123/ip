package benn.commands;

import benn.TaskManager;

public class ExitCommand extends Command {
    public ExitCommand(String input) {
        this.input = input;
        this.shouldExit = true;
    }

    @Override
    public String execute(TaskManager taskManager) {
        return "    ____________________________________________________________\n" +
                "     bye, hope to see you soon!\n" +
                "    ____________________________________________________________";
    }
}
