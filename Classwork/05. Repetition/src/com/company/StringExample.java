package com.company;

//Тема String Pool
public class StringExample {
    public static void main(String[] args) {
        String s1 = "a_string";//literal string
        String s2 = "a_string";
        String s3 = new String("a_string");
        String s4 = "bcd";
        String s5 = new String("my_string");

        if (s1 == s2) {
            System.out.println("s1 == s2");
        }

        if (s1 != s3) {
            System.out.println("s1 != s3");
        }

        s5 = s5.intern();

        s1 = s1 + ".";
        s1 = s1.replace(".", "!");
        System.out.println(s1);
    }
}
