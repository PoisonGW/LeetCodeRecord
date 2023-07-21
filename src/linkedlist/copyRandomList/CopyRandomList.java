package linkedlist.copyRandomList;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 *
 * @author Poison
 * @date 2023/06/29
 */
public class CopyRandomList {
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
//        copyRandomList(n1);
        copyRandomList1(n1);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 存储旧和新 1 1 2 2 3 3 4 4 5 5
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            Node t = new Node(p.val);
            map.put(p, t);
            p = p.next;
        }
        // 根据旧的找到新的
        p = head;
        while (p != null) {
            // 设置新的next    找到旧的next指向谁
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        // 通过旧的头获取新的头
        return map.get(head);
    }

    /**
     * 节点拆分 把一个节点当做两个节点，分别是S和S'
     *
     * @param head 头
     * @return {@code Node}
     */
    public static Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        // 复制节点
        Node cur = head;
        // 1->2->3->4->5
        // 1->1'->2->2'->3->3'->4->4'->5->5'
        while (cur != null) {
            Node t = new Node(cur.val);
            t.next = cur.next;
            cur.next = t;
            // 中间新加了一个，所以要往后走两步
            cur = cur.next.next;
        }
        // 设置random
        cur = head;
        while (cur != null) {
            // S'
            Node newNode = cur.next;
            // S'.random = T'
            newNode.random = (cur.random != null) ? cur.random.next : null;
            cur = newNode.next;
        }

        // 构造返回链表 取出S'，还原原始链表
        Node newHead = head.next;
        Node p = newHead;
        Node r = head;
        // 1->1'->2->2'->3->3'->4->4'->5->5'
        while (r != null) {
            Node node = r.next;
            r = node.next;
            // 还原链表
            head.next = head.next.next;
            head = head.next;
            // 只保留S' 最后一个节点S'需要null判断
            p.next = (node.next != null) ? node.next.next : null;
            p = p.next;
        }
        return newHead;
    }
}
