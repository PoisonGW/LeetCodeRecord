package linkedlist.reverse_print;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 反向打印链表
 *
 * @author Poison
 * @date 2023/06/28
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        int[] res = new int[len];
        int j = len - 1;
        for (int i = 0; i < len; i++) {
            res[j--] = list.get(i);
        }
        return res;
    }
}
