package com.lusr.forwin.base;

public class Box {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;
        Integer c = 3;
        Integer d = 3;
        Integer e = 5;
        Long f = 3L;
        System.out.println(a == b);//自动装箱
        System.out.println(c == (a + b + b));//trueu
        System.out.println(c.equals(a + b + b));
        System.out.println(f == (a + b + b));// true
        System.out.println(f.equals(a + b + b));//false
    }
}
