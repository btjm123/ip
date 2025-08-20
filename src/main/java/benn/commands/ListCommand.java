package benn.commands;

public class ListCommand extends Command {
    public ListCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute() {
        String output =
                "    ____________________________________________________________\n" +
                "     list\n" +
                "    ____________________________________________________________";
        return output;
    }
}
