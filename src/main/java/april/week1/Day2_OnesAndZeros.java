package april.week1;

public class Day2_OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (String s : strs) {
            int zeros = (int) s.chars().filter(c -> c == '0').count();
            int ones = s.length() - zeros;
            for (int i = m; i>=zeros; i--) {
                for (int j = n; j>=ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Day2_OnesAndZeros obj = new Day2_OnesAndZeros();
        System.out.println(obj.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3));
    }
}
