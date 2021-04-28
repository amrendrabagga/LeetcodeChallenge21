package april.week4;

public class Day7_UniquePathsII {
    int m = 0, n = 0;
    int dir[][] = {{0, 1}, {1, 0}};

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        return dfs(obstacleGrid, dp, 0, 0);
    }

    private int dfs(int[][] obstacleGrid, int[][] dp, int i, int j) {
        if (i+1 == m && j+1 == n) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int ans = 0;
        for (int d[] : dir) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (isSafe(ni, nj) && obstacleGrid[ni][nj] == 0) {
                ans += dfs(obstacleGrid, dp, ni, nj);
            }
        }
        return dp[i][j] = ans;
    }

    private boolean isSafe(int i, int j) {
        return i >= 0 && i < m && j>=0 && j < n;
    }

    public static void main(String[] args) {
        Day7_UniquePathsII obj = new Day7_UniquePathsII();
        System.out.println(obj.uniquePathsWithObstacles(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}}));
    }
}
