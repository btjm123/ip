package benn;

import benn.commands.Command;
import benn.messages.MessageManager;

import java.util.Scanner;

public class Benn {
    public static void main(String[] args) {
        System.out.println(MessageManager.retrieveIntroductionMessage());
        Scanner sc = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean shouldExit = false;

        while (!shouldExit && sc.hasNextLine()) {
            String input = sc.nextLine().trim();

            Command command = Parser.parse(input);
            String output = command.execute(taskManager);
            System.out.println(output);

            shouldExit = command.shouldExit();
        }

        sc.close();
    }
}
