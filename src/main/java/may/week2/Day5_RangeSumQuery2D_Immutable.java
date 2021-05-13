package may.week2;

public class Day5_RangeSumQuery2D_Immutable {
    // 1, 2, 3, 4
    // 2
    // 3
    // 4
    int [][]matrix;
    public Day5_RangeSumQuery2D_Immutable(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<m; i++) {
            for (int j=1; j<n; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        for (int j=0; j<n; j++) {
            for (int i=1; i<m; i++) {
                matrix[i][j] += matrix[i-1][j];
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // (row2, col2) - ((row1-1, col2) + (row2, col1-1) - (row1-1, col1-1))
        int total = matrix[row2][col2];
        int extra = (row1!=0 ? matrix[row1-1][col2] : 0) + (col1!=0 ? matrix[row2][col1-1] : 0) - ((row1!=0 && col1!=0) ? matrix[row1-1][col1-1] : 0);

        return total - extra;
    }
}
