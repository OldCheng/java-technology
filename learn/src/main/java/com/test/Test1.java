package main.java.com.test;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/3/30 16:47
 * @Version 1.0
 */
public class Test1 {

    public static void main(String[] args) {
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 100; y++) {
                int z=300-x-y;
                if((z%3==0)&&(x*6+y*3+z/3==300))
                {
                    System.out.println("母兔的数量为"+x+"--公兔的数量是"+y+"---小兔的数量为--"+z);
                }
            }
        }
    }
}
