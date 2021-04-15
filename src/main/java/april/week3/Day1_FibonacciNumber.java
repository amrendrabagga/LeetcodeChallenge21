package april.week3;

public class Day1_FibonacciNumber {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 0, b = 1;
        for (int i=2; i<=n; i++) {
            int t = b;
            b = a + b;
            a = t;
        }

        return b;
    }

    public static void main(String[] args) {
        Day1_FibonacciNumber obj = new Day1_FibonacciNumber();
        System.out.println(obj.fib(5));

    }
}
