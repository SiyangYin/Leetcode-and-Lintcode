public class Solution {
    public double myPow(double x, int n) {
        return pow(x, n);
    }
    
    private double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
    
        if (n < 0) {
            n = -n;
            x = 1.0 / x;
        }
    
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().myPow(2.0, -87));
        System.out.println(new Solution().myPow(2.0, -2147483648));
    }
}