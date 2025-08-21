package benn.commands;

import benn.TaskManager;
import benn.messages.MessageManager;

public class InvalidCommand extends Command {
    public InvalidCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        return MessageManager.retrieveInvalidCommandMessage();
    }
}
