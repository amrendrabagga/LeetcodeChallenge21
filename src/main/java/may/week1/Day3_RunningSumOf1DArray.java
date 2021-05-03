package may.week1;

public class Day3_RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int sum = nums[0];
        int res[] = new int[nums.length];
        res[0] = sum;
        for (int i=1; i<nums.length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }
}
