package benn.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private String datetimeDue;
    public Deadline(String description, String datetimeDue) {
        super(description);
        this.datetimeDue = datetimeDue;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), datetimeDue);
    }
}
