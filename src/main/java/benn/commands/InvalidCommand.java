package benn.commands;

public class InvalidCommand extends Command {
    public InvalidCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute() {
        String output =
                "    ____________________________________________________________\n" +
                        "     invalid command, please try again!\n" +
                        "    ____________________________________________________________";
        return output;
    }
}
