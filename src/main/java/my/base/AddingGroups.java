package my.base;

import java.util.*;
import java.util.stream.Collectors;

/**
 * AddingGroups
 * 参考《Java编程思想》P220
 */
public class AddingGroups {

    // 完成《Thingking in Java》P220的AddingGroups代码块

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        // Runs significantly faster, but you can't construct a Collection this way:
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK -- modify an element
        System.out.println(list.getClass().getName());
        // Arrays.asList() returns a fixed-size list(java.util.Arrays$ArrayList), so trying to add elements is not supported.
//        list.add(21); // Runtime error because the underlying array cannot be resized.
        // 可以通过将Arrays.asList()的结果作为构造器的参数，构造一个ArrayList，这样就可以调用add()方法了。
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(16, 17, 18, 19, 20));
        System.out.println(arrayList.getClass().getName());
        arrayList.add(21);

        // int[] -> Integer[]
        int[] nums = {1,2,3,4,5};
        Integer[] nums2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // Integer[] -> List<Integer>
        List<Integer> tmp = new ArrayList<>(Arrays.asList(nums2));

        // int[] -> List<Integer>
        List<Integer> tmp2 = Arrays.stream(nums).boxed().collect(Collectors.toList());

        // Integer[] -> List<Integer> 方法2
        List<Integer> tmp3 = new ArrayList<>(nums2.length);
        Collections.addAll(tmp3, nums2);

        // List<Integer> -> Integer[]
        Integer[] num3 = (Integer[]) tmp2.toArray();

        // List<Integer> -> int[]
        int[] num4 = tmp2.stream().mapToInt(Integer::intValue).toArray();
    }
}
