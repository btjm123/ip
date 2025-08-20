package benn;

import benn.tasks.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public Task add(String description) {
        Task t = new Task(description);
        tasks.add(t);
        return t;
    }

    public List<Task> all() {
        return Collections.unmodifiableList(tasks);
    }

    public int size() {
        return tasks.size();
    }

    @Override
    public String toString() {
        if (tasks.isEmpty()) {
            return "     (no tasks yet)\n";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            sb.append("     ").append(i + 1).append(". ").append(task.getDescription()).append("\n");
        }
        return sb.toString();
    }
}
