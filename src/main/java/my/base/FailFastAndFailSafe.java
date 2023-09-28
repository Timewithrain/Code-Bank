package my.base;

import java.util.*;

/**
 * 快速失败和安全失败验证
 */
public class FailFastAndFailSafe {

    /** 测试ArrayList快速失败 */
    static void failFast() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        /* 使用迭代器遍历集合时，调用集合对象进行修改会导致快速失败，抛出ConcurrentModificationException */
//        for (Integer i : list) {
//            if (i.equals(2)) {
//                list.remove(i);
//                list.add(20);
//            }
//        }
        /* 使用迭代器的remove方法可以避免快速失败 */
        while (iterator.hasNext()) {
            if (iterator.next().equals(2)) {
                iterator.remove();
            }
        }
        /* 若希望在迭代过程中插入数据，需要使用ListIterator进行迭代并调用add方法进行添加操作，该add方法是插入数据，而非添加数据 */
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().equals(3)) {
                listIterator.add(100);
            }
        }
        System.out.println(list);
    }

    static void failSafe() {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> sList = Collections.synchronizedList(list);  // 线程安全化


    }


    public static void main(String[] args){
        failFast();

    }
}
