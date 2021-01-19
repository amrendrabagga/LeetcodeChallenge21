package january.week3;

public class Day5_LongestPalindromicString {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
        }
        int m = 1;
        int start = 0;
        for (int i=0; i<n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                m = 2;
                start = i;
            }
        }

        for (int l=3; l<=n; l++) {
            for (int i=0; i<n-l+1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if (j - i + 1 > m) {
                        m = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + m);
    }
}
