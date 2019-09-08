package com.lusr.forwin.thread.basicThread.sync;

/**
 * Created by Lusq
 * Date: 2019/8/30
 * description:
 */
public class VolatileProblem {
    /**
     * 这是个失败实验，因为JVM尽量保持可见性
     */
    static class Running extends Thread{

        private volatile boolean isRunning = true;
        int m = 0;
        private void setRunning(boolean isRunning){
            this.isRunning = isRunning;
        }
        @Override
        public void run() {
            while (isRunning){
                System.out.println("还在运行");
                int a = 10;
                int b = 100;
                a += b;
                b += m;
                m += a + b;
            }
            System.out.println("线程终止");
        }

    }
    public static void main(String[] args){
        Running running = new Running();
        running.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        running.setRunning(false);
        System.out.println("已经设置false");
    }
}
