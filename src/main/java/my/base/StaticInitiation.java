package my.base;

public class StaticInitiation {

    public static void main(String[] args) {
        //new B();
        C.print();
    }
}

class A {
    static {
        System.out.println("static init A");
    }

    {
        System.out.println("init A");
    }

    public A () {
        System.out.println("A class");
    }
}

class B extends A {
    static {
        System.out.println("static init B");
    }

    C c = new C();

    {
        System.out.println("init B");
    }

    public B () {
        System.out.println("B class");
    }
}

class C {
    static {
        System.out.println("static init C");
    }

    {
        System.out.println("init C");
    }

    public C () {
        System.out.println("C class");
    }

    static void print() {
        System.out.println("print C");
    }

}