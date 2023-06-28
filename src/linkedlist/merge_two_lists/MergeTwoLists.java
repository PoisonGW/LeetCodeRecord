package linkedlist.merge_two_lists;


/**
 * 合并两个列表
 *
 * @author Poison
 * @date 2023/06/28
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 合并剩下的list1
        if (list1 != null) {
            cur.next = list1;
        }
        // 合并剩下的list2
        if (list2 != null) {
            cur.next = list2;
        }
        return res.next;
    }

    /**
     * 递归解法
     *
     * @param list1 list1
     * @param list2 用于
     * @return {@code ListNode}
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }
}
