package benn.exceptions;

public class BennException extends Exception {
    public BennException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return String.format("%s Error raised with Benn the Chatbot; please try again!", super.getMessage());
    }
}
