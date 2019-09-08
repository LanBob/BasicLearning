package com.lusr.forwin.thread.demo0;

/**
 * Created by Lusq
 * Date: 2019/8/28
 * description:
 */
public class SynchronizedThread implements Runnable {
    private static int count = 0;

    public static void main(String[] args) {
        SynchronizedThread synchronizedThread = new SynchronizedThread();
        for (int i = 1; i <= 100; i++) {
            Thread thread = new Thread(synchronizedThread);
            thread.start();
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= 100; i++) {
                count++;
            }
            System.out.println(count);
        }
    }
}
