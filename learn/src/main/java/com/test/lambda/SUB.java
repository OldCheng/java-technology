package main.java.com.test.lambda;

import java.math.BigDecimal;

public class SUB extends Student{

    private String zxc;

    protected String asd;

    public SUB(){
        super();

    }

    String ss;

    public SUB(String stuName, int age, BigDecimal score, int clazz,String ss) {
        super(stuName, age, score, clazz);
        this.ss = ss;
    }


    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
        return "SUB{" +
                "ss='" + ss + '\'' + "asd='" + asd + '\'' +
                "} " + super.toString();
    }
}
