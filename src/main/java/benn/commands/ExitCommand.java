package benn.commands;

public class ExitCommand extends Command {
    public ExitCommand(String input) {
        this.input = input;
        this.shouldExit = true;
    }

    @Override
    public String execute() {
        String output =
                "    ____________________________________________________________\n" +
                        "     bye, hope to see you soon!\n" +
                        "    ____________________________________________________________";
        return output;
    }
}
