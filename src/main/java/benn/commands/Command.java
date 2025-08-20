package benn.commands;

public abstract class Command {
    protected boolean shouldExit;
    protected String input;

    public abstract String execute();

    public boolean shouldExit() {
        return shouldExit;
    }
}
