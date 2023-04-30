package org.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtils {

    // ... existing methods

    public static List<String> readFileLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
    }

    public static void writeFileLines(String filePath, List<String> lines) throws IOException {
        Files.write(Paths.get(filePath), lines, StandardCharsets.UTF_8);
    }

    public static void appendFileLines(String filePath, List<String> lines) throws IOException {
        Files.write(Paths.get(filePath), lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    public static String readFileContent(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
    }

    public static void writeFileContent(String filePath, String content) throws IOException {
        Files.writeString(Paths.get(filePath), content, StandardCharsets.UTF_8);
    }

    public static void createDirectory(String dirPath) throws IOException {
        Files.createDirectories(Paths.get(dirPath));
    }

    public static void moveFile(String source, String destination) throws IOException {
        Files.move(Paths.get(source), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void renameFile(String filePath, String newFilePath) throws IOException {
        moveFile(filePath, newFilePath);
    }

    public static boolean fileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    public static boolean isDirectory(String path) {
        return Files.isDirectory(Paths.get(path));
    }
}