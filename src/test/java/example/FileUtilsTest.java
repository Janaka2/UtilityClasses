package example;


import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.example.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileUtilsTest {

    private static final String TEST_FILE = "test.txt";
    private static final String TEST_DIR = "test_dir";

    @TempDir
    public static java.nio.file.Path tempDir;

    private java.nio.file.Path testFilePath;

    @BeforeEach
    void setUp() throws IOException {
        testFilePath = Files.createFile(tempDir.resolve(TEST_FILE));
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(testFilePath);
    }

    @Test
    void testReadFileLines() throws IOException {
        List<String> expectedLines = Arrays.asList("line 1", "line 2", "line 3");
        Files.write(testFilePath, expectedLines, StandardCharsets.UTF_8);

        List<String> actualLines = FileUtils.readFileLines(testFilePath.toString());

        assertEquals(expectedLines, actualLines);
    }

    @Test
    void testWriteFileLines() throws IOException {
        List<String> expectedLines = Arrays.asList("line 1", "line 2", "line 3");

        FileUtils.writeFileLines(testFilePath.toString(), expectedLines);

        List<String> actualLines = Files.readAllLines(testFilePath);

        assertEquals(expectedLines, actualLines);
    }

    @Test
    void testAppendFileLines() throws IOException {
        List<String> initialLines = Arrays.asList("line 1", "line 2");
        List<String> appendedLines = Arrays.asList("line 3", "line 4");
        Files.write(testFilePath, initialLines, StandardCharsets.UTF_8);

        FileUtils.appendFileLines(testFilePath.toString(), appendedLines);

        List<String> expectedLines = Arrays.asList("line 1", "line 2", "line 3", "line 4");
        List<String> actualLines = Files.readAllLines(testFilePath);

        assertEquals(expectedLines, actualLines);
    }

    @Test
    void testReadFileContent() throws IOException {
        String expectedContent = "file content";
        Files.write(testFilePath, expectedContent.getBytes(StandardCharsets.UTF_8));

        String actualContent = FileUtils.readFileContent(testFilePath.toString());

        assertEquals(expectedContent, actualContent);
    }

    @Test
    void testWriteFileContent() throws IOException {
        String expectedContent = "file content";

        FileUtils.writeFileContent(testFilePath.toString(), expectedContent);

        String actualContent = Files.readString(testFilePath);

        assertEquals(expectedContent, actualContent);
    }

    @Test
    void testCreateDirectory() throws IOException {
        java.nio.file.Path testDirPath = tempDir.resolve(TEST_DIR);
        assertFalse(Files.exists(testDirPath));

        FileUtils.createDirectory(testDirPath.toString());

        assertTrue(Files.exists(testDirPath));
    }

    @Test
    void testMoveFile() throws IOException {
        java.nio.file.Path destFilePath = tempDir.resolve("test-moved.txt");
        assertFalse(Files.exists(destFilePath));

        FileUtils.moveFile(testFilePath.toString(), destFilePath.toString());

        assertTrue(Files.exists(destFilePath));
        assertFalse(Files.exists(testFilePath));
    }

    @Test
    void testRenameFile() throws IOException {
        java.nio.file.Path destFilePath = tempDir.resolve("test-renamed.txt");
        assertFalse(Files.exists(destFilePath));

        FileUtils.renameFile(testFilePath.toString(), destFilePath.toString());

        assertTrue(Files.exists(destFilePath));
        assertFalse(Files.exists(testFilePath));
    }

    @Test
    void testFileExists() {
        assertTrue(FileUtils.fileExists(testFilePath.toString()));
        assertFalse(FileUtils.fileExists(tempDir.resolve("non-existent.txt").toString()));
    }

    @Test
    void testIsDirectory() throws IOException {
        java.nio.file.Path testDirPath = tempDir.resolve(TEST_DIR);
        assertFalse(FileUtils.isDirectory(testFilePath.toString()));
        assertTrue(FileUtils.isDirectory(testDirPath.toString()));
    }
}