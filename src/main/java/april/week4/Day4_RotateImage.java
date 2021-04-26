package april.week4;

public class Day4_RotateImage {
    public void rotate(int[][] matrix) {
        // first transpose and then reverse rows
        int n = matrix.length;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int k=0; k<n; k++) {
            int i=0, j=n-1;
            while (i < j) {
                int tmp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = tmp;
                i++;
                j--;
            }
        }
    }
}
