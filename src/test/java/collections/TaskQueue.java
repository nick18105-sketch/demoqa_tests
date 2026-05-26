package collections;

import java.util.LinkedList;

public class TaskQueue {

    LinkedList<String> tasks = new LinkedList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask() {

        if (!tasks.isEmpty()) {
            tasks.removeFirst();
        }
    }

    public void findTask(String task) {

        if (tasks.contains(task)) {
            System.out.println("Найдена задача: " + task);
        }
    }

    public void printTasks() {

        for (String task : tasks) {
            System.out.println(task);
        }
    }
}