package main.java.com.thinkinjava.annotations;

/**
 * @Author 程杰
 * @Date 2021/1/19 18:20
 * @Version 1.0
 */
public class Testable {

    public void execute(){
        System.out.println("Executing----------------");
    }

    @Test
    void testExecute(){
        execute();
    }
}
