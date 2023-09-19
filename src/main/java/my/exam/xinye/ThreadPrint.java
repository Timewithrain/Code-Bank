package my.exam.xinye;

/** 多线程打印
 * 启动三个线程，分别打印A，B，C，循环打印10次，保证打印结果的ABC顺序不变
 */
public class ThreadPrint {

    private static Object lock = new Object();
    private static int cur = 0;

    static class PrintTask implements Runnable{
        private char c;
        private int n;

        public PrintTask(char c, int n) {
            this.c = c;
            this.n = n;
        }

        @Override
        public void run() {
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (cur%3 != n) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.printf("%c", c);
                    cur++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args){
        Thread thread1 = new Thread(new PrintTask('A', 0));
        Thread thread2 = new Thread(new PrintTask('B', 1));
        Thread thread3 = new Thread(new PrintTask('C', 2));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
