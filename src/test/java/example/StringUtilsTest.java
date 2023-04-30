package example;

import org.example.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void isEmpty() {
        assertTrue(StringUtils.isEmpty(""));
        assertTrue(StringUtils.isEmpty(null));
        assertFalse(StringUtils.isEmpty("Hello"));
    }

    @Test
    void isNotEmpty() {
        assertFalse(StringUtils.isNotEmpty(""));
        assertFalse(StringUtils.isNotEmpty(null));
        assertTrue(StringUtils.isNotEmpty("Hello"));
    }

    @Test
    void reverse() {
        assertEquals("olleH", StringUtils.reverse("Hello"));
    }

    @Test
    void repeat() {
        assertEquals("abcabcabc", StringUtils.repeat("abc", 3));
    }

    @Test
    void join() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        assertEquals("apple,banana,cherry", StringUtils.join(words, ","));
    }

    @Test
    void countOccurrences() {
        assertEquals(2, StringUtils.countOccurrences("Mississippi", "ssi"));
    }

    @Test
    void isPalindrome() {
        assertTrue(StringUtils.isPalindrome("level"));
        assertFalse(StringUtils.isPalindrome("hello"));
    }

    @Test
    void removeWhitespace() {
        assertEquals("HelloWorld", StringUtils.removeWhitespace("Hello World"));
    }

    @Test
    void toCamelCase() {
        assertEquals("HelloWorld", StringUtils.toCamelCase("hello world"));
    }

    @Test
    void toSnakeCase() {
        assertEquals("hello_world", StringUtils.toSnakeCase("HelloWorld"));
    }

    @Test
    void capitalize() {
        assertEquals("Hello", StringUtils.capitalize("hello"));
    }

    @Test
    void leftPad() {
        assertEquals("00001234", StringUtils.leftPad("1234", 8, '0'));
    }

    @Test
    void rightPad() {
        assertEquals("1234----", StringUtils.rightPad("1234", 8, '-'));
    }

    @Test
    void truncate() {
        assertEquals("Hello", StringUtils.truncate("Hello, world!", 5));
    }

    @Test
    void split() {
        assertArrayEquals(new String[]{"apple", "banana", "cherry"}, StringUtils.split("apple,banana,cherry", ","));
    }

    @Test
    void splitToList() {
        List<String> expected = Arrays.asList("apple", "banana", "cherry");
        assertEquals(expected, StringUtils.splitToList("apple,banana,cherry", ","));
    }

    @Test
    void levenshteinDistance() {
        assertEquals(3, StringUtils.levenshteinDistance("kitten", "sitting"));
    }

    @Test
    void containsIgnoreCase() {
        assertTrue(StringUtils.containsIgnoreCase("Hello, world!", "WORLD"));
    }

    @Test
    void tokenize() {
        assertArrayEquals(new String[]{"apple", "banana", "cherry"}, StringUtils.tokenize("apple banana cherry", " "));
    }

    @Test
    void tokenizeToList() {
        List<String> expected = Arrays.asList("apple", "banana", "cherry");
        assertEquals(expected, StringUtils.tokenizeToList("apple banana cherry", " "));
    }

    @Test
    void removeNonDigits() {
        assertEquals("12345", StringUtils.removeNonDigits("abc123de45fg"));
    }

    @Test
    void extractDigits() {
        assertEquals("12345", StringUtils.extractDigits("abc123de45fg"));
    }
}
