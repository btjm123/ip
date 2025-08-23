package benn.tasks;

import benn.exceptions.BennException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task{
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm");
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;

    public Event(String description, String startDateTimeString, String endDateTimeString, boolean isDone) throws BennException {
        super(description);
        try {
            this.startDateTime = parseDateTime(startDateTimeString.split(" "));
            this.endDateTime = parseDateTime(endDateTimeString.split(" "));
        } catch (DateTimeParseException exception) {
            throw new BennException("Invalid date received!");
        }
        this.isDone = isDone;
    }

    private static LocalDateTime parseDateTime(String[] datetimeParts) throws BennException {
        if (datetimeParts == null || datetimeParts.length != 2) {
            throw new BennException("Datetime must have exactly [date, time].");
        }
        String dateTimeString = datetimeParts[0] + "T" + datetimeParts[1];
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), this.startDateTime.format(formatter), this.endDateTime.format(formatter));
    }

    @Override
    public String toStorageFormat() {
        return String.format("E | %d | %s | %s | %s", this.getIsDone() ? 1 : 0, this.getDescription(), this.startDateTime.format(formatter), this.endDateTime.format(formatter));
    }

}
