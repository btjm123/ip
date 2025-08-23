package benn;

import benn.commands.Command;
import benn.exceptions.BennException;
import benn.messages.MessageManager;

import java.io.IOException;
import java.util.Scanner;

public class Benn {
    public static void main(String[] args) {
        System.out.println(MessageManager.retrieveIntroductionMessage());
        Scanner scanner = new Scanner(System.in);
        try {
            TaskManager taskManager = new TaskManager();
            boolean shouldExit = false;

            while (!shouldExit && scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();

                Command command = Parser.parse(input);
                String output = command.execute(taskManager);
                System.out.println(output);

                shouldExit = command.shouldExit();
            }
        } catch (BennException | IOException exception) {
            System.out.println(MessageManager.retrieveErrorMessageFrom(exception));
        }
        scanner.close();
    }
}
