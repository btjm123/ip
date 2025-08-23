package benn.tasks;

import benn.exceptions.BennException;
import benn.storage.TaskStorage;

import java.io.IOException;

public class TaskManager {
    private final TaskStorage taskStorage;

    public TaskManager() throws IOException, BennException {
        this.taskStorage = TaskStorage.start();
    }

    public Todo addTodo(String description) throws IOException {
        Todo todo = new Todo(description, false);
        this.taskStorage.add(todo);
        return todo;
    }

    public Deadline addDeadline(String description, String datetimeDue) throws IOException, BennException {
        Deadline deadline = new Deadline(description, datetimeDue, false);
        this.taskStorage.add(deadline);
        return deadline;
    }

    public Event addEvent(String description, String startDateTime, String endDateTime) throws IOException, BennException {
        Event event = new Event(description, startDateTime, endDateTime, false);
        this.taskStorage.add(event);
        return event;
    }

    public int size() {
        return this.taskStorage.getTaskCount();
    }

    public Task markAsDone(int taskNumber) throws BennException, IOException {
        int index = this.retrieveIndexFrom(taskNumber);
        Task task = this.taskStorage.getTaskLocatedAt(index);
        task.markAsDone();
        this.taskStorage.flush();
        return task;
    }

    public Task unmarkAsDone(int taskNumber) throws BennException, IOException {
        int index = this.retrieveIndexFrom(taskNumber);
        Task task = this.taskStorage.getTaskLocatedAt(index);
        task.unmarkAsDone();
        this.taskStorage.flush();
        return task;
    }

    public Task deleteTaskAt(int taskNumber) throws IOException, BennException {
        int index = retrieveIndexFrom(taskNumber);
        return this.taskStorage.removeTask(index);
    }

    @Override
    public String toString() {
        int taskCount = this.taskStorage.getTaskCount();
        if (taskCount == 0) {
            return "     (no tasks yet)\n";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            Task task = this.taskStorage.getTaskLocatedAt(i);
            sb.append("     ").append(i + 1).append(". ").append(task).append("\n");
        }
        return sb.toString();
    }

    private int retrieveIndexFrom(int taskNumber) throws BennException {
        int taskCount = this.taskStorage.getTaskCount();
        if (taskNumber < 1) {
            throw new BennException("Invalid index; index must be >= 1");
        } else if (taskNumber > taskCount) {
            throw new BennException("Invalid index; index must be <= " + taskCount);
        }
        return taskNumber - 1;
    }
}
