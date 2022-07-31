import java.util.Random;

public class Solution2 {
    
    Random random;
    double xc, yc, r, x, y;
    
    public Solution2(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }
    
    public double[] randPoint() {
        do {
            generate();
        } while (!check(x, y));
        return new double[]{xc + r * x, yc + r * y};
    }
    
    void generate() {
        x = random.nextDouble() * 2 - 1;
        y = random.nextDouble() * 2 - 1;
    }
    
    boolean check(double x, double y) {
        return x * x + y * y <= 1.0;
    }
}
