package main.java.com.introduction.lambda.match;

import com.sun.tools.javac.util.List;

public class Demo {
    public static void main(String[] args) {
        List<FlagObject> flags = List.of(new FlagObject("zs", false),
                new FlagObject("ls", false),
                new FlagObject("wu", true));
        boolean b = flags.stream().map(FlagObject::getFlag).allMatch(flag -> flag.equals(false));
        System.out.println(b);
        boolean d = flags.stream().map(FlagObject::getFlag).anyMatch(flag -> flag.equals(true));
        System.out.println(d);

    }
}
