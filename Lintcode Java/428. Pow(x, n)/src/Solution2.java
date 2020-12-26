public class Solution2 {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        if (n >= 0) {
            return powPositiveN(x, n);
        } else {
            return powPositiveN(1 / x, -n);
        }
    }
    
    private double powPositiveN(double x, long n) {
        double res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        
        return res;
    }
}
