package main.java.com.introduction.coretechnology.date_time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;

public class DateTimeTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        LocalDate now = LocalDate.now();
        System.out.println("today:"+ now);

        LocalDate of = LocalDate.of(1903, 6, 14);
        LocalDate of1 = LocalDate.of(1903, Month.JUNE, 14);
        System.out.println(of+"     "+of1);



    }
}
