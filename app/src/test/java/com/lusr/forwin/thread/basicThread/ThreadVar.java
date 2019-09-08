package com.lusr.forwin.thread.basicThread;

/**
 * Created by Lusq
 * Date: 2019/8/30
 * description:
 */
public class ThreadVar extends Thread {
    //此时不共享变量
    private int count = 5;
    private ThreadVar(String name){
        super.setName(name);
    }

    @Override
    public void run() {
        while (count > 0) {
            System.out.println("Thread " + getName() + ",count = " + count--);
        }
    }

    public static void main(String[] args) {
        ThreadVar first = new ThreadVar("first");
        ThreadVar seconde = new ThreadVar("seconde");
        first.start();
        seconde.start();
    }
}
