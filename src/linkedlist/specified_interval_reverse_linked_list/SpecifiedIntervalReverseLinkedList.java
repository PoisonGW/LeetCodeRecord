package linkedlist.specified_interval_reverse_linked_list;

import java.util.Arrays;
import java.util.List;

/**
 * 指定区间反向链接列表
 *
 * @author Poison
 * @date 2023/06/27
 */
public class SpecifiedIntervalReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node1;
        node1.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseBetween(head, 2, 4);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (head == null || head.next == null || m == n) {
            return head;
        }
        // 添加链表头
        ListNode res = new ListNode(-1);
        res.next = head;
        // 开始反转的链表的头
        ListNode pre = res;
        // 开始反转的链表的前一个节点
        ListNode cur = head;
        // 找到m位置
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        // 反转链表
        for (int i = m; i < n; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return res.next;
    }
}
