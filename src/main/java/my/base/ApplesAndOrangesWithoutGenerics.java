package my.base;

import java.util.ArrayList;

class Apple {
    private static long counter;
    private final long id = counter++;
    public long id() { return id; }
}

class Orange {}

public class ApplesAndOrangesWithoutGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i=0; i<3; i++) {
            list.add(new Apple());
        }
        // Not prevented from adding an Orange to apples:
        // 未使用泛型，可以添加任何类型的对象，编译器不会报错
        list.add(new Orange());
        for (int i=0; i<list.size(); i++) {
            ((Apple)list.get(i)).id();
            // Orange is detected only at run time
        }
    }
}
