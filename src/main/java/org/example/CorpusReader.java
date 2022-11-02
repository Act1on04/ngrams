package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public class CorpusReader {
    public static Set<String> getLinesFromFile(String fileName) throws IOException, URISyntaxException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String filePath = Paths.get(classloader.getResource(fileName).toURI()).toString();

        // String filePath = this.getClass().getClassLoader().getResource(fileName).getPath();
        return Files.lines(Paths.get(filePath)).collect(Collectors.toSet());
    }
}
