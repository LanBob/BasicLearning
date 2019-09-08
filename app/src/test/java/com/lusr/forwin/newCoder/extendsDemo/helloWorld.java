package com.lusr.forwin.newCoder.extendsDemo;

public class helloWorld {

    public static void main(String[] args) {
        Base b=new Sub();
//        Base c=b;
        b.printMessage();
        System.out.println(b.x);
    }


}


class Base{
    int x=10;
    public Base(){
//        this.printMessage();
        System.out.println("父类的构造方法"+x);
        x=20;
    }
    public void printMessage(){
        System.out.println("父类的构造方法中的方法Base.x="+x);
    }
}

class Sub extends Base{
    int x=30;
    public Sub(){
//        this.printMessage();
        System.out.println("子类的构造方法"+x);
        x=40;
    }
    public void printMessage(){
        System.out.println("子类的构造方法中的方法sub.x="+x);
    }
}