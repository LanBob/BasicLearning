package com.lusr.forwin.thread.demo0;

/**
 * Created by Lusq
 * Date: 2019/8/30
 * description:
 */
public class ThreadInterrupt {

    /**
     * A点肯定没有中断
     * B点已经执行了中断
     * C点抛出了中断异常，所以清空了中断标志位
     */

    public static void main(String[] args){
        Thread thread = Thread.currentThread();
        System.out.println("A point : " + thread.isInterrupted());

        thread.interrupt();
        System.out.println("B point : " + thread.isInterrupted());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("C point : "+thread.isInterrupted());
        }

        //============================
        System.out.println("D ponit : " + Thread.interrupted());
        thread.interrupt();
        System.out.println("E point :" +thread.isInterrupted());
        System.out.println("F ponit : " + Thread.interrupted());//先返回了当前的结果，在设置为false
        System.out.println("G point :" +thread.isInterrupted());
    }
}
