package my.base;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.getHoldCount();
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
    }
}
