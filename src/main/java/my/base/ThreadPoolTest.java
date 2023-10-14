package my.base;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {

    static void test() {
        /** 定义核心线程数为5，最大线程数为10，非核心线程存活时间60秒的线程池 */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 60,
                                                             TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        ConcurrentHashMap<Object, String> map = new ConcurrentHashMap<>();


        /** 获取一个默认线程池，核心线程为0，最大线程数为10，非核心线程存活时间60秒 */
        ExecutorService executor2 = Executors.newCachedThreadPool();

        /** 获取一个固定线程数量的线程池，核心线程和最大线程数为10 */
        ExecutorService executor3 = Executors.newFixedThreadPool(10);

        AtomicInteger integer = new AtomicInteger();


    }

    public static void main(String[] args) {
        test();
    }
}
