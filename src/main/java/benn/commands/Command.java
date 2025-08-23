package benn.commands;

import benn.tasks.TaskManager;

public abstract class Command {
    protected boolean shouldExit;
    protected String input;

    public abstract String execute(TaskManager taskManager);

    public boolean shouldExit() {
        return shouldExit;
    }
}
