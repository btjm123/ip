package benn;

import benn.exceptions.DukeException;
import benn.tasks.Deadline;
import benn.tasks.Event;
import benn.tasks.Task;
import benn.tasks.Todo;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public Todo addTodo(String description) {
        Todo todo = new Todo(description);
        this.tasks.add(todo);
        return todo;
    }

    public Deadline addDeadline(String description, String datetimeDue) {
        Deadline deadline = new Deadline(description, datetimeDue);
        this.tasks.add(deadline);
        return deadline;
    }

    public Event addEvent(String description, String startDateTime, String endDateTime) {
        Event event = new Event(description, startDateTime, endDateTime);
        this.tasks.add(event);
        return event;
    }

    public int size() {
        return tasks.size();
    }

    public Task markAsDone(int index) throws DukeException {
        int taskNumber = retrieveTaskNumberFrom(index);
        Task task = tasks.get(taskNumber);
        task.markAsDone();
        return task;
    }

    public Task unmarkAsDone(int index) throws DukeException {
        int taskNumber = retrieveTaskNumberFrom(index);
        Task task = tasks.get(taskNumber);
        task.unmarkAsDone();
        return task;
    }

    @Override
    public String toString() {
        if (tasks.isEmpty()) {
            return "     (no tasks yet)\n";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            sb.append("     ").append(i + 1).append(". ").append(task).append("\n");
        }
        return sb.toString();
    }

    private int retrieveTaskNumberFrom(int index) throws DukeException {
        if (index < 1) {
            throw new DukeException("Invalid index; index must be >= 1");
        } else if (index > this.tasks.size()) {
            throw new DukeException("Invalid index; index must be <= " + this.tasks.size());
        }
        return index - 1;
    }
}
