package benn.commands;

import benn.tasks.TaskManager;
import benn.messages.MessageManager;

public class ExitCommand extends Command {
    public ExitCommand(String input) {
        this.input = input;
        this.shouldExit = true;
    }

    @Override
    public String execute(TaskManager taskManager) {
        return MessageManager.retrieveByeMessage();
    }
}
