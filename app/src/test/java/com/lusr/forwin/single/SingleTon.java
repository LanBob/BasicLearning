package com.lusr.forwin.single;

/**
 * Created by Lusq
 * Date: 2019/8/28
 * description:
 */
class SingleTon {
    //volatile关键字本身具有禁止指令重排的功能，其次，最主要是保证了singleTon这个共享对象在线程中的修改是被其他线程是可见的
    //可见性：1.强制要求使用volatile关键字的时候，要从主存中进行读取；2.要求每次对共享变量的修改都要强制从工作区刷新到主存中
    private static volatile SingleTon singleTon;
    public static SingleTon getSingleTon(){
        if(singleTon == null){
            synchronized (SingleTon.class){
                //锁是class类型的锁，意味着所有通过该class创建的其他对象、class的static的同步方法，不能被其他线程所调用
                if(singleTon == null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
    private SingleTon(){}
}
