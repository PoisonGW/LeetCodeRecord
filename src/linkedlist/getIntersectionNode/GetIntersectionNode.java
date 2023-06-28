package linkedlist.getIntersectionNode;

/**
 * 两个链表的第一个公共节点
 *
 * @author Poison
 * @date 2023/06/28
 */
public class GetIntersectionNode {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 你变成我，走过我走过的路。
         * 我变成你，走过你走过的路。
         * 然后我们便相遇了.
         */
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
