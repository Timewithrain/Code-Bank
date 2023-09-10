package my.design.singleton;

/**
 * 单例模式
 * 参考《head first设计模式》p173
 */
public class Singleton {

    private static Singleton instance = null;  // 静态变量，用于记录唯一实例

    private Singleton() {}  // 私有构造器，防止外部实例化

    public static Singleton getInstance() {  // 静态方法，用于获取唯一实例
        if (instance==null) {  // 如果唯一实例不存在，则创建，否则返回唯一实例，保证不出现重复实例
            instance = new Singleton();
        }
        return instance;
    }

}
