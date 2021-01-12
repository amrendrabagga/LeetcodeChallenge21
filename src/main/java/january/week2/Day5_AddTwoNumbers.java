package january.week2;

import utils.ListNode;

public class Day5_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int carry = 0;
        ListNode tmp3 = null;
        while (tmp1 != null && tmp2 != null) {
            int n = tmp1.val + tmp2.val + carry;
            if (res == null) {
                res = new ListNode(n % 10);
                tmp3 = res;
                carry = n / 10;
            }
            else {
                tmp3.next = new ListNode(n % 10);
                tmp3 = tmp3.next;
                carry = n / 10;
            }
            tmp2 = tmp2.next;
            tmp1 = tmp1.next;
        }
        while (tmp1 != null) {
            int s = tmp1.val + carry;
            tmp3.next = new ListNode(s % 10);
            tmp3 = tmp3.next;
            carry = s / 10;
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            int s = tmp2.val + carry;
            tmp3.next = new ListNode(s % 10);
            tmp3 = tmp3.next;
            carry = s / 10;
            tmp2 = tmp2.next;
        }
        if (carry != 0) {
            tmp3.next = new ListNode(carry);
        }
        return res;
    }
}
