package linkedlist.delete_node;

/**
 * 删除节点
 *
 * @author Poison
 * @date 2023/06/28
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = new ListNode(-1);
        node.next = head;

        ListNode pre = node;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
            }
            pre = cur;
            cur = cur.next;
        }
        return node.next;
    }
}
