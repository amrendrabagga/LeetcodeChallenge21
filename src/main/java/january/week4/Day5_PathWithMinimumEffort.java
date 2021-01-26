package january.week4;

import java.util.LinkedList;
import java.util.Queue;

public class Day5_PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int l = 0, r = 1000001;
        while (l < r) {
            int limit = (l + r)/2;
            if (isGood(heights, limit)) {
                r = limit;
            }
            else {
                l = limit + 1;
            }
        }
        return l;
    }
    int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private boolean isGood(int[][] heights, int limit) {
        int R = heights.length;
        int C = heights[0].length;

        boolean visited[][] = new boolean[R][C];
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            if (x == R-1 && y == C-1) {
                return true;
            }
            for (int []d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny]) {
                    if (Math.abs(heights[x][y] - heights[nx][ny]) <= limit) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return false;
    }
}
