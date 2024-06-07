package reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import builder.ProjectBuilder;
import exception.ProjectDataIncorrectException;
import model.Project;
import model.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProjectFileReader {
    private static final String DELIMITER_LINES = "; ";
    private static final String DELIMITER_ROW = ",";
    private static final Logger logger = LogManager.getLogger(ProjectFileReader.class.getName());

    public static ArrayList<Project> parseProjects(String filePath) {
        ArrayList<Project> parsedProjects = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(ProjectFileReader.class.getResource(filePath).toURI()))) {
            lines.forEach(line -> {
                String[] stringProjects = line.split(DELIMITER_LINES);
                Project project = new Project(stringProjects[0]);
                    for (int i = 1; i < stringProjects.length; i++) {
                        project.addComponent(new Task(stringProjects[i]));
                    }
            });
        } catch (IOException | URISyntaxException e) {
            logger.error("Error reading file: " + e.getMessage());
        }
        return parsedProjects;
    }
}