package benn.tasks;

import benn.exceptions.BennException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm");
    private final LocalDateTime datetimeDue;
    public Deadline(String description, String datetimeDue, boolean isDone) throws BennException {
        super(description);
        try {
            System.out.println("in deadline ctor" + datetimeDue);
            this.datetimeDue = parseDateTime(datetimeDue);
        } catch (DateTimeParseException exception) {
            throw new BennException("Invalid date received!");
        }
        this.isDone = isDone;
    }

    private static LocalDateTime parseDateTime(String datetimeDue) throws BennException {
        String[] parts = datetimeDue == null ? null : datetimeDue.trim().split("\\s+");
        if (parts == null || parts.length != 2) {
            throw new BennException("Datetime must have exactly [date, time].");
        }
        String dateTimeString = parts[0] + "T" + parts[1];
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), datetimeDue);
    }

    @Override
    public String toStorageFormat() {
        return String.format("D | %d | %s | %s", this.getIsDone() ? 1 : 0, this.getDescription(), this.datetimeDue.format(formatter));
    }
}
