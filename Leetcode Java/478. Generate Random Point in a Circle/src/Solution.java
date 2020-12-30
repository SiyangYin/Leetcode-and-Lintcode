import java.util.Random;

public class Solution {
    
    private Random random;
    private double r, x, y;
    
    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }
    
    public double[] randPoint() {
        double theta = random.nextDouble() * 2 * Math.PI;
        double randomR = r * Math.sqrt(random.nextDouble());
        return new double[]{x + randomR * Math.cos(theta), y + randomR * Math.sin(theta)};
    }
}
