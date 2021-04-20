package april.week3;

import java.util.Arrays;

public class Day5_CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);
        return dfs(nums, target, dp);
    }

    private int dfs(int[] nums, int target, int []dp) {
        if (target == 0) {
            return 1;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            if (target >= nums[i]) {
                ans += dfs(nums, target - nums[i], dp);
            }
        }
        return dp[target] = ans;
    }

    public static void main(String[] args) {
        Day5_CombinationSumIV obj = new Day5_CombinationSumIV();
        System.out.println(obj.combinationSum4(new int[]{1, 2, 3, 4}, 4));

    }
}
