package my.base;

import javax.xml.stream.FactoryConfigurationError;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class MyException extends Exception {

    private int x;

    public MyException() {}

    public MyException(String msg) { super(msg); }

    public MyException(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int val() { return x; }

    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}

public class LoggingExceptions {

    private static Logger logger = Logger.getLogger("LoggingExceptions");

    static void logException(Exception e) {
        logger.severe(e.getMessage());
    }

    static void logExceptionTrace(Exception e) {
        // 在日志中打印异常追踪的栈轨迹
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    static void f() throws MyException {
        System.out.println("Throwing MyException from f(), none agrs constructor");
        throw new MyException();
    }

    static void g() throws MyException {
        System.out.println("Throwing MyException from g(), String agrs constructor");
        throw new MyException("Throws from g()");
    }

    static void h() throws MyException {
        System.out.println("Throwing MyException from g(), String and int agrs constructor");
        throw new MyException("Throws from h()", 123);
    }


    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            try {
                h();
            } catch (MyException e) {
                e.printStackTrace(System.out);
                System.out.println("e.val() = " + e.val());
                // 通过initCause() 方法将一个异常嵌套在另一个异常中，构成异常链
                NullPointerException npe = new NullPointerException();
                npe.initCause(e);
                // 模拟由于MyException触发NullPointerException，构建异常链
                throw npe;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("handle exception chain");
        }
    }
}
