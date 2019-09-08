package com.lusr.forwin.thread.demo0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Lusq
 * Date: 2019/8/27
 * description:
 */
public class ThreadPools {

    //nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>()
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

    //0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>()
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    //1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>()
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    //corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,new DelayedWorkQueue()
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
}
