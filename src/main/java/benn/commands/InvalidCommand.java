package benn.commands;

import benn.TaskManager;

public class InvalidCommand extends Command {
    public InvalidCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        return "    ____________________________________________________________\n" +
                "     invalid command, please try again!\n" +
                "    ____________________________________________________________";
    }
}
