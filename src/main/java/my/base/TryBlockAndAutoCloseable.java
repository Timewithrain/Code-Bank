package my.base;

import java.io.Closeable;

/** 测试自动关闭实例以及try语句块的关闭顺序 */
public class TryBlockAndAutoCloseable {

    static class Door implements AutoCloseable {
        public void close() {
            System.out.print("D");
            throw new RuntimeException();
        }
    }

    static class Window implements Closeable {
        public void close() {
            System.out.print("W");
            throw new RuntimeException();
        }
    }

    /**
     * 输出结果：TWDEF
     * 在try语句块执行完成后会自动关闭实现了Closeable接口的类，即使抛出RuntimeException也会继续调用close()方法
     */
    static void func() {
        //
        try (Door door = new Door(); Window window = new Window()) {
            System.out.print("T");
        } catch (Exception e) {
            System.out.print("E");
        } finally {
            System.out.print("F");
        }
    }

    public static void main(String[] args) {
        func();
    }
}
