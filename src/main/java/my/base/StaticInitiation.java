package my.base;

public class StaticInitiation {

    public static void main(String[] args) {
        new B();
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

    {
        System.out.println("init B");
    }

    public B () {
        System.out.println("B class");
    }
}