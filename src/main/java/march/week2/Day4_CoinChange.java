package march.week2;

import java.util.Arrays;

public class Day4_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int m = coins.length, n = amount;
        int lookup;
        for (int i=1; i<=n; i++) {
            for (int j=0; j<m; j++) {
                if (i >= coins[j]) {
                    lookup = dp[i - coins[j]];
                    if (lookup != Integer.MAX_VALUE) {
                        dp[i] = Math.min(1 + lookup, dp[i]);
                    }

                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    public static void main(String[] args) {
        Day4_CoinChange obj = new Day4_CoinChange();
        System.out.println(obj.coinChange(new int[]{2}, 3));

    }
}
