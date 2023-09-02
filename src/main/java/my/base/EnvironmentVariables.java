package my.base;

import java.util.Collections;
import java.util.Map;

/**
 * MapOfList
 * 参考《Java编程思想》P242
 */
public class EnvironmentVariables {

    public static void main(String[] args) {
        for(Map.Entry entry: System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
