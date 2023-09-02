package my.base;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ClassInformation {

    static void printInfo(Class c) {
        System.out.println("Class name: " + c.getName() + " is interface? [" + c.isInterface() + "]");
        System.out.println("Simple name: " + c.getSimpleName());
        System.out.println("Canonical name: " + c.getCanonicalName());
    }

    /**
     * Java反射机制参考：https://docs.oracle.com/javase/tutorial/reflect/index.html
     * 代码参考《Thinking in Java》p316-317
     */
    static void classTest() {
        // 使用反射机制获取类的Class对象
        Class c = null;
        try {
            c = Class.forName("my.base.DerivedFromMyInterface");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find DerivedFromMyInterface");
        }

        // 打印类的信息和其实现的接口的信息
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        System.out.println("=====================================");

        // 获取基类的Class对象，通过基类的Class对象创建基类的实例对象
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Can't instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Can't access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }



    public static void main(String[] args) {
        classTest();

    }
}
