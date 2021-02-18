package february.week3;

public class Day4_ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        if (A.length == 3) {
            return (2 * A[1]) == A[0] + A[2] ? 1 : 0;
        }
        int count = 0;
        int res = 0;
        for (int i=0; i<A.length - 2; i++) {
            if (2 * A[i+1] == A[i] + A[i+2]) {
                count++;
                res += count;
            }
            else {
                count = 0;
            }
        }
        return res;
    }
}
