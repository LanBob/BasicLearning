package com.lusr.forwin.thread.demo0;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Lusq
 * Date: 2019/8/27
 * description:
 */
public class FutureAndCallAble {
    public static void main(String[] a) throws ExecutionException, InterruptedException {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return 10;
            }
        };
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
