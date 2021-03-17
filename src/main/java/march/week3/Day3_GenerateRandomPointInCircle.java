package march.week3;

import java.util.Random;

public class Day3_GenerateRandomPointInCircle {
    private double a;
    private double b;
    private double r;
    private Random random;
    public Day3_GenerateRandomPointInCircle(double radius, double x_center, double y_center) {
        r = radius;
        a = x_center;
        b = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        double x = generateRandom(r, a);
        double y = generateRandom(r, b);
        while (isDistanceOutOfRange(x, y)) {
            x = generateRandom(r, a);
            y = generateRandom(r, b);
        }
        return new double[]{x, y};
    }

    private boolean isDistanceOutOfRange(double x, double y) {
        return Math.pow(x - a, 2) + Math.pow(y - b, 2) >= r * r;
    }

    private double generateRandom(double r, double c) {
        return c - r + random.nextDouble() * 2 * r;
    }
}
