package my.design.singleton;

/**
 * 多线程优化的单例模式
 * 参考《Head First设计模式》p182
 */
public class ConcurrentSingleton {

    private static volatile ConcurrentSingleton instance = null;  // 使用volatile保证instance在所有线程中同步

    private ConcurrentSingleton() {}  // 私有构造器，防止外部实例化

    /** 双重检查加锁 */
    public static ConcurrentSingleton getInstance() {
        if (instance==null) {
            synchronized (ConcurrentSingleton.class) {  // 使用synchronized保证多线程环境下的同步
                if (instance==null) {
                    instance = new ConcurrentSingleton();
                }
            }
        }
        return instance;
    }

}
