package model;

public class Task {
    private String taskId;
    private String taskName;
    private String status;
    Task next;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public String getTaskId() {
        return taskId;
    }

    public Task getNext() {
        return next;
    }

    public void setNext(Task next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[ID: " + taskId + ", Name: " + taskName + ", Status: " + status + "]";
    }
}
