package service;

import model.Task;

public class TaskManager {
    private Task head;

    public TaskManager() {
        head = null;
    }

    // Add task at the end
    public void addTask(String taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newTask);
        }
    }

    // Search by taskId
    public Task searchTask(String taskId) {
        Task current = head;
        while (current != null) {
            if (current.getTaskId().equalsIgnoreCase(taskId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Delete by taskId
    public boolean deleteTask(String taskId) {
        if (head == null) return false;

        if (head.getTaskId().equalsIgnoreCase(taskId)) {
            head = head.getNext();
            return true;
        }

        Task current = head;
        while (current.getNext() != null && !current.getNext().getTaskId().equalsIgnoreCase(taskId)) {
            current = current.getNext();
        }

        if (current.getNext() == null) return false;

        current.setNext(current.getNext().getNext());
        return true;
    }

    // Traverse all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
        } else {
            Task current = head;
            while (current != null) {
                System.out.println(current);
                current = current.getNext();
            }
        }
    }
}
