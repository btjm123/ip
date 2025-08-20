package benn.tasks;

public class Deadline extends Task {
    private final String datetimeDue;
    public Deadline(String description, String datetimeDue) {
        super(description);
        this.datetimeDue = datetimeDue;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), datetimeDue);
    }
}
