package may.week1;

public class Day5_JumpGame2 {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = 0;
        for (int i=1; i<nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] + j >= i) {
                    if (dp[i] > dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        return dp[nums.length-1];
    }

    public int jumpEfficient(int[] nums) {
        int farthest = 0, end = 0, jump = 0;
        for (int i=0; i<nums.length-1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jump++;
                end = farthest;
            }
        }
        return jump;
    }
}
