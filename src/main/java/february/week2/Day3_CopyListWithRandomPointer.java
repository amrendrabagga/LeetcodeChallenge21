package february.week2;

public class Day3_CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // first insert intermediate nodes 1->1'->2->2'->3->3'
        Node tmp = head;
        while (tmp != null) {
            Node nxt = tmp.next;
            tmp.next = new Node(tmp.val);
            tmp.next.next = nxt;
            tmp = nxt;
        }
        // connect random pointer for intermediate new node
        // ex for connecting random
        // 1'->random = 1->random->3->next->3'
        tmp = head;
        while (tmp != null) {
            if (tmp.random != null) {
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }
        // extracting intermediate nodes and restoring old linked list
        Node ans = new Node(0);
        tmp = ans;
        while (head != null) {
            tmp.next = head.next;
            tmp = tmp.next;

            head.next = head.next.next;
            head = head.next;
        }
        return ans.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
