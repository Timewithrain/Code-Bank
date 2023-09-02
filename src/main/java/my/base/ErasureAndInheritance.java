package my.base;

/**
 * 参考《Thinking in Java》P377
 * @param <T>
 */
class GenericBase<T> {
    private T type;
    public void set(T type) {this.type = type;}
    public T get() {return this.type;}
}

class Derived1<T> extends GenericBase<T> {}

class Derived2 extends GenericBase {}

//class Derived3 extends GenericBase<？> {}

public class ErasureAndInheritance {

    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);
    }
}
