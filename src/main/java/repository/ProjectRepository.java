package repository;

import exception.ProjectDataIncorrectException;
import model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    private List<Project> projects = new ArrayList<>();

    public void addProject(Project project) {
        projects.add(project);
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(projects);
    }

    public Project getProjectByName(String name) throws ProjectDataIncorrectException {
        return projects.stream()
                .filter(project -> project.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ProjectDataIncorrectException("Project not found: " + name));
    }
}
