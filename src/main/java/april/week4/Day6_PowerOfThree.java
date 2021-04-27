package april.week4;

public class Day6_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return Math.log10(n) / Math.log10(3) % 1 == 0;
    }
}
