package february.week4;

public class Day6_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = (dividend * divisor) > 0 ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;

        while (dividend >= divisor) {
            int tmp = divisor;
            int count = 1;
            // multiply divisor by 2 everytime and check whether it is greater than dividend
            // thus multiply count by 2, count here is equivalent to quotient
            while (dividend >= tmp) {
                tmp <<= 1;
                count <<= 1;
            }
            // this is just to divide quotient and resultant by 2
            result += (count >> 1);
            dividend -= (tmp >> 1);
        }
        return (sign * result);
    }

    // we have shift operators that multiple by 2 and divide by 2
    public int divideEfficient(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dividendM = Math.abs((long)dividend);
        long divisorM = Math.abs((long)divisor);

        long result = 0;

        while (dividendM >= divisorM) {
            long tmp = divisorM;
            long count = 1;
            // multiply divisor by 2 everytime and check whether it is greater than dividend
            // thus multiply count by 2, count here is equivalent to quotient
            while (dividendM >= tmp) {
                tmp <<= 1;
                count <<= 1;
            }
            // this is just to divide quotient and resultant by 2
            result += (count >> 1);
            dividendM -= (tmp >> 1);
        }
        return (sign * (int)result);
    }

    public static void main(String[] args) {
        Day6_DivideTwoIntegers obj = new Day6_DivideTwoIntegers();
        System.out.println(obj.divideEfficient(Integer.MAX_VALUE, 2));
    }
}
