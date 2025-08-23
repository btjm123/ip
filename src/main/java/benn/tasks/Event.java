package benn.tasks;

public class Event extends Task{
    private final String startDateTime;
    private final String endDateTime;

    public Event(String description, String startDateTimeString, String endDateTimeString, boolean isDone) {
        super(description);
        this.startDateTime = startDateTimeString;
        this.endDateTime = endDateTimeString;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), this.startDateTime, this.endDateTime);
    }

    @Override
    public String toStorageFormat() {
        return String.format("E | %d | %s | %s | %s", this.getIsDone() ? 1 : 0, this.getDescription(), this.startDateTime, this.endDateTime);
    }

}
