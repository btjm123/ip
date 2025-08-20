package benn.commands;

public class AddItemCommand extends Command {
    public AddItemCommand(String input) {
        this.input = input;
        this.shouldExit = false;
    }

    @Override
    public String execute() {
        String output =
                "    ____________________________________________________________\n" +
                        "     add\n" +
                        "    ____________________________________________________________";
        return output;
    }
}

