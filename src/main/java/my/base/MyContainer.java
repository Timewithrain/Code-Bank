package my.base;

import java.util.*;

class CountedInteger {
    private static long counter;
    private final long id = counter++;
    public String toString() {
        return Long.toString(id);
    }
}

public class MyContainer<T> {

    private Class<T> type;

    private List<T> list;

    public MyContainer(Class<T> type) {
        this.type = type;
        this.list = new ArrayList<>();
    }

    public Class<T> getType() {
        return type;
    }

    public void add(T t) {
        list.add(t);
    }

    // 可变参数列表实现add方法
    public void add(T... args) {
        for (T t : args) {
            list.add(t);
        }
    }

    public void remove(T t) {
        list.remove(t);
    }

    public String toString() {
        return Arrays.toString(list.toArray());
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        MyContainer<CountedInteger> container = new MyContainer<>(CountedInteger.class);
        for (int i=0; i<15; i++) {
            container.add(container.getType().newInstance());
        }
        container.add(new CountedInteger(), new CountedInteger(), new CountedInteger());
        System.out.println(container);
    }


}
