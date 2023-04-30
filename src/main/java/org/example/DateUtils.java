package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {

    public static String formatDate(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    public static String formatDateTime(LocalDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }

    public static LocalDate parseDate(String date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, formatter);
    }

    public static LocalDateTime parseDateTime(String dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateTime, formatter);
    }

    public static Duration timeDifference(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end);
    }

    public static Period dateDifference(LocalDate start, LocalDate end) {
        return Period.between(start, end);
    }

    public static long daysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }

    public static ZonedDateTime convertTimeZone(LocalDateTime dateTime, ZoneId fromZone, ZoneId toZone) {
        return dateTime.atZone(fromZone).withZoneSameInstant(toZone);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static LocalDate addDays(LocalDate date, int days) {
        return date.plusDays(days);
    }

    public static LocalDate subtractDays(LocalDate date, int days) {
        return date.minusDays(days);
    }

    public static String format(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    public static LocalDateTime parse(String dateTimeString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static ZonedDateTime toZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId) {
        return localDateTime.atZone(zoneId);
    }

    public static LocalDateTime atStartOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    public static LocalDateTime atTime(LocalDate date, LocalTime time) {
        return date.atTime(time);
    }

    public static LocalDate plusDays(LocalDate date, int days) {
        return date.plusDays(days);
    }

    public static LocalDate minusDays(LocalDate date, int days) {
        return date.minusDays(days);
    }

    public static LocalDateTime plusHours(LocalDateTime dateTime, int hours) {
        return dateTime.plusHours(hours);
    }

    public static LocalDateTime minusHours(LocalDateTime dateTime, int hours) {
        return dateTime.minusHours(hours);
    }
}
