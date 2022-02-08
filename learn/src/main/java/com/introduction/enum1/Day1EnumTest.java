package main.java.com.introduction.enum1;

public class Day1EnumTest {
    Day1 day;

    public Day1EnumTest(Day1 day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("周一各种不在状态");
                break;

            case FRIDAY:
                System.out.println("周五感觉还不错");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("周末给人的感觉是最棒的");
                break;

            default:
                System.out.println("周内感觉就那样吧。。。");
                break;
        }
    }

    public static void main(String[] args) {
        Day1EnumTest firstDay = new Day1EnumTest(Day1.MONDAY);
        firstDay.tellItLikeItIs();
        Day1EnumTest thirdDay = new Day1EnumTest(Day1.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        Day1EnumTest fifthDay = new Day1EnumTest(Day1.FRIDAY);
        fifthDay.tellItLikeItIs();
        Day1EnumTest sixthDay = new Day1EnumTest(Day1.SATURDAY);
        sixthDay.tellItLikeItIs();
        Day1EnumTest seventhDay = new Day1EnumTest(Day1.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}
