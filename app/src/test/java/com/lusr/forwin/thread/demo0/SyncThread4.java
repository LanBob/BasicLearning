package com.lusr.forwin.thread.demo0;

/**
 * Created by Lusq
 * Date: 2019/8/27
 * description:
 */
public class SyncThread4 {

    public static void main(String[] a){
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();
    }

    static class MyThread extends Thread{
        int i = 1;
        @Override
        public void run() {
            while (!isInterrupted()){
                System.out.println("a - " + i++);
            }
        }
    }
}
