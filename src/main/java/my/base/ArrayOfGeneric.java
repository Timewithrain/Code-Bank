package my.base;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGeneric {

    static class ListOfGenerics<T> {
        private List<T> list = new ArrayList<>();
        public void add(T t) { list.add(t); }
        public T get(int index) { return list.get(index);}
    }

    /** 参考:《Thinking in Java》15.10 泛型通配符部分代码 */
    static class Fruit {}
    static class Apple extends Fruit {}
    static class Fuji extends Apple {}
    static class Orange extends Fruit {}

    static void f1() {
        // 正常(多态，向上转型)
        ArrayList<Fruit> array = new ArrayList<>();
        array.add(new Fruit());
        array.add(new Apple());
        array.add(new Orange());

        // 使用泛型通配符？，编译不通过。编译器不能通过通配符？推导出确切的持有类型，因此无法像其中添加任何对象(null除外)
        ArrayList<? extends Fruit> array1 = new ArrayList<>();
//        array1.add(new Fruit());
//        array1.add(new Apple());
//        array1.add(new Orange());
//        array1.add(new Object());

        // 使用超类型通配符，告知编译器容器的持有类型为Fruit的某个基类，因此Fruit及其子类型都能被正常放入Collection中
        ArrayList<? super Fruit> array2 = new ArrayList<>();
        array2.add(new Fruit());
        array2.add(new Apple());
        array2.add(new Orange());
//        array2.add(new Object());  // 类型上界为Fruit，Object超过类型边界报错
    }

    /** 参考:《Thinking in Java》P393 GenericWriting部分代码 */
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();
    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }
    static void f2() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }
    static void f3() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

    public static void main(String[] args){
//        f1();
        f2();
        f3();

    }
}
