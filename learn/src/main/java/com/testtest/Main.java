package main.java.com.testtest;

public class Main {
        static int value = 33;

        public static void main(String[] args) throws Exception{



            new Main().printValue();
        }

        private void printValue(){
            int value = 3;
            System.out.println(this.value);
        }
}
