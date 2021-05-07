package may.week1;

import utils.ListNode;
import utils.TreeNode;

public class Day6_ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return sortedListToBSTUtils(head, null);
    }

    private TreeNode sortedListToBSTUtils(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBSTUtils(head, slow);
        root.right = sortedListToBSTUtils(slow.next, tail);

        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5, new ListNode(9));

        Day6_ConvertSortedListToBST obj = new Day6_ConvertSortedListToBST();
        System.out.println(obj.sortedListToBST(head));

    }
}
