package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task implements ProjectComponent {
    private static final Logger logger = LogManager.getLogger(Task.class.getName());

    private String name;
    private TaskPriority priority;

    public Task(String name) {
        logger.info("Created task with name: " + name);
        this.name = name;
    }

    @Override
    public void display() {
        logger.info("Displaying task: " + name + priority);
        System.out.println("Task: " + name + ". priority:" + priority);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.info("Set task name: " + name);
        this.name = name;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        logger.info("Set task priority: " + priority);
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (getName() != null ? !getName().equals(task.getName()) : task.getName() != null) return false;
        return getPriority() == task.getPriority();
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPriority() != null ? getPriority().hashCode() : 0);
        return result;
    }
}