package april.week4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Day5_FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int i=0;
        for (; i<n-1; i++) {
            int diff = heights[i+1] - heights[i];
            if (diff < 0) {
                continue;
            }
            else {
                if (bricks >= diff) {
                    pq.offer(diff);
                    bricks -= diff;
                }
                else if (ladders > 0) {
                    if (pq.size() > 0) {//if already bricks used
                        int currentBricks = pq.peek();
                        if (currentBricks > diff) {
                            bricks += currentBricks;
                            pq.poll();
                            pq.offer(diff);
                            bricks -= diff;
                        }

                    }
                    ladders--;
                }
                else {
                    return i;
                }
            }
        }
        return i;
    }
}
