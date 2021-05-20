package may.week3;

import java.util.Arrays;

public class Day5_MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int steps = 0;
        int median = n % 2 == 0 ? (nums[n/2] + nums[n/2-1]) / 2 : nums[n/2];
        for (int num : nums) {
            steps += Math.abs(num - median);
        }
        return steps;
    }
}
