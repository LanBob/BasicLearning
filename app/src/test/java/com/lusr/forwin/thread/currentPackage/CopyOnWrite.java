package com.lusr.forwin.thread.currentPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList
 * 在写数据时，对对象加锁，将整个数组进行复制，然后修改，修改后写回
 * 在读数据时，不进行加锁，所以不会阻塞，但是读到的都是旧数据
 * <p>
 * 所以，读多写少的时候，性能更好
 *
 * Collections.synchronizedList 写多读少的时候，性能更加
 *
 *
 *
 *
 *
 *
 * 实现同步的方式：
 * 1、wait/notify
 * 2、Condition的await和signal
 * 3、信号量，semaphore，作用是设置一个计数，例如5，那么就只有五个线程可以执行
 * 每次要执行一个线程时，要先s.acquire(),获得一个许可，然后变成4，然后再释放
 * s.release()，释放许可
 * 4、循环栅栏，CylicBarrier,设置一个数目，例如5，那么就凑够五个任务在进行执行
 * 在线程体中，调用mCylicBarrier.await()方法即可
 * 5、CountDownLatch 闭锁，设置一个数目，例如5，在主线程调用countDownLatch.await
 * 主线程就会等待5个任务执行完后，在继续执行，然后在每次线程体执行完后，就将
 * countDownLatch.countDown()
 *
 * 区别：
 * 闭锁是等待其他1~N个线程执行完，循环栅栏是允许多个线程相互等待
 * 闭锁不可以重新设计计数，而循环栅栏可以重新设置
 */

public class CopyOnWrite {
    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
    ArrayList arrayList = new ArrayList();
    ArrayList list;

    void say() {
        list = (ArrayList) Collections.synchronizedList(arrayList);
    }
}
