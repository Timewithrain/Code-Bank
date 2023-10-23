package my.base;

import java.lang.annotation.*;

public class Annotation {
}


/** @Retention 定义一个仅在源码中出现的注解 */
@Retention(RetentionPolicy.SOURCE)
/** @Documented 出现在Javadoc中注解 */
@Documented
@interface TestAnnotation {
    String slogan() default "HELLO WORLD";  // 添加slogan属性，定义默认值为HELLO WORLD
}


/**  @Inherited 测试  */
@Inherited
@interface Rich {}

@Rich
class RichParent {}

class RichChild extends RichParent {}


/** @Repeatable 测试 */
@interface Tag {
    Person[]  value();
}

@Repeatable(Tag.class)
@interface Person{
    String role();
}
@Person(role="photographer")
@Person(role="coder")
class StrongMan{}

@FunctionalInterface
interface Function {
    void run();
}
