package benn;

import benn.commands.Command;
import benn.exceptions.BennException;
import benn.messages.MessageManager;
import benn.ui.Ui;

import java.io.IOException;

public class Benn {
    public static void main(String[] args) {
        try (Ui ui = new Ui()) {
            TaskManager taskManager = new TaskManager();
            ui.run(taskManager);
        } catch (BennException | IOException e) {
            System.out.println(MessageManager.retrieveErrorMessageFrom(e));
        }
    }
}

