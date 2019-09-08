package com.lusr.forwin.thread.basicThread.sync;


/**
 * Created by Lusq
 * Date: 2019/8/30
 * description:
 */
public class SyncWateTime {
    /**
     * synchronized的缺点：太重了，导致两个任务的执行时间过长
     */
    private static class Task{
        String string = "";
        String string1 = "";
        synchronized void doWork(String threadName){
            System.out.println("begin task");
            try {
                Thread.sleep(4000);
                string = threadName + ",长时间处理任务后从远程返回的值1 threadName="
                        + Thread.currentThread().getName();
                string1 = threadName + ",长时间处理任务后从远程返回的值2 threadName="
                        + Thread.currentThread().getName();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){

            }
            System.out.println("string = "+string);
            System.out.println("string1 = " + string1);
        }
    }


    private static class MyThread extends Thread{
        Task task;
        MyThread(String name, Task task){
            super.setName(name);
            this.task = task;
        }
        @Override
        public void run() {
            super.run();
            task.doWork(getName());
        }
    }


    public static void main(String[] args){
        Task task = new Task();
        MyThread myThread = new MyThread("A",task);
        MyThread myThread1 = new MyThread("B",task);
        myThread.start();
        myThread1.start();
    }
}
