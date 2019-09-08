package com.lusr.forwin.thread.basicThread;

/**
 * Created by Lusq
 * Date: 2019/8/30
 * description:
 */
public class ThreadLife {
    /**
     * 正确的暂停线程的方式是，调用interrupt,然后在线程中判断isInterrupt
     * 使用return去停止它
     */
    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("线程的优先级" + this.getPriority());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("停止一个线程");
//            stop();//已经弃用
            System.out.println("aaaa");
        }
    }
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("线程是否活跃：" + myThread.isAlive());
        //守护线程：为主线程而服务的，例如垃圾回收线程
        //特点：如果主线程退出了，那么它的守护线程也将会自动停止，免去手动停止的过程
        //当所有的非守护线程终止了，那么守护线程也就终止了
        System.out.println("线程是否是守护线程" + myThread.isDaemon());

//        myThread.interrupt();//将设置标志位，但是Sleep会出错
        try {
            //相当于：等待这个线程执行结束
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main");

    }
}
/**
 * 线程优先级：
 * 具有继承性，A启动B，B会继承A的优先级
 * 具有随机性，优先级高的概率更大，但是不意味着优先级低的不会执行
 *
 */
