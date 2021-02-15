package february.week3;

import java.util.PriorityQueue;

public class Day1_TheKWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.count == p2.count ? p1.index - p2.index : p1.count - p2.count);
        for (int i=0; i<mat.length; i++) {
            int count = 0;
            for (int t : mat[i]) {
                if (t == 1) {
                    count++;
                }
            }
            pq.offer(new Pair(i, count));
        }

        int res[] = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = pq.poll().index;
        }
        return res;
    }
    static class Pair {
        int index;
        int count;
        Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
