package example;

import org.example.DateUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    // ... existing test methods ...

    @Test
    void format() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 1, 12, 0);
        String formatted = DateUtils.format(dateTime, "yyyy-MM-dd HH:mm");
        assertEquals("2023-05-01 12:00", formatted);
    }

    @Test
    void parse() {
        String dateTimeString = "2023-05-01 12:00";
        LocalDateTime dateTime = DateUtils.parse(dateTimeString, "yyyy-MM-dd HH:mm");
        assertEquals(LocalDateTime.of(2023, 5, 1, 12, 0), dateTime);
    }

    @Test
    void toDate() {
        LocalDateTime localDateTime = LocalDateTime.of(2023, 5, 1, 12, 0);
        Date date = DateUtils.toDate(localDateTime);
        assertEquals(localDateTime, DateUtils.toLocalDateTime(date));
    }

    @Test
    void toLocalDateTime() {
        Date date = new Date();
        LocalDateTime localDateTime = DateUtils.toLocalDateTime(date);
        assertEquals(date, DateUtils.toDate(localDateTime));
    }

    @Test
    void toZonedDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 1, 12, 0);
        ZonedDateTime zonedDateTime = DateUtils.toZonedDateTime(dateTime, ZoneId.of("UTC"));
        assertEquals(dateTime, zonedDateTime.toLocalDateTime());
    }

    @Test
    void atStartOfDay() {
        LocalDate date = LocalDate.of(2023, 5, 1);
        LocalDateTime startOfDay = DateUtils.atStartOfDay(date);
        assertEquals(LocalDateTime.of(2023, 5, 1, 0, 0), startOfDay);
    }

    @Test
    void atTime() {
        LocalDate date = LocalDate.of(2023, 5, 1);
        LocalTime time = LocalTime.of(12, 0);
        LocalDateTime dateTime = DateUtils.atTime(date, time);
        assertEquals(LocalDateTime.of(2023, 5, 1, 12, 0), dateTime);
    }

    @Test
    void plusDays() {
        LocalDate date = LocalDate.of(2023, 5, 1);
        LocalDate datePlusDays = DateUtils.plusDays(date, 5);
        assertEquals(LocalDate.of(2023, 5, 6), datePlusDays);
    }

    @Test
    void minusDays() {
        LocalDate date = LocalDate.of(2023, 5, 1);
        LocalDate dateMinusDays = DateUtils.minusDays(date, 5);
        assertEquals(LocalDate.of(2023, 4, 26), dateMinusDays);
    }

    @Test
    void plusHours() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 1, 12, 0);
        LocalDateTime dateTimePlusHours = DateUtils.plusHours(dateTime, 5);
        assertEquals(LocalDateTime.of(2023, 5, 1, 17, 0), dateTimePlusHours);
    }

    @Test
    void minusHours() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 1, 12, 0);
        LocalDateTime dateTimeMinusHours = DateUtils.minusHours(dateTime, 5);
        assertEquals(LocalDateTime.of(2023, 5, 1, 7, 0), dateTimeMinusHours);
    }

}
