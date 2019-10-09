package com.lusr.forwin.thread.basicThread;

/**
 * Created by Lusq
 * Date: 2019/8/30
 * description:
 */
public class ThreadVarShared extends Thread {
    /**
     * 原子性操作： 直接单次读写基本数据类型
     * 例如 i = 3;
     * 但是 ++i 或者 --j 或者 j = i 或者 i = i + 1 都不是原子操作，分读取和写操作，都至少两步及以上
     * 无法使用volatile关键字保证复杂操作的原子性
     *
     * 保证原子性： synchronized 或者lock 或者 对volatile对变量的单个读或者写具有原子性
     *
     * 为什么Volatile不能保证原子性：
     * 两个线程A和B，A读取的volatile的值10后阻塞，线程B进行读到10并且自增，此时，值为11，并写会主存
     * 而此时，线程A并没有发生读操作，所以不会从主存中去读取B修改后的值，而A接下来的操作是直接进行加操作
     * 执行完加操作后，直接将值写回主存
     *
     * volatile的两点语义：
     * 当读取一个volatile域时，会将线程工作区的本地内存设置为无效，强制直接存主存中去读取最新的值
     * 当写volatile域时，会将在线程工作内存中的操作，刷新到主存
     *
     * 有序性保障：保证读之前的值，是最新的值，前面的任何写操作都已经完成。且保证写之后，对后面的读是可见的。
     * 此外，内存屏障机制禁止指令重排，原理如下：
     * volatile的实现机制：生成汇编的时候，volatile会生成一个lock前缀指令，相当于一个内存屏障
     * 这个内存屏障，提供：1、lock之后的指令不能重排到lock之前; 2、写入动作会引起别的CPU的cache对应的这个值无效
     *
     * 可见性： volatile/Synchronized/lock都可以保证可见性
     *
     * 参考链接：https://cloud.tencent.com/info/3a3ebb423db98bd11400f1a2d152a708.html
     */
    //此时共享变量,但是原子性不可以使用volatile来保证
    private volatile int count = 5;

    @Override
    public void run() {
        while (count > 0) {
            System.out.println("count = " + getName() + " : " + count--);
        }
    }

    public static void main(String[] args) {
        ThreadVarShared first = new ThreadVarShared();
        Thread thread = new Thread(first, "A");
        Thread thread1 = new Thread(first, "B");
        Thread thread2 = new Thread(first, "C");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
