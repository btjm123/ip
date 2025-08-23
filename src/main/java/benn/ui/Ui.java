package benn.ui;

import benn.Parser;
import benn.TaskManager;
import benn.commands.Command;
import benn.exceptions.BennException;
import benn.messages.MessageManager;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class Ui implements Closeable {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    private void showIntro() {
        System.out.println(MessageManager.retrieveIntroductionMessage());
    }

    private String readLine() {
        return scanner.hasNextLine() ? scanner.nextLine().trim() : null;
    }

    private void println(String s) {
        System.out.println(s);
    }

    public void run(TaskManager taskManager) throws BennException, IOException {
        showIntro();

        boolean shouldExit = false;
        while (!shouldExit) {
            String input = readLine();
            if (input == null) break;
            Command command = Parser.parse(input);
            String output = command.execute(taskManager);
            println(output);
            shouldExit = command.shouldExit();
        }
    }

    @Override
    public void close() {
        scanner.close();
    }
}

