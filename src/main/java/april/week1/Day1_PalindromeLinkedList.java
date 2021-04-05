package april.week1;

import utils.ListNode;

import java.util.Stack;

public class Day1_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stk = new Stack();
        ListNode tmp = head;
        while (tmp != null) {
            stk.push(tmp.val);
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            if (stk.pop() != tmp.val) {
                return false;
            }
            tmp = tmp.next;
        }
        return true;
    }
}
