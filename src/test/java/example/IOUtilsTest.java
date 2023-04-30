package example;

import org.example.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class IOUtilsTest {

    @Test
    void readStreamAsString() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("Hello, world!".getBytes(StandardCharsets.UTF_8));
        String result = IOUtils.readStreamAsString(inputStream);
        assertEquals("Hello, world!", result);
    }

    @Test
    void stringToStream() {
        String input = "Hello, world!";
        ByteArrayInputStream result = IOUtils.stringToStream(input);
        byte[] bytes = new byte[13];
        result.read(bytes, 0, 13);
        assertEquals(input, new String(bytes, StandardCharsets.UTF_8));
    }

    @Test
    void streamToByteArrayOutputStream() throws IOException {
        String input = "Hello, world!";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream result = IOUtils.streamToByteArrayOutputStream(inputStream);
        assertEquals(input, result.toString(StandardCharsets.UTF_8));
    }

    @Test
    void streamToString() throws IOException {
        String input = "Hello, world!";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        String result = IOUtils.streamToString(inputStream, StandardCharsets.UTF_8);
        assertEquals(input, result);
    }

    @Test
    void writeStringToStream() throws IOException {
        String input = "Hello, world!";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.writeStringToStream(input, outputStream);
        String result = outputStream.toString(StandardCharsets.UTF_8);
        assertEquals(input, result);
    }

    @Test
    void streamToLines() throws IOException {
        String input = "Hello\nworld!";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        assertEquals(2, IOUtils.streamToLines(inputStream).size());
    }

    @Test
    void getResourceContent() throws IOException {
        String result = IOUtils.getResourceContent("example.txt");
        assertEquals("Hello, world!", result);
    }

    @Test
    void getResourceContent_notFound() {
        assertThrows(FileNotFoundException.class, () -> IOUtils.getResourceContent("nonexistent.txt"));
    }
}

