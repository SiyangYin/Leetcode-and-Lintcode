public class Solution {
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
        if (n == 0) {
            return 1.0;
        }
        
        double half = powPositiveN(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(9.88023, 3));
    }
}
