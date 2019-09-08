package com.lusr.forwin.thread.demo0;

/**
 * Created by Lusq
 * Date: 2019/8/27
 * description:
 */
public class SyncThread3 {

    public static void main(String[] args) {
        final Test test = new Test();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.one();
                }
            }).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.say();
                }
            }).start();
        }
    }

    static class Test {
        volatile int i = 0;
        volatile int j = 0;

        synchronized void one() {
            ++i;
            ++j;
        }

        synchronized void say() {
            System.out.println("i = " + i + ", j = " + j);
        }
    }
}
