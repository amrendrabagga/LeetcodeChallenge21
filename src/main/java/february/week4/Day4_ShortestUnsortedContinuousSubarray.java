package february.week4;

import java.util.Arrays;

public class Day4_ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int snums[] = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != snums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start >= 0 ? end - start + 1 : 0;
    }

    public int findUnsortedSubarrayEfficient(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                min = Math.min(min, nums[i]);
            }
        }
        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i] > nums[i+1]) {
                max = Math.max(max, nums[i]);
            }
        }
        int l = 0, r = 0;
        for (int i=0; i<nums.length; i++) {
            if (min < nums[i]) {
                l = i;
                break;
            }
        }
        for (int i=nums.length-1; i>=0; i--) {
            if (max > nums[i]) {
                r = i;
                break;
            }
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    public static void main(String[] args) {
        Day4_ShortestUnsortedContinuousSubarray obj = new Day4_ShortestUnsortedContinuousSubarray();
        System.out.println(obj.findUnsortedSubarrayEfficient(new int[]{2,6,4,8,10,9,15}));
    }
}
