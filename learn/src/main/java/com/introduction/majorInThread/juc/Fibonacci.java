package main.java.com.introduction.majorInThread.juc;

public class Fibonacci {

    public static void main(String[] args) {
        int result = computeFibonacci(40);
        System.out.println(result);
    }

    private static int computeFibonacci(int n) {
// n >= 0
        if (n == 1 || n == 2) {
            return 1;
        } else {
            int first = 1;
            int second = 1;
            int third = 0;
            for (int i = 3; i <= n; i++) {
//
                third = first + second;
//
                first = second;
                second = third;
            }
            return third;
        }
    }
}
