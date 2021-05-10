package may.week2;

public class Day2_ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        long sum = 0;
        int max = 0;
        for (int i=0; i<target.length; i++) {
            sum += target[i];
            if (target[max] < target[i]) {
                max = i;
            }
        }
        long diff = sum - target[max];
        // target[max] == 1 array value becomes equal to 1
        // diff == 1, for case [1,9]
        if (target[max] == 1 || diff == 1) return true;

        // diff > target[max],case target=[1,1,1,2] value to replace is less than diff
        // diff == 0, for case target=[2], target.length == 1 and sum == target[max]
        // target[max] % diff == 0, case like target=[5, 20]
        if (diff > target[max] || diff == 0 || target[max] % diff == 0) return false;
        target[max] %= diff;
        return isPossible(target);
    }
}
