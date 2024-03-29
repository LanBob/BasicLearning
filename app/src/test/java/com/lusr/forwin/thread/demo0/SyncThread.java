package com.lusr.forwin.thread.demo0;

/**
 * Created by Lusq
 * Date: 2019/8/27
 * description:
 */
public class SyncThread {

    public static void main(String[] args) {
        Runnable run = new Runnable() {
            Count count = new Count();

            @Override
            public void run() {
                count.setCount();
            }
        };

        for (int i = 0; i < 1000; i++) {
            new Thread(run).start();
        }
    }

    /**
     * 使用synchronized属于非公平锁，不会按照加锁的先后顺序去分配锁，而是抢占式
     */
    private static class Count {
        private int count;

        synchronized void setCount() {
//            int count = 0;
            for (int i = 1; i <= 100; i++) {
                count += i;
            }
            System.out.println(Thread.currentThread().getName() + " - " + count);
        }
    }
}