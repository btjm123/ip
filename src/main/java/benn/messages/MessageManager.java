package benn.messages;

import benn.TaskManager;
import benn.tasks.Task;

public class MessageManager {
    public static String retrieveIntroductionMessage() {
        String logo =
                " ____                      _  _  _ \n" +
                        "| __ )  ___ _ __  _ __   _| || || |\n" +
                        "|  _ \\ / _ \\ '_ \\| '_ \\ / _` || || |\n" +
                        "| |_) |  __/ | | | | | | (_| || || |\n" +
                        "|____/ \\___|_| |_|_| |_|\\__,_||_||_|\n";

        return logo
                + "____________________________________________________________\n"
                + " Hello! I'm BENN\n"
                + " What can I do for you?\n"
                + "____________________________________________________________";
    }

    public static String retrieveTaskMessageFrom(Task task, TaskManager taskManager) {
        return "    ____________________________________________________________\n"
                + "     Got it. I've added this task:\n"
                + "       " + task + "\n"
                + "     Now you have " + taskManager.size() + " tasks in the list.\n"
                + "    ____________________________________________________________";
    }
    
    public static String retrieveListMessageFrom(TaskManager taskManager) {
        return "    ____________________________________________________________\n"
                + taskManager
                + "    ____________________________________________________________";
    }

    public static String retrieveByeMessage() {
        return "    ____________________________________________________________\n" +
                "     bye, hope to see you soon!\n" +
                "    ____________________________________________________________";
    }

    public static String retrieveInvalidCommandMessage() {
        return "    ____________________________________________________________\n" +
                "     invalid command, please try again!\n" +
                "    ____________________________________________________________";
    }

    public static String retrieveMarkTaskAsDoneMessageFrom(Task task) {
        return "    ____________________________________________________________\n"
                + "     Nice! I've marked this task as done:\n"
                + "       " + task + "\n"
                + "    ____________________________________________________________";
    }

    public static String retrieveUnmarkTaskAsDoneMessageFrom(Task task) {
        return "    ____________________________________________________________\n"
                + "     Nice! I've unmarked this task as done:\n"
                + "       " + task + "\n"
                + "    ____________________________________________________________";
    }

    public static String retrieveDeletedTaskMessageFrom(Task task, TaskManager taskManager) {
        return "    ____________________________________________________________\n"
                + "     Noted. I've removed this task:\n"
                + "       " + task + "\n"
                + "     Now you have " + taskManager.size() + " tasks in the list.\n"
                + "    ____________________________________________________________";
    }

    public static String retrieveErrorMessageFrom(Exception exception) {
        return "    ____________________________________________________________\n" +
                exception.getMessage() + "\n" +
                "    ____________________________________________________________";
    }
}
