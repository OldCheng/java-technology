package main.java.com.introduction.exception;

public class ExceptionStack {
    public static void main(String[] args) {
        try {
            c();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(e.getStackTrace());
            System.out.println(e.getSuppressed());
            System.out.println(e);
        }
    }

    static void c() {
        b();
    }

    static void b() {
        a();
    }

    static String a() {
        String text = null;
        return text.toUpperCase();
    }

}
