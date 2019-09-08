package com.lusr.forwin.single;

/**
 * Created by Lusq
 * Date: 2019/8/28
 * description:
 */
class Singleton3 {
    //静态内部类并不会再Singleton3被加载时就被加载
    //而是在出现InnerClass.single的时候被加载
    static class InnerClass{
        private static final Singleton3 single = new Singleton3();
    }
    private Singleton3(){}
    public static Singleton3 getSingleTon(){
        return InnerClass.single;
    }
}
