package main.java.com.introduction.io.demo;

import org.junit.Test;

import java.io.*;

public class Member {

    private String name;

    private String number;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Member() {
//    }

    public Member(String name, String number, int age) {
        this.name = name;
        this.number = number;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", age=" + age +
                '}';
    }

    public void save() throws IOException {
        try(DataOutputStream output = new DataOutputStream(new FileOutputStream(number))){
            output.writeUTF(name);
            output.writeUTF(number);
            output.writeInt(age);
        }
    }

    public static Member load(String number) throws IOException{
        Member member;
        try(DataInputStream input = new DataInputStream(new FileInputStream(number))){
            member = new Member(input.readUTF(), input.readUTF(), input.readInt());
        }
        return member;
    }


    public static void main(String[] args) throws IOException {
        Member [] members = {new Member("aaa","N123",7),
                new Member("bbb","N456",8),
                new Member("ccc","N789",9)
        };
        for (Member member : members) {
            member.save();
        }
        System.out.println(Member.load("N123"));
        System.out.println(Member.load("N456"));
        System.out.println(Member.load("N789"));
    }

}
