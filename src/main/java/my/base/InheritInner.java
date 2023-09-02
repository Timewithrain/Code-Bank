package my.base;

/**
 * InheritInner
 * 参考《Java编程思想》P212
 */
class WithInner {
    class Inner {}
}

class WithoutInner {}

class InheritWithoutInner extends WithoutInner {
    InheritWithoutInner() {
        //! super(); // Won't compile
    }
}

public class InheritInner extends WithInner.Inner{
    // Won't compile
    //! InheritInner() {}
    InheritInner(WithInner wi) {
        wi.super();
    }
    public static void main(String[] args) {
        // 必须使用外部类的对象来创建内部类对象
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);

        WithInner.Inner inner = wi.new Inner();
        // 非内部类，可以直接创建
        InheritWithoutInner iwoi = new InheritWithoutInner();
    }
}
