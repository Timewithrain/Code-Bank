package my.base;

class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer() {}

    public String toString() {
        return "Customer " + id;
    }

    /**
     * 简单工厂模式(生成器)；使用静态方法封装包含构造器的代码
     * Customer类仅包含private构造器因此必须使用生成器获取实例成员 */
    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            public Customer next() {
                return new Customer();
            }
        };
    }
}

public class SimpleGenerator {

    public static void main(String[] args){
        Generator<Customer> generator = Customer.generator();
        Customer c = generator.next();
        System.out.println(c);
    }
}
