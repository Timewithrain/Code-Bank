package my.base;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {

    static void test() {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor();
//        ConcurrentHashMap<Object, String> map = new ConcurrentHashMap<>();
//        Hashtable<String, String> map = new Hashtable<>();
        HashMap<String, String> map = new HashMap<>();

        map.put(null, null);
        String ans = map.get(null);
        System.out.println(map.containsKey(null));
        System.out.println(ans);

        String bns = map.get("null");
        System.out.println(map.containsKey("null"));
        System.out.println(bns);
    }

    public static void main(String[] args) {
        test();
    }
}
