package january.week3;

import java.util.PriorityQueue;

public class Day2_KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(k);
        for (int num : nums) {
            if (pq.isEmpty()) {
                pq.offer(num);
            }
            else {
                pq.offer(num);
                int size = pq.size();
                while (size-- > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
