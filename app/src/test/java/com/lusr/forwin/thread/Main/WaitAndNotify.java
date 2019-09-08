package com.lusr.forwin.thread.Main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

/**
 * Created by Lusq
 * Date: 2019/8/30
 * description:
 */
public class WaitAndNotify {
    private static int cnt = 0;
    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition oddCondition = reentrantLock.newCondition();//奇数
    static Condition eveCondition = reentrantLock.newCondition();//偶数

    /**
     * 两个线程交替打印奇数和偶数
     */
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EveThread eveThread = new EveThread();
        Thread odd = new Thread(oddThread, "奇数");
        Thread eve = new Thread(eveThread, "偶数");
        odd.start();
        eve.start();
        try {
            odd.join();
            eve.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

    private static class OddThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                try {
                    if (cnt <= 100) {
                        if ((cnt & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + "-" + cnt++);
                        } else {
                            eveCondition.signal();
                            oddCondition.await();
                        }
                    } else {
                        eveCondition.signal();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
            System.out.println("结束了奇数");
        }
    }


    private static class EveThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                try {
                    if (cnt <= 100) {
                        if ((cnt & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + "-" + cnt++);
                        } else {
                            oddCondition.signal();
                            eveCondition.await();
                        }
                    } else {
                        oddCondition.signal();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
            System.out.println("结束了偶数");
        }
    }


}
