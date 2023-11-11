package my.base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    static void testIntegerStream() {
//        List<Integer> list = Stream.generate(() -> (int) (Math.random() * 100)).limit(10).collect(Collectors.toList());
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = list.stream();
        Stream<Integer> stream2 = stream.filter((x) -> x % 2 == 0);  // 过滤偶数
        System.out.println(stream2.collect(Collectors.toList()));

    }

    public static void main(String[] args){
        testIntegerStream();

    }
}
