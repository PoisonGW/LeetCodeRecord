package linkedlist.getKthFromEnd;

/**
 * 从最终获得k
 *
 * @author Poison
 * @date 2023/06/28
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 前置指针 比cur多走k步，当pre为null时，此时cur处于倒数k位置
        ListNode pre = head;
        while (k-- > 0) {
            pre = pre.next;
        }
        while (pre != null) {
            head = head.next;
            pre = pre.next;
        }
        return head;
    }
}
