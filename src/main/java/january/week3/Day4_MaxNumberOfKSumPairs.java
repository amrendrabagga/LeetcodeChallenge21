package january.week3;

import java.util.HashMap;
import java.util.Map;

public class Day4_MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();// storing freq of each num
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 2 2 3 k=2
        // for 2 we look for element 5 - 2 = 3
        for (int num : map.keySet()) {
            int other = k - num;
            if (map.containsKey(other)) {
                res += Math.min(map.get(other), map.get(num));
            }
        }
        // 2 combinations are being created, 2 3 and 32
        // thus divide by 2
        return res / 2;
    }
}
