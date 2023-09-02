package my.jvm;

import com.sun.nio.zipfs.ZipInfo;

import java.io.IOException;
import java.io.InputStream;

/**
 * 参考《深入理解JVM》p380
 * 用于展示自定义类加载器以及主要的的类加载器
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        // 实现一个自己的类加载器
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String filename = name.substring(name.lastIndexOf('.') + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(filename);
                    if (inputStream == null) {
                        return super.loadClass(name);  // 委派基类加载器
                    }
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Object obj = myLoader.loadClass("my.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass().getClassLoader());  // my.jvm.ClassLoaderTest$1@74a14482
        System.out.println(obj instanceof my.jvm.ClassLoaderTest);  // false 由于类加载器不同，因此obj不属于my.jvm.ClassLoaderTest实例

        ClassLoaderTest test = new ClassLoaderTest();
        System.out.println(test.getClass().getClassLoader());  // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(test instanceof my.jvm.ClassLoaderTest);  // true


        String str = "123";  // JAVA_HOME/lib 目录下的类，由BootstrapClassLoader加载
        ZipInfo inf = new ZipInfo();  // JAVA_HOME/lib/ext 目录下的类，由ExtClassLoader加载
        ClassLoaderTest tst = new ClassLoaderTest();  // 自定义类，由AppClassLoader加载
        System.out.println(str.getClass().getClassLoader());  // null 由BootstrapClassLoader加载则返回值为null
        System.out.println(inf.getClass().getClassLoader());  // sun.misc.Launcher$ExtClassLoader@14ae5a5
        System.out.println(tst.getClass().getClassLoader());  // sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
