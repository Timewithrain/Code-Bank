package my.base;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    static class MyThread extends Thread {
        private static Integer ticket = 5;

        @Override
        public void run() {
            super.run();
//            synchronized (ticket) {  // 加锁后实现同步
                while (ticket > 0) {
                    System.out.println("Rest Ticket:" + ticket--);
                }
//            }
        }
    }

    // 对静态变量ticket进行未加锁的多线程操作，出现多线程错误
    static void test1() throws InterruptedException {
        new MyThread().start();
        new MyThread().start();

        Thread.sleep(500);
        System.out.println(MyThread.ticket);
    }

    static class MyThread2 implements Runnable {

        public Integer ticket = 5;

        @Override
        public void run() {
            while (ticket>0) {
                System.out.println("Rest Ticket:" + ticket--);
            }
        }
    }

    static void test2() throws InterruptedException {
        // 对同一个mt的ticket操作，同样会出现多线程错误
        MyThread2 mt = new MyThread2();
        new Thread(mt).start();
        new Thread(mt).start();

        // 无法获取最终结果，需要通过睡眠以等待线程运行结束
        Thread.sleep(1000);
        System.out.println(mt.ticket);
    }

    static void test3() throws ExecutionException, InterruptedException {
        /**
         * 使用FutureTask，实现自RunnableFuture接口同时包含Runnable和Future的特性，可以获取任务运行结束后的返回结果
         */
        // 常规写法
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            private Integer target = 100;
            @Override
            public Integer call() throws Exception {
                // 计算1到target的累加和
                Integer result = 0;
                for (int i = 1; i <= this.target; i++) {
                    result += i;
                }
                return result;
            }
        });
        new Thread(task).start();
        System.out.println(task.get());

        // 使用lambda表达式
        FutureTask<Integer> task2 = new FutureTask<>(() -> {
            Integer target = 200;
            Integer result = 0;
            for (int i = 1; i <= target; i++) {
                result += i;
            }
            return result;
        });

        new Thread(task2).start();
        System.out.println(task2.get());
    }

    static void test4() {
        Thread t = new Thread(new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println("hello");
                return 0;
            }
        }));
        t.start();

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();
//        test2();
        WithInner wi = new WithInner();
//        test3();

    }
}
