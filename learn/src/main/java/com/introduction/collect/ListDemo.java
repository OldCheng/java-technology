package main.java.com.introduction.collect;

import com.sun.tools.javac.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> s = List.of("s");
        //s.add("e");

        Person p = new Person("a",9);
        List<Person> of = List.of(p);
        for (Person person : of) {
            person.setAge(99);
            person.setName("b");
        }

        for (Person person : of) {
            System.out.println(person);
        }

    }
}
