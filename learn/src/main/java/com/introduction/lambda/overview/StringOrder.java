package main.java.com.introduction.lambda.overview;

public class StringOrder {

    public static int byLength(String s1, String s2){
        return s1.length() - s2.length();
    }

    public static int byLexicography(String s1, String s2){
        return s1.compareTo(s2);
    }

    public static int byLexicographyIgnoreCase(String s1, String s2){
        return s1.compareToIgnoreCase(s2);
    }
}
