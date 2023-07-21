package linkedlist.addTwoNumbers;

/**
 * @Classname AddTwoNumbers
 * @Description
 * @Date 2023/7/21 21:43
 * @Created by Poison
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l111 = new ListNode(3);
        l1.next = l11;
        l11.next = l111;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l211 = new ListNode(4);
        l2.next = l21;
        l21.next = l211;

        ListNode head = addTwoNumbers(l1, l2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 同时向后遍历两个链表 逐位相加
        ListNode res = new ListNode(0);
        ListNode head = res;
        // 相加进位标记
        int carryNumber = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            // 如果有一个链表已经遍历完毕 另一个链表还没有遍历完成 为已经遍历完成的链表添加虚拟0节点
            if (l1.next == null && l2.next != null) {
                ListNode t = new ListNode(0);
                l1.next = t;
            }
            if (l1.next != null && l2.next == null) {
                ListNode t = new ListNode(0);
                l2.next = t;
            }
            sum = l1.val + l2.val + carryNumber;

            // 避免进位被重复使用
            carryNumber = 0;
            if (sum >= 10) {
                carryNumber = 1;
            }

            sum %= 10;
            // 创建新链表节点
            ListNode node = new ListNode(sum);
            head.next = node;
            head = head.next;

            // 向后遍历
            l1 = l1.next;
            l2 = l2.next;

        }
        // 判断是否还有进位，如果有新增节点1
        if (carryNumber != 0) {
            ListNode node = new ListNode(1);
            head.next = node;
            head = head.next;
        }
        return res.next;
    }
}
