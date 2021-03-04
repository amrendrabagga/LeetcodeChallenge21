package march.week1;

import utils.ListNode;

public class Day4_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0, b = 0;
        ListNode tmpA = headA, tmpB = headB;
        while (tmpA != null) {
            a++;
            tmpA = tmpA.next;
        }
        while (tmpB != null) {
            b++;
            tmpB = tmpB.next;
        }
        if (b > a) {
            return getIntersectionNode(headB, headA, b - a);
        }
        return getIntersectionNode(headA, headB, a - b);
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB, int d) {
        ListNode tmpA = headA, tmpB = headB;
        while (d-- > 0) {
            tmpA = tmpA.next;
        }
        while (tmpA != null && tmpB != null) {
            if (tmpA == tmpB) {
                return tmpA;
            }
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return null;
    }
}
