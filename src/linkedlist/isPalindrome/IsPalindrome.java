package linkedlist.isPalindrome;

import java.util.List;

/**
 * 是回文
 *
 * @author Poison
 * @date 2023/06/28
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.println(isPalindrome(n1));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 统计长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        // 如果是偶数 1 2 3 3 2 1 len=6 len/2 = 3
        // 奇数 1 2 3 4 3 2 1 len = 7 len/2 = 3
        // 反转前半部分
        int mod = len / 2;
        cur = head;
        ListNode pre = null;
        ListNode tmp;
        while (mod-- > 0) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // 遍历pre cur 比较是否相等
        // 如果是奇数 cur 继续往前一步
        if ((len & 1) == 1) {
            cur = cur.next;
        }
        while (cur != null) {
            if (cur.val != pre.val) {
                return false;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return true;
    }

    /**
     * 快慢指针
     *
     * @param head 头
     * @return boolean
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode firstEndNode = getEndNode(head);
        ListNode secondStartNode = reverseList(firstEndNode.next);

        // 遍历比较反转之后的是否相等
        ListNode cur = head;
        ListNode p = secondStartNode;
        boolean res = true;
        while (res && p != null) {
            if (p.val != cur.val) {
                res = false;
            }
            p = p.next;
            cur = cur.next;
        }
        // 恢复翻转的链表
        firstEndNode.next = reverseList(secondStartNode);
        return res;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private ListNode getEndNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
