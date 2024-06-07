package builder;

import model.Project;
import model.ProjectComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ProjectBuilder {
    private static final Logger logger = LogManager.getLogger(ProjectBuilder.class.getName());

    private String name;
    private ArrayList<ProjectComponent> components = new ArrayList<ProjectComponent>();

    public ProjectBuilder setName(String name) {
        logger.info("Setting name: " + name);
        this.name = name;
        return this;
    }

    public ProjectBuilder addComponent(ProjectComponent component) {
        logger.info("Adding component: " + component);
        components.add(component);
        return this;
    }

    public Project build() {
        Project project = new Project(name);
        for (ProjectComponent component : components) {
            project.addComponent(component);
        }
        return project;
    }
}