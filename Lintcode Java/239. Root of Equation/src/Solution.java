public class Solution {
    /**
     * @param a: parameter of the equation
     * @param b: parameter of the equation
     * @param c: parameter of the equation
     * @return: a double array, contains at most two root
     */
    public double[] rootOfEquation(double a, double b, double c) {
        // write your code here
        if (a == 0) {
            return new double[]{-c / b};
        }
        
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            return new double[0];
        } else if (delta == 0) {
            return new double[]{-b / a / 2};
        } else {
            double x1 = (-b + Math.sqrt(delta)) / a / 2, x2 = (-b - Math.sqrt(delta)) / a / 2;
            return x1 < x2 ? new double[]{x1, x2} : new double[]{x2, x1};
        }
    }
}
