package my.base;

/** 腾讯二面：使用两个线程顺序打印字符 */
public class ThreadPrint {

    static Object lock = new Object();
    static volatile boolean flag = true;

    /** 自旋等待，实现同步 */
    static void func() {
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 1; i <= 52; i++) {
                    while (!flag) {}
                    synchronized (lock) {
                        System.out.printf("%d ", i);
                        if (i%2 == 0) {
                            flag = false;
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 26; i++) {
                    while (flag) {}
                    synchronized (lock) {
                        System.out.printf("%c ", 'A'+i);
                        flag = true;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }

    /** 阻塞实现同步 */
    static void func2() {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 1; i <= 52; i++) {
                        synchronized (lock) {
                            while (!flag) lock.wait();
                            System.out.printf("%d ", i);
                            if (i%2 == 0) {
                                flag = false;
                                lock.notifyAll();
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 26; i++) {
                        synchronized (lock) {
                            while (flag) lock.wait();
                            System.out.printf("%c ", 'A'+i);
                            flag = true;
                            lock.notifyAll();
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args){
//        func();
        func2();
    }
}
