package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class IOUtils {

    public static String readStreamAsString(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }

    public static ByteArrayInputStream stringToStream(String s) {
        return new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
    }

    public static ByteArrayOutputStream streamToByteArrayOutputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream;
    }

    public static String streamToString(InputStream inputStream, Charset charset) throws IOException {
        return streamToByteArrayOutputStream(inputStream).toString(charset);
    }

    public static void writeStringToStream(String s, OutputStream outputStream) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8))) {
            writer.write(s);
        }
    }

    public static List<String> streamToLines(InputStream inputStream) throws IOException {
        return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
    }

    public static InputStream getResourceAsStream(String resourceName) {
        return IOUtils.class.getClassLoader().getResourceAsStream(resourceName);
    }

    public static String getResourceContent(String resourceName) throws IOException {
        InputStream inputStream = getResourceAsStream(resourceName);
        if (inputStream == null) {
            throw new FileNotFoundException("Resource not found: " + resourceName);
        }
        return readStreamAsString(inputStream);
    }
}
