package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String repeat(String s, int count) {
        return String.join("", Collections.nCopies(count, s));
    }

    public static String join(List<String> list, String delimiter) {
        return String.join(delimiter, list);
    }

    public static int countOccurrences(String s, String substring) {
        return (s.length() - s.replace(substring, "").length()) / substring.length();
    }

    public static boolean isPalindrome(String s) {
        return s.equalsIgnoreCase(reverse(s));
    }

    public static String removeWhitespace(String s) {
        return s.replaceAll("\\s", "");
    }

    public static String toCamelCase(String s) {
        String[] words = s.split(" ");
        StringBuilder camelCaseString = new StringBuilder();
        for (String word : words) {
            camelCaseString.append(word.substring(0, 1).toUpperCase());
            camelCaseString.append(word.substring(1).toLowerCase());
        }
        return camelCaseString.toString();
    }

    public static String toSnakeCase(String s) {
        return s.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    public static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static String leftPad(String s, int length, char paddingChar) {
        return String.format("%" + length + "s", s).replace(' ', paddingChar);
    }

    public static String rightPad(String s, int length, char paddingChar) {
        return String.format("%-" + length + "s", s).replace(' ', paddingChar);
    }

    public static String truncate(String s, int maxLength) {
        return s.length() > maxLength ? s.substring(0, maxLength) : s;
    }

    public static String[] split(String s, String delimiter) {
        return s.split(Pattern.quote(delimiter));
    }

    public static List<String> splitToList(String s, String delimiter) {
        return Arrays.asList(split(s, delimiter));
    }

    public static int levenshteinDistance(String s1, String s2) {
        int[][] distance = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else {
                    distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1),
                            distance[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1));
                }
            }
        }
        return distance[s1.length()][s2.length()];
    }

    public static boolean containsIgnoreCase(String s, String substring) {
        return s.toLowerCase().contains(substring.toLowerCase());
    }

    public static String[] tokenize(String s, String regex) {
        return s.split(regex);
    }

    public static List<String> tokenizeToList(String s, String regex) {
        return Arrays.asList(tokenize(s, regex));
    }

    public static String removeNonDigits(String s) {
        return s.replaceAll("\\D+", "");
    }

    public static String extractDigits(String s) {
        return removeNonDigits(s);
    }
}