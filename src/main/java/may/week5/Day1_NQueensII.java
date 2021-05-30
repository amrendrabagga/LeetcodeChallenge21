package may.week5;

public class Day1_NQueensII {
    int count = 0;
    int len;
    public int totalNQueens(int n) {
        len = n;
        int board[][] = new int[n][n];
        dfs(board, 0);
        return count;
    }

    private boolean dfs(int board[][], int row) {
        if (row == len) {
            return true;
        }
        for (int col=0; col<len; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (dfs(board, row + 1)) {
                    count++;
                }
            }
            board[row][col] = 0;
        }
        return false;
    }

    private boolean isSafe(int board[][], int row, int col) {
        for (int i=0; i<=row; i++) {
            // checking if any queen already placed on same column previously
            if (board[i][col] == 1) {
                return false;
            }
            if (row - i >= 0 && col - i >= 0 && board[row-i][col-i] == 1) {
                return false;
            }
            if (row - i >= 0 && col + i < len && board[row-i][col+i] == 1) {
                return false;
            }
        }
        return true;
    }

    boolean diag[];
    boolean antidiag[];
    boolean columns[];
    public int totalNQueensEfficient(int n) {
        len = n;
        diag = new boolean[2*n - 1];
        antidiag = new boolean[2*n - 1];
        columns = new boolean[n];
        dfs(0);
        return count;
    }

    private boolean dfs(int row) {
        if (row == len) {
            return true;
        }
        for (int col=0; col<len; col++) {
            if (!columns[col] && !diag[row + col] && !antidiag[row - col + len - 1]) {
                columns[col] = true;
                diag[row + col] = true;
                antidiag[row - col + len - 1] = true;
                if (dfs(row + 1)) {
                    count++;
                }
                columns[col] = false;
                diag[row + col] = false;
                antidiag[row - col + len - 1] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Day1_NQueensII obj = new Day1_NQueensII();
        System.out.println(obj.totalNQueens(4));
    }
}
