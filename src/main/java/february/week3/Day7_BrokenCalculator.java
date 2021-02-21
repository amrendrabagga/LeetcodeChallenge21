package february.week3;

public class Day7_BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        if (X > Y) {
            return X - Y;
        }
        if (X == Y) {
            return 0;
        }
        if (Y % 2 == 0) {
            return 1 + brokenCalc(X, Y / 2);
        }
        else {
            return 1 + brokenCalc(X, Y + 1);
        }
    }

    public static void main(String[] args) {
        Day7_BrokenCalculator obj = new Day7_BrokenCalculator();
        System.out.println(obj.brokenCalc(11, 24));

    }
}
