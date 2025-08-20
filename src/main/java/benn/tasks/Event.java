package benn.tasks;

public class Event extends Task{
    private final String startDateTime;
    private final String endDateTime;

    public Event(String description, String startDateTimeString, String endDateTimeString) {
        super(description);
        this.startDateTime = startDateTimeString;
        this.endDateTime = endDateTimeString;
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), this.startDateTime, this.endDateTime);
    }

}
