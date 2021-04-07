package april.week1;

public class Day6_MinimumOperationsToMakeArrayEqual {
    public int minOperations(int n) {
        int mid = n/2;
        return n % 2 == 0 ? mid * mid : mid * (mid + 1);
    }
}
