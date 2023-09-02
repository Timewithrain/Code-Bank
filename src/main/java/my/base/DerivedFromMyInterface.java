package my.base;

interface MyInterface {

    // JDK 8 新特性：接口中可以定义默认方法，接口的实现类可以不重写默认方法
    default void testDefaultMethod() {
        System.out.println("default method");
    }

    // JDK 8 新特性：接口中可以定义静态方法
    static void testStaticMethod() {
        System.out.println("static method");
    }

    void throwNoExceptionMethod();

    void throwExceptionMethod();
}

public class DerivedFromMyInterface implements MyInterface{

    static void testStaticMethod() {
        System.out.println("derived static method");
    }

    /**
     * 实现接口方法时，若接口方法未定义异常，则实现类方法不能定义抛出的uncheck异常列表
     * 但对于RuntimeException及其子类、Error及其子类，可以不遵守该规则
     * @throws NullPointerException
     */
    public void throwNoExceptionMethod() throws NullPointerException, OutOfMemoryError {
        System.out.println("throwExceptionMethod");
    }

    /**
     * compile error
     * 接口方法未定义异常列表，实现类方法抛出Uncheck异常会编译出错
     */
    public void throwExceptionMethod(){}
//    public void throwExceptionMethod() throws Exception {
//        System.out.println("throwExceptionMethod");
//    }

    public static void main(String[] args) {
        MyInterface.testStaticMethod();
        DerivedFromMyInterface.testStaticMethod();
        DerivedFromMyInterface derivedFromMyInterface = new DerivedFromMyInterface();
        derivedFromMyInterface.testDefaultMethod();
    }
}
