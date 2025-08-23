package benn.tasks;

public class Deadline extends Task {
    private final String datetimeDue;
    public Deadline(String description, String datetimeDue, boolean isDone) {
        super(description);
        this.datetimeDue = datetimeDue;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), datetimeDue);
    }

    @Override
    public String toStorageFormat() {
        return String.format("D | %d | %s | %s", this.getIsDone() ? 1 : 0, this.getDescription(), this.datetimeDue);
    }
}
