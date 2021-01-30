package january.week5;

import java.util.TreeSet;

public class Day2_MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        for (int num : nums) {
            if (num % 2 == 1) {
                set.add(num * 2);
            } else {
                set.add(num);
            }
        }
        int res = Integer.MAX_VALUE;
        while (set.last() % 2 != 1) {
            res = Math.min(res, set.last() - set.first());
            set.add(set.pollLast() / 2);
        }
        res = Math.min(res, set.last() - set.first());
        return res;
    }

    public int minimumDeviationEfficient(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        for (int num : nums) {
            if (num % 2 == 1) {
                set.add(num * 2);
            } else {
                set.add(num);
            }
        }
        int res = Integer.MAX_VALUE;
        while (true) {
            int max_val = set.last();
            res = Math.min(res, max_val - set.first());
            if (max_val % 2 == 1) {
                break;
            }
            else {
                set.add(set.pollLast() / 2);
            }
        }
        return res;
    }
}