package january.week2;

import java.util.HashMap;
import java.util.Map;

public class Day7_MinimumOperationsToReduceXToZero {
    // we want sum from both sides to be equal to x and their length should be min
    // so if we take total_sum and subtract x, this will return sum of continous array in middle
    // so if try to maximise length of subarray with sum = total_sum - x, say res
    // then nums.length - res is our answer
    public int minOperations(int[] nums, int x) {
        int sum = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        for (int i=0; i<n; i++) {
            sum += nums[i];
            map.put(sum, i);
        }
        int target = sum - x;
        if (target < 0) {
            return -1;
        }
        sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
        }
        return res == Integer.MIN_VALUE ? -1 : n - res;
    }

    public int minOperationsEfficient(int[] nums, int x) {// using sliding window
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        if (target < 0) {// all elements are less than x
            return -1;
        }
        int left = 0;
        sum = 0;
        int res = -1;
        for (int i=0; i<n; i++) {
            sum += nums[i];
            while (sum > target) {
                sum -= nums[left++];
            }
            if (sum == target) {
                res = Math.max(res, i - left + 1);
            }
        }
        return res != -1 ? n - res : -1;
    }

    public static void main(String[] args) {
        Day7_MinimumOperationsToReduceXToZero obj = new Day7_MinimumOperationsToReduceXToZero();
        System.out.println(obj.minOperations(new int[]{1,1,4,2,3}, 5));
    }
}
