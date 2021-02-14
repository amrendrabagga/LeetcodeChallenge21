package february.week2;

import java.util.LinkedList;
import java.util.Queue;

public class Day6_ShortestPathInBinaryMatrix {
    private static final int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
    private static final int dy[] = {1, -1, 0, 0, 1, -1, -1, 1};
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == -1) {
            return -1;
        }
        boolean visited[][] = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int tmp[] = queue.poll();
                if (tmp[0] == m - 1 && tmp[1] == n - 1) {
                    return level;
                }
                for (int d=0; d < dx.length; d++) {
                    int nx = tmp[0] + dx[d];
                    int ny = tmp[1] + dy[d];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny});
                        grid[nx][ny] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Day6_ShortestPathInBinaryMatrix obj = new Day6_ShortestPathInBinaryMatrix();
        System.out.println(obj.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
    }
}
