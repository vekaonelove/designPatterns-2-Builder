package main;

import builder.ProjectBuilder;
import model.Project;
import model.ProjectComponent;
import model.Task;
import model.TaskPriority;
import repository.ProjectRepository;

public class Main {
    public static void main(String[] args) {
        ProjectComponent task1 = new Task("DesignMockup");
        ((Task) task1).setPriority(TaskPriority.HIGH);
        ProjectComponent task2 = new Task("CodeHomepage");
        ((Task) task2).setPriority(TaskPriority.MEDIUM);
        ProjectComponent task3 = new Task("TestWebsite");
        ((Task) task3).setPriority(TaskPriority.LOW);

        Project project = new ProjectBuilder()
                .setName("WebsiteRedesign")
                .addComponent(task1)
                .addComponent(task2)
                .addComponent(task3)
                .build();

        ProjectRepository repository = new ProjectRepository();
        repository.addProject(project);

        for (Project p : repository.getAllProjects()) {
            p.display();
        }
    }
}