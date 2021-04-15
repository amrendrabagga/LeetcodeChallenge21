package april.week2;

import utils.ListNode;

public class Day7_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode higher = new ListNode(0);
        ListNode smallerHead = smaller, higherHead = higher;

        while (head != null) {
            if (head.val < x) {
                // smaller
                smallerHead.next = head;
                smallerHead = smallerHead.next;
            }
            else {
                // higher
                higherHead.next = head;
                higherHead = higherHead.next;
            }
            head = head.next;
        }
        higherHead.next = null;
        smallerHead.next = higher.next;

        return smaller.next;
    }
}
