package com.company;

//Тема Integer Cache
public class Main {

    public static void main(String[] args) {
        int x = 5;
        Integer i1 = 5;//то же, что valueOf
        Integer i2 = Integer.valueOf(5);
        Integer j = new Integer(5);
        Integer k = new Integer(5);
        if (i1 == i2) {
            System.out.println("i1 == i2");
        }
        if (i1 != j) {{
            System.out.println("i1 != j");
        }


        String s1 = "abc";
        String s2 = "aaaa";
//        if (s1 > s2)

        Integer y1 = 5;
        Integer y2 = 7;

        if (y1 > y2) {//unboxing

        }

    }
}
