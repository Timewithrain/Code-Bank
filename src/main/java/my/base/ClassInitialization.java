package my.base;

import java.util.Random;

/**
 * 参考《Thinking in Java》p319
 */
class Initable {
    static final int staticFinal = 47;  // 由static final修饰的常量为编译器常量，完成类加载后可以直接访问，不会触发初始化

    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);  // 运行时赋值吗，非编译期间常量触发初始化

    static {
        System.out.println("Initializing Initable");
    }
}

class Initiabl2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initiabl3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {

    public static Random rand = new Random(47);

    public static void initiateTest() {
        // 不会触发类初始化
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // 不会触发类初始化
        System.out.println(Initable.staticFinal);
        // 会触发类初始化
        System.out.println(Initable.staticFinal2);
        // 会触发类初始化
        System.out.println(Initiabl2.staticNonFinal);
        try {
            // 会触发类初始化
            Class initable3 = Class.forName("my.base.Initiabl3");
            System.out.println("After creating Initable3 ref");
            System.out.println(Initiabl3.staticNonFinal);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void referenceTest() {
        Class intClass = int.class;
        intClass = double.class;  // 非泛型类引用可以指向其他类型的Class对象

        Class<Integer> genericIntClass = int.class;  // 泛型类引用只能指向声明的类型
        genericIntClass = Integer.class;
        genericIntClass = Integer.TYPE;  // Integer.TYPE等效于int.class
//        genericIntClass = double.class;  // 编译错误

        Class<?> intClass2 = int.class;  // 通配符?等效于Object, Class<?>等效于Class
        intClass2 = double.class;
        intClass2 = Integer.class;
    }

    public static void main(String[] args) {
//        initiateTest();
        referenceTest();
    }

}
