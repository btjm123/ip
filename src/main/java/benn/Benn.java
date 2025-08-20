package benn;

import benn.commands.Command;

import java.util.Scanner;

public class Benn {
    public static void main(String[] args) {
        String logo =
                " ____                      _  _  _ \n" +
                        "| __ )  ___ _ __  _ __   _| || || |\n" +
                        "|  _ \\ / _ \\ '_ \\| '_ \\ / _` || || |\n" +
                        "| |_) |  __/ | | | | | | (_| || || |\n" +
                        "|____/ \\___|_| |_|_| |_|\\__,_||_||_|\n";

        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm BENN");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

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
