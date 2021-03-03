package march.week1;

import java.util.stream.IntStream;

public class Day3_MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = IntStream.of(nums).sum();
        return (n * (n+1))/2 - sum;
    }
}
