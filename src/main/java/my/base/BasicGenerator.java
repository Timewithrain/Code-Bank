package my.base;

import java.lang.reflect.Constructor;
import java.util.List;

class Bean {
    private String name;

    public Bean() {
        this.name = "Default Bean";
    }

    public Bean(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    private List<Class> parameterTypes;

    private Constructor<T> constructor;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    public BasicGenerator(Class<T> type, Class<?>... parameterTypes) throws NoSuchMethodException {
        this.type = type;
        this.constructor = type.getConstructor(parameterTypes);
    }

    public static <T> BasicGenerator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }

    public static <T> BasicGenerator<T> create(Class<T> type, Class<?>... parameterTypes) {
        try {
            return new BasicGenerator<>(type, parameterTypes);
        } catch (NoSuchMethodException e) {
            // 若parameterTypes对应的有参构造函数不存在则调用无参构造函数
            try {
                return new BasicGenerator<>(type);
            } catch (Exception e1) {
                e.initCause(e1);
                throw new RuntimeException(e);
            }
        }
    }

    public T next() {
        try {
            /**调用newInstance()时，type必须有无参构造方法，否则会抛出IllegalAccessException和InstantiationException异常
             * type不能是抽象类、接口、数组、基本类型、void，否则抛出IllegalArgumentException异常
             * 若type没有无参构造方法，可以使用type.getConstructor()获取有参构造方法，然后使用Constructor.newInstance()创建对象
             */
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过有参构造方法创建对象，使用时需要保证有参构造方法的参数类型和参数个数与调用时传入的参数类型和参数个数一致
     * @param args
     * @return
     */
    public T next(Object... args) {
        try {
            return constructor.newInstance(args);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        BasicGenerator<Bean> generator = new BasicGenerator<>(Bean.class, String.class);
        Bean bean = generator.next("Hello World");
        System.out.println(bean);
    }

}
