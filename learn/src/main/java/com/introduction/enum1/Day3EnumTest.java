package main.java.com.introduction.enum1;

public class Day3EnumTest {
    Day3 day;

    public Day3EnumTest(Day3 day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println(day.getName()+day.getValue());
                System.out.println(day.getName()+"的下一天是"+day.getNext().getName());
                break;

            case FRIDAY:
                System.out.println(day.getName()+day.getValue());
                System.out.println(day.getName()+"的下一天是"+day.getNext().getName());
                break;

            case SATURDAY: case SUNDAY:
                System.out.println(day.getName()+day.getValue());
                System.out.println(day.getName()+"的下一天是"+day.getNext().getName());
                break;

            default:
                System.out.println(day.getName()+day.getValue());
                System.out.println(day.getName()+"的下一天是"+day.getNext().getName());
                break;
        }
    }

    public static void main(String[] args) {
        Day3EnumTest firstDay = new Day3EnumTest(Day3.MONDAY);
        firstDay.tellItLikeItIs();
        Day3EnumTest thirdDay = new Day3EnumTest(Day3.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        Day3EnumTest fifthDay = new Day3EnumTest(Day3.FRIDAY);
        fifthDay.tellItLikeItIs();
        Day3EnumTest sixthDay = new Day3EnumTest(Day3.SATURDAY);
        sixthDay.tellItLikeItIs();
        Day3EnumTest seventhDay = new Day3EnumTest(Day3.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}
