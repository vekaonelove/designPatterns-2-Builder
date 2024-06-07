package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ProjectIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Project implements ProjectComponent, Iterable<ProjectComponent> {
    private static final Logger logger = LogManager.getLogger(Project.class.getName());

    private String name;
    private ArrayList<ProjectComponent> components = new ArrayList<>();

    public Project(String name) {
        logger.info("Creating project with name: " + name);
        this.name = name;
    }

    public void addComponent(ProjectComponent component) {
        logger.info("Adding component: " + component);
        components.add(component);
    }

    @Override
    public void display() {
        logger.info("Displaying project: " + name);
        System.out.println("Project: " + name);
        for (ProjectComponent component : components) {
            component.display();
        }
    }

    @Override
    public Iterator<ProjectComponent> iterator() {
        return new ProjectIterator(components);
    }

    public void setName(String name) {
        logger.info("Set project name to: " + name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<ProjectComponent> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<ProjectComponent> components) {
        this.components = components;
    }
}