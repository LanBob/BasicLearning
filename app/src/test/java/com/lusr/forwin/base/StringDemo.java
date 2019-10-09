package com.lusr.forwin.base;

import java.util.logging.Handler;

public class StringDemo {
    public static void main(String[] args){
        String a = "13";
        String b = "45";
        String c = "13" + "45";
        String d = "1345";
        System.out.println((a + b).hashCode());
        System.out.println(c.hashCode());
        System.out.println((a + b) == c);
        System.out.println(c == d);
        System.out.println("13" == a);

    }
}
