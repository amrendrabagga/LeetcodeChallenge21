package january.week4;

import utils.ListNode;

public class Day3_MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int len = lists.length;
        int interval = 1;
        // here are first start merging list with interval 1 ie with indexes 0,1  2,3  4,5, here 2 list are merged
        // then we merge with interval 2 ie index 0,2  3,5, here 4 list are merged
        // now with interval 4, 8 list are merged

        // if suppose len is 6
        // first pairs are merged interval=1, index- 0,1  2,3  4,5
        // then 4 pairs merged interval=2, index- 0,2
        // then 8pairs merged interval=4, index- 0,4
        while (interval < len) {
            for (int i=0; i<len-interval; i+=interval*2) {
                merge(lists, i, i + interval);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private void merge(ListNode[] lists, int index1, int index2) {
        ListNode ans = new ListNode(-1);
        ListNode tmp = ans;
        ListNode l1 = lists[index1];
        ListNode l2 = lists[index2];

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmp.next = l2;
                break;
            }
            if (l2 == null) {
                tmp.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            }
            else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        lists[index1] = ans.next;
    }
}
