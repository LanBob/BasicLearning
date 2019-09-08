package com.lusr.forwin.thread.Main;

import static java.lang.Thread.currentThread;

/**
 * Created by Lusq
 * Date: 2019/8/30
 * description:
 */
public class WaitAndNotify1 {
    static int cnt = 0;

    /**
     * 两个线程交替打印奇数和偶数
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread, "偶数");
        Thread thraed1 = new Thread(myThread, "奇数");
        thread.start();
        thraed1.start();
        try {
            thread.join();
            thraed1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    this.notify();
                    if (cnt <= 100) {
                        String name = currentThread().getName();
                        System.out.println("Thread " + name + ",value = " + cnt++);
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
