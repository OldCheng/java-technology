package main.java.com.introduction.enum1;

public class Day2EnumTest {
    Day2 day;

    public Day2EnumTest(Day2 day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println(day.getName() + day.getValue());
                break;

            case FRIDAY:
                System.out.println(day.getName() + day.getValue());
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println(day.getName() + day.getValue());
                break;

            default:
                System.out.println(day.getName() + day.getValue());
                break;
        }
    }

    public static void main(String[] args) {
        Day2EnumTest firstDay = new Day2EnumTest(Day2.MONDAY);
        firstDay.tellItLikeItIs();
        Day2EnumTest thirdDay = new Day2EnumTest(Day2.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        Day2EnumTest fifthDay = new Day2EnumTest(Day2.FRIDAY);
        fifthDay.tellItLikeItIs();
        Day2EnumTest sixthDay = new Day2EnumTest(Day2.SATURDAY);
        sixthDay.tellItLikeItIs();
        Day2EnumTest seventhDay = new Day2EnumTest(Day2.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}
