package linkedlist.reverse_linked_list;

import java.util.LinkedList;

/**
 * 反向链表
 *
 * @author Poison
 * @date 2023/06/13
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList<ListNode> linkedList = new LinkedList<>();
        ListNode node1 = new ListNode();
        node1.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 2;
        ListNode node3 = new ListNode();
        node3.val = 3;
        ListNode node4 = new ListNode();
        node4.val = 4;
        ListNode node5 = new ListNode();
        node5.val = 5;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);
//        ListNode node = linkedList.getFirst();
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }
//        ListNode node6 = reverseList(node1);
//        while (node6 != null) {
//            System.out.println(node6.val);
//            node6 = node6.next;
//        }
//        ListNode node7 = reverseList1(node1);
//        while (node7 != null) {
//            System.out.println(node7.val);
//            node7 = node7.next;
//        }
        ListNode node7 = reverseList2(node1);
        while (node7 != null) {
            System.out.println(node7.val);
            node7 = node7.next;
        }
    }

    /**
     * 三指针解法
     *
     * @param head 头
     * @return {@code ListNode}
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head.next;
        ListNode cur = head;
        ListNode later = null;
        while (pre != null) {
            // 每次将current的next反向，指向其前节点。 1 ->2 ->3
            //                                    1 <-2 ->3
            //                                    1 <-2 <-3
            cur.next = later;
            later = cur;
            cur = pre;
            pre = pre.next;
        }
        cur.next = later;
        return cur;
    }

    /**
     * 三指针变形 --》双指针解法
     *
     * @param head 头
     * @return {@code ListNode}
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;// 新链表头
        ListNode cur = head; // 旧链表头
        while (cur != null) {
            ListNode node = cur.next; // 暂存头结点的前一个节点，防止下面修改引用时丢失链表
            cur.next = pre; // 头节点指向尾结点
            pre = cur; // 尾结点变为新链表的头结点
            cur = node;// 头结点变为旧链表新的头结点
        }
        // 返回新链表的头节点
        return pre;
    }

    /**
     * 递归解法
     *
     * @param head 头
     * @return {@code ListNode}
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 返回新的头结点
        ListNode newNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        // 返回头结点 递归每一层返回的都是该头结点，第四层的newNode返回给第三层，第三层newNode的返回给第二层
        return newNode;
    }

}
