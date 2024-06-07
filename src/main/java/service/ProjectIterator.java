package service;

import model.ProjectComponent;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ProjectIterator implements Iterator<ProjectComponent> {
    private List<ProjectComponent> components;
    private int position = 0;

    public ProjectIterator(List<ProjectComponent> components) {
        this.components = components;
    }

    @Override
    public boolean hasNext() {
        return position < components.size();
    }

    @Override
    public ProjectComponent next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return components.get(position++);
    }

    public void remove() {
        Iterator.super.remove();
    }

    public void forEachRemaining(Consumer<? super ProjectComponent> action) {
        Iterator.super.forEachRemaining(action);
    }
}
