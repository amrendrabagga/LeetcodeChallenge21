package march.week4;

public class Day6_PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int res = n;

        boolean dp[][] = new boolean[n][n];
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
        }
        for (int i=0; i<n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                res++;
            }
        }
        for (int l=3; l<=n; l++) {
            for (int i=0; i<n-l+1; i++) {
                int j = i + l - 1;
                // for substring palindromic check
                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
