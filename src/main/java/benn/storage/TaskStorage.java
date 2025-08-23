package benn.storage;

import benn.exceptions.BennException;
import benn.patterns.TaskStoragePattern;
import benn.tasks.Deadline;
import benn.tasks.Event;
import benn.tasks.Task;
import benn.tasks.Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskStorage {
    private static final String TASK_STORAGE_PATH = "./temporary_datastore/tasks.txt";

    private List<Task> tasks;

    private TaskStorage(List<Task> tasks) {
        this.tasks = tasks;
    }

    public static TaskStorage start() throws IOException, BennException {
        File taskStorage = new File(TASK_STORAGE_PATH);
        if (taskStorage.isDirectory()) {
            throw new BennException("Directory detected, can't create task storage file!");
        } else if (taskStorage.exists() && taskStorage.isFile()) {
            return TaskStorage.loadFromExisting(taskStorage);
        } else {
            return TaskStorage.createNew(taskStorage);
        }
    }

    public void add(Task task) throws IOException {
        this.tasks.add(task);
        this.flush();
    }

    public Task getTaskLocatedAt(int index) {
        return this.tasks.get(index);
    }

    public Task removeTask(int index) throws IOException {
        Task task = this.tasks.remove(index);
        this.flush();
        return task;
    }

    public int getTaskCount() {
        return this.tasks.size();
    }

    private static TaskStorage createNew(File file) throws IOException {
        File parent = file.getParentFile();
        parent.mkdirs();
        file.createNewFile();
        return new TaskStorage(new ArrayList<>());
    }

    private static TaskStorage loadFromExisting(File file) throws IOException, BennException {
        List<Task> taskList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(fis, java.nio.charset.StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                Task task = parseLine(line);
                taskList.add(task);
            }
        }
        return new TaskStorage(taskList);
    }

    public void flush() throws IOException {
        List<String> lines = this.tasks.stream()
                .map(Task::toStorageFormat)
                .toList();
        try (FileWriter writer = new FileWriter(TASK_STORAGE_PATH, false)) {
            for (String line : lines) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        }
    }

    private static Task parseLine(String line) throws BennException {
        Matcher matcher;
        if ((matcher = doesPatternMatch(TaskStoragePattern.TODO, line)) != null) {
            String description = matcher.group("description");
            String done = matcher.group("done");
            boolean isDone = "1".equals(done);
            return new Todo(description, isDone);
        }

        if ((matcher = doesPatternMatch(TaskStoragePattern.DEADLINE, line)) != null) {
            String description = matcher.group("description");
            String by = matcher.group("by");
            String done = matcher.group("done");
            boolean isDone = "1".equals(done);
            return new Deadline(description, by, isDone);
        }

        if ((matcher = doesPatternMatch(TaskStoragePattern.EVENT, line)) != null) {
            String description = matcher.group("description");
            String from = matcher.group("from");
            String to = matcher.group("to");
            String done = matcher.group("done");
            boolean isDone = "1".equals(done);
            return new Event(description, from, to, isDone);
        }

        throw new BennException("Unknown task format: " + line);
    }

    private static Matcher doesPatternMatch(Pattern p, String line) {
        Matcher m = p.matcher(line);
        return m.find() ? m : null;
    }

}
