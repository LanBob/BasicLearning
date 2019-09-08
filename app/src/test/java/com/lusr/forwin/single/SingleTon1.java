package com.lusr.forwin.single;

/**
 * Created by Lusq
 * Date: 2019/8/28
 * description:
 */
class SingleTon1 {
    //类加载时即被创建，但无法确保类加载的时机，一般在getSingleton的时候被加价
    private static SingleTon1 singleton = new SingleTon1();
    private SingleTon1(){}
    public static SingleTon1 getSingleton(){
        return singleton;
    }
}
