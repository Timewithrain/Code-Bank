package my.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/** 380. O(1)时间插入、删除、取随即元素 */
public class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        int idx = list.size();
        map.put(val, idx);
        list.add(val);
        return true;
    }

    /** 删除list时，将最后一个元素转移至带删除元素处，删除最后一个元素 */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        int tail = list.get(list.size()-1);
        list.set(idx, tail);
        list.remove(list.size()-1);
        map.put(tail, idx);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int idx = random.nextInt(list.size()-1);
        return list.get(idx);
    }

    public static void main(String[] args) {

    }
}
