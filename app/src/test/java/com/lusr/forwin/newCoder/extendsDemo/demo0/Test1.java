package com.lusr.forwin.newCoder.extendsDemo.demo0;

class A1{
    int a = 1;
    public int getA() {
        System.out.println(this);
        return this.a;
    }
}

class B1 extends A1 {
    int a = 2;
}

public class Test1 {
    public static void main(String[] args) {
        A1 b =new B1();
        System.out.println(b.getA());
        System.out.println(b.a);
    }
}