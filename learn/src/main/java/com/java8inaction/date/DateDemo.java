package main.java.com.java8inaction.date;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @Author 程杰
 * @Date 2020/12/23 10:47
 * @Version 1.0
 */
public class DateDemo {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(dow);
        System.out.println(len);
        System.out.println(leap);

        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println("----------------------------------------------------");
        int year1 = date.get(ChronoField.YEAR);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);

        System.out.println(year1);System.out.println(month1);System.out.println(day1);

        System.out.println("----------------------------------------------------");
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println(hour);System.out.println(minute);System.out.println(second);
        LocalDate date1 = LocalDate.parse("2014-03-18");
        LocalTime time1 = LocalTime.parse("13:45:20");

        System.out.println("-------------------------LocalDateTime---------------------------");
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 22);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt1);System.out.println(dt2);System.out.println(dt3);
        System.out.println(dt4);System.out.println(dt5);

        LocalDate date2 = dt1.toLocalDate();
        LocalTime time2 = dt1.toLocalTime();

        System.out.println(date2);
        System.out.println(time2);

        System.out.println("-----------------------------------------------------");

        Instant instant = Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(3, 0);
        //2 秒之后再加上100万纳秒（1秒）
        Instant.ofEpochSecond(2, 1_000_000_000);
        // 4秒之前的100万纳秒（1秒）
        Instant.ofEpochSecond(4, -1_000_000_000);

        Instant instant1 = Instant.ofEpochSecond(4, -1_000_000_000);
        System.out.println(instant1);

        System.out.println("-----------------------------------------------------");
        LocalTime time3 = LocalTime.parse("13:45:20");
        LocalTime time4 = LocalTime.parse("15:45:20");
        Duration d1 = Duration.between(time3, time4);
//        Duration d1 = Duration.between(dateTime1, dateTime2);
//        Duration d2 = Duration.between(instant1, instant2);

        LocalDateTime localDateTime1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime localDateTime2 = LocalDateTime.of(2014, Month.MARCH, 20, 14, 45, 20);

        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2014, 3, 18));
        System.out.println(tenDays.getDays());

        Duration threeMinutes1 = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays1 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
    }
}
