package may.week4;

import java.util.Arrays;

public class Day7_MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int []prefix = new int[nums.length+1];
        for (int i=0; i<nums.length; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        int map[] = new int[100001];
        Arrays.fill(map, -1);
        int start = 0;
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            start = Math.max(start, map[nums[i]] + 1);
            ans = Math.max(ans, prefix[i+1] - prefix[start]);
            map[nums[i]] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Day7_MaximumErasureValue obj = new Day7_MaximumErasureValue();
        System.out.println(obj.maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        System.out.println(obj.maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));

    }
}
