package march.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day6_BinaryTreesWithFactors {
    long mod = (long)1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, Long> map = new HashMap();
        for (int i=0; i<n; i++) {
            long count = 1L;
            for (int j=0; j<i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    count += map.get(arr[j]) * map.get(arr[i]/ arr[j]);
                }
            }
            map.put(arr[i], count);
        }
        return (int)(map.values().stream().reduce((a, b) -> a + b).get() % mod);
    }
}
