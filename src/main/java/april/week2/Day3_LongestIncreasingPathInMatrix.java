package april.week2;

public class Day3_LongestIncreasingPathInMatrix {
    private static final int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int cache[][] = new int[m][n];

        int res = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                res = Math.max(res, dfs(matrix, i, j, cache));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int ans = 0;
        for (int k=0; k<4; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];
            if (isSafe(matrix, ni, nj) && matrix[i][j] < matrix[ni][nj]) {
                ans = Math.max(ans, dfs(matrix, ni, nj, cache));
            }
        }
        // including current element
        cache[i][j] = 1 + ans;
        return 1 + ans;
    }

    private boolean isSafe(int[][] matrix, int i, int j) {
        return i >=0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }

    public static void main(String[] args) {
        Day3_LongestIncreasingPathInMatrix obj = new Day3_LongestIncreasingPathInMatrix();
        int d = obj.longestIncreasingPath(new int[][]{{9,9,4}, {6,6,8}, {2,1,1}});
        System.out.println(d);
    }
}
