package benn;

import benn.exceptions.BennException;
import benn.messages.MessageManager;
import benn.tasks.TaskManager;
import benn.ui.Ui;

import java.io.IOException;

/**
 * The entry point for Benn the Chatbot.
 *
 * <p>The {@code Benn} class initializes the chatbot by creating the
 * {@link benn.ui.Ui} for user interaction and the {@link benn.tasks.TaskManager}
 * for managing tasks. It then runs the chatbot loop until the user exits.</p>
 *
 * <p>If any {@link benn.exceptions.BennException} or {@link java.io.IOException}
 * occurs during initialization or execution, an error message is displayed
 * to the user via {@link benn.messages.MessageManager}.</p>
 */
public class Benn {

    /**
     * Launches the chatbot application.
     *
     * <p>Steps performed:</p>
     * <ol>
     *     <li>Create a {@link benn.ui.Ui} instance to handle input/output</li>
     *     <li>Create a {@link benn.tasks.TaskManager} to manage tasks</li>
     *     <li>Run the chatbot main loop</li>
     *     <li>Gracefully handle exceptions by displaying user-friendly error messages</li>
     * </ol>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        try (Ui ui = new Ui()) {
            TaskManager taskManager = new TaskManager();
            ui.run(taskManager);
        } catch (BennException | IOException e) {
            System.out.println(MessageManager.retrieveErrorMessageFrom(e));
        }
    }
}

