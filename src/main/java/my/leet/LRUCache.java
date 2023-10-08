package my.leet;

import java.util.HashMap;

/**
 * 146. LRU缓存机制
 * 要求get()和put()均为O(1)时间复杂度
 * 使用HashMap + 双向链表实现
 */
public class LRUCache {
    private int capacity;
    private int size;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;

    class Node {  // 自定义双链表节点，保证插入删除为O(1)时间复杂度
        public int key;
        public int value;
        public Node next;
        public Node prev;
        public Node() {}
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();  // 使用fake节点，保证操作的一致性
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /** 若不存在返回-1，若存在，使用map以O(1)时间获取节点，并将其添加至链表头 */
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    /** 放入节点，若存在，更新节点值，否则插入新节点 */
    public void put(int key, int value) {
        if (map.containsKey(key)) {  // 若map中存在该键，更新value，将其移动至链表头
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {  // 若map不存在该键，新建node，将其防止链表头
            Node node = new Node(key, value);
            map.put(key, node);
            moveToHead(node);
            size++;
            if (size > capacity) {  // 若cache容量已满，则删除链表尾节点
                map.remove(tail.prev.key);
                removeTail();
                size--;
            }
        }
    }

    public void deLinked(Node node) {  // 将节点从链表中移除
        Node pre = node.prev, nex = node.next;
        if (pre!=null) pre.next = nex;
        if (nex!=null) nex.prev = pre;
        node.prev = null;
        node.next = null;
    }

    public void moveToHead(Node node) {  // 将节点添加至链表头
        deLinked(node);
        Node neck = head.next;
        head.next = node;
        node.prev = head;
        node.next = neck;
        neck.prev = node;
    }

    public void removeTail() {  // 删除链表尾节点
        Node butt = tail.prev.prev, node = tail.prev;
        butt.next = tail;
        tail.prev = butt;
        node.next = null;
        node.prev = null;
    }

    static void test() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    static void test2() {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    static void test3() {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

//        System.out.println(cache.get(2));
//        cache.put(2, 6);
//        System.out.println(cache.get(1));
//        cache.put(1, 5);
//        cache.put(1, 2);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));
//        cache.put(1, 1);
//        cache.put(4, 1);
//        System.out.println(cache.get(2));
    }

    public static void main(String[] args) {
        test3();

    }

}
