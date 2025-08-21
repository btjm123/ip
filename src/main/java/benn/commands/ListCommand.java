package benn.commands;

import benn.TaskManager;
import benn.messages.MessageManager;

public class ListCommand extends Command {
    public ListCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute(TaskManager taskManager) {
        return MessageManager.retrieveListMessageFrom(taskManager);
    }
}
