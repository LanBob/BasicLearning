package com.lusr.forwin.newForBigo;

public class A {
    public static void main(String[] args){
        Fa fa = new Son();
        System.out.println(fa.val);
        fa.print();
    }
}

class Fa {
    int val = 10;

    void print() {
        System.out.println("fu" + val);
    }
}
class Son extends Fa{
    int val = 30;

    void print() {
        System.out.println("Son" + val);
    }
}