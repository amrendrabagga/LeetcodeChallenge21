package january.week1;

import utils.ListNode;

public class Day4_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode res = null;
        ListNode current = null;
        while (tmp1 != null && tmp2 != null) {
            if (res == null) {
                if (tmp1.val < tmp2.val) {
                    res = new ListNode(tmp1.val);
                    current = res;
                    tmp1 = tmp1.next;
                }
                else {
                    res = new ListNode(tmp2.val);
                    current = res;
                    tmp2 = tmp2.next;
                }
            }
            else if (tmp1.val < tmp2.val) {
                current.next = tmp1;
                current = current.next;
                tmp1 = tmp1.next;
            }
            else {
                current.next = tmp2;
                current = current.next;
                tmp2 = tmp2.next;
            }
        }
        while (tmp1 != null) {
            current.next = tmp1;
            current = current.next;
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            current.next = tmp2;
            current = current.next;
            tmp2 = tmp2.next;
        }
        return res;
    }
}
