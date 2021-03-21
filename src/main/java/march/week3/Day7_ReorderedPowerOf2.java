package march.week3;

import java.util.Arrays;

public class Day7_ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        int[] countN = count(N);
        int num = 1;
        for (int i=0; i<31; i++) {
            if (Arrays.equals(countN, count(num))) {
                return true;
            }
            num = num << 1;
        }
        return false;
    }

    private int[] count(int n) {
        int count[] = new int[10];

        while(n > 0) {
            count[n%10]++;
            n /= 10;
        }
        return count;
    }
}
