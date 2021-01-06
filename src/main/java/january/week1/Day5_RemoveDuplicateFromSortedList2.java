package january.week1;

import utils.ListNode;

public class Day5_RemoveDuplicateFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;

        ListNode p = t;
        while(p.next!=null&&p.next.next!=null){
            if(p.next.val == p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null&&p.next.val==dup){
                    p.next = p.next.next;
                }
            }else{
                p=p.next;
            }

        }
        return t.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2, new ListNode(2));
        root.next.next.next = new ListNode(3, new ListNode(3));
        root.next.next.next.next.next = new ListNode(4);
        Day5_RemoveDuplicateFromSortedList2 obj = new Day5_RemoveDuplicateFromSortedList2();
        System.out.println(obj.deleteDuplicates(root));
    }

}
