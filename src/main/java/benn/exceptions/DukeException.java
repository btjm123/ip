package benn.exceptions;

public class DukeException extends Exception {
    public DukeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return String.format("%s Error raised with Benn the Chatbot; please try again!", super.getMessage());
    }
}
