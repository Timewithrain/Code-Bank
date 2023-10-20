package my.base;

import sun.misc.Unsafe;

import java.io.Closeable;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class SynchronizedListTest {

    static int nThread = 5;

    static int counter = 20000000;

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(nThread, nThread, 60,
            TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

    static final Unsafe U = reflectGetUnsafe();

    /** 非系统ClassLoader加载Unsafe会抛出SecurityException异常，使用反射获取Unsafe */
    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    static Runnable getSYNTask(List<Integer> list) {
        return new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < counter; i++) {
                    synchronized (list) {
                        int tmp = list.get(0);
                        list.set(0, tmp+1);
                    }
                }
            }
        };
    }

    static Runnable getTask(List<Integer> list) {
        return new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < counter; i++) {
//                    int tmp;
//                    while (true) {
//                        tmp = list.get(0);
//                        assert U != null;
//                        // compareAndSwapInt 偏移量计算出错
//                        if (U.compareAndSwapInt(list, U.arrayBaseOffset(Integer[].class), tmp, tmp+1)) {
//                            break;
//                        }
//                    }
                    synchronized (list) {
                        int tmp = list.get(0);
                        list.set(0, tmp+1);
                    }
                }
            }
        };
    }

    /** 测试 ArrayList */
    static void test() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        long start = System.currentTimeMillis();
        for (int i = 0; i < nThread; i++) {
            executor.execute(getSYNTask(list));
        }
        // 等待所有线程运行完毕
        while (executor.getCompletedTaskCount() != nThread) {}
        executor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("time cost: " + (end - start));
        System.out.println("num: " + list.get(0));
        System.out.println("is correct: " + (list.get(0) == nThread*counter));
    }

    /** 测试Vector */
    static void test1() {
        Vector<Integer> vector = new Vector<>();
        vector.add(0);
        long start = System.currentTimeMillis();
        for (int i = 0; i < nThread; i++) {
            executor.execute(getTask(vector));
        }
        // 等待所有线程运行完毕
        while (executor.getCompletedTaskCount() != nThread) {}
        executor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("time cost: " + (end - start));
        System.out.println("num: " + vector.get(0));
        System.out.println("is correct: " + (vector.get(0) == nThread*counter));
    }

    /** 测试synchronized ArrayList */
    static void test2() {
        List<Integer> synList = Collections.synchronizedList(new ArrayList<>());
        synList.add(0);
        long start = System.currentTimeMillis();
        for (int i = 0; i < nThread; i++) {
            executor.execute(getTask(synList));
        }
        while (executor.getCompletedTaskCount() != nThread) {}
        executor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("time cost: " + (end - start));
        System.out.println("num: " + synList.get(0));
        System.out.println("is correct: " + (synList.get(0) == nThread*counter));
    }

    public static void main(String[] args) {
//        test();
//        test1();
//        test2();
        test111();
    }

    static void test111() {



//        Stream<String> stream = Stream.iterate("", (s) -> s+1);
//        System.out.println(stream.limit(2).map(x -> x + "2"));


        Integer i1 = Arrays.asList(1,2,3,4,5).stream().findAny().get();
        synchronized(i1) { // y1
            Integer i2 = Arrays.asList(6, 8, 7, 9, 10)
                    .parallelStream()
                    .sorted() // y2
                    .findAny().get(); // y3
            System.out.println(i1 + " " + i2);
        }
    }



}
