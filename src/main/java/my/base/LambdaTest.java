package my.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

    static void func() {
        int[] arr = new int[]{1,2,7,6,8,3,9,4,5};
        // int[] -> List<Integer>
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        // 正序
        list.sort((o1, o2) -> o1 - o2);
        System.out.println(list);

        // 倒序
        list.sort((o1, o2) -> o2 - o1);
        System.out.println(list);


    }

    public static void main(String[] args){

        func();

    }
}
