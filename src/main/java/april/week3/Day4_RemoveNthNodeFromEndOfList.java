package april.week3;

import utils.ListNode;

public class Day4_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode tmp = head;

        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        if (len == 1) {
            return null;
        }
        int d = len - n + 1;
        ListNode prev = null;
        tmp = head;
        int i = 1;
        while (tmp != null) {
            if (i == d) {
                if (prev == null) {
                    head = tmp.next;
                }
                else {
                    prev.next = tmp.next;
                }
                break;
            }
            i++;
            prev = tmp;
            tmp = tmp.next;
        }
        return head;
    }

    public ListNode removeNthFromEndEfficient(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        for (int i=1; i<=n+1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
