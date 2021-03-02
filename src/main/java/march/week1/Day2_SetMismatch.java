package march.week1;

import java.util.HashSet;
import java.util.Set;

public class Day2_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int p = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                p = num;
            }
            set.add(num);
        }
        for (int i=1; i<=nums.length; i++) {
            if (!set.contains(i)) {
                return new int[] {p, i};
            }
        }
        return new int[]{};
    }
}
