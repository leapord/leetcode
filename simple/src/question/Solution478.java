package question;

import java.util.Random;

public class Solution478 {
    Random random;
    double xd = 0;
    double yd = 0;
    double r = 0;

    public Solution478(double radius, double x_center, double y_center) {
        xd = x_center;
        yd = y_center;
        r = radius;
        random = new Random();
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;
            if ((x * x + y * y) <= r * r) {
                return new double[]{xd + x, yd + y};
            }
        }
    }
}
