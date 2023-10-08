package my.leet;

import my.leet.utils.ListNode;

/** 2. 两数之和 */
public class AddTwoNumbers {

    /** 新构造一个链表存储结果 */
    static ListNode func(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode p = ans;
        boolean flag = false;  // 使用flag保存进位
        while (l1!=null && l2!=null) {
            int val = l1.val + l2.val;
            if (flag) val += 1;
            if (flag = (val > 9)) {
                val %= 10;
            }
            p.next = new ListNode(val);
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        while (l1!=null) {
            int val = l1.val;
            if (flag) val += 1;
            if (flag = (val > 9)) {
                val %= 10;
            }
            p.next = new ListNode(val);
            l1 = l1.next;
            p = p.next;
        }
        while (l2!=null) {
            int val = l2.val;
            if (flag) val += 1;
            if (flag = (val > 9)) {
                val %= 10;
            }
            p.next = new ListNode(val);
            l2 = l2.next;
            p = p.next;
        }
        if (flag) {
            p.next = new ListNode(1);
        }
        return ans.next;
    }

    /** 使用较长的链表存储结果，节省内存 */
    static ListNode func2(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, ans = new ListNode();
        ListNode pre1 = p1, pre2 = p2;  // 设置pre指针保存前一个节点，用于仅为情况下添加最后的节点
        boolean flag = false;  // 记录进位信息
        while (p1 != null || p2 != null) {
            int val = p1.val + p2.val;
            if (flag) val++;
            if (flag = val>9) {
                val %= 10;
            }
            p1.val = val;
            p2.val = val;
            pre1 = p1;
            pre2 = p2;
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null) {  // 若l1遍历结束，则选则l2作为存储结果的链表
                ans.next = l2;
                break;
            }
            if (p2 == null) {
                ans.next = l1;
                break;
            }
        }
        ListNode p = p2, pre = pre2;  // 循环中先判断l1为空，将l2设为存储结果的链表，因此此处也必须先将pre设置为pre2
        if (p1 != null) {  // 若p1不为空则说明循环至p2为空时跳出，将pre置为pre1
            p = p1;
            pre = pre1;
        }
        while (p != null && flag) {  // 继续计算剩余需要进位的结果
            p.val++;
            if (flag = p.val>9) p.val %= 10;
            if (pre != p) pre = pre.next;
            p = p.next;
        }
        if (flag) pre.next = new ListNode(1);  // 最后还需要进位，添加新节点保存进位得到的最高位
        return ans.next;
    }

    public static void main(String[] args) {
        int[] a = {9,9,9,9,9,9,9};  // {5};  // {2,4,3};  //
        int[] b = {9,9,9,9};  // {5};  // {5,6,4};  //
        ListNode l1 = ListNode.constructLinkedList(a);
        ListNode l2 = ListNode.constructLinkedList(b);
        ListNode ans = func2(l1, l2);
        ListNode.printLinkedList(ans);
    }
}
