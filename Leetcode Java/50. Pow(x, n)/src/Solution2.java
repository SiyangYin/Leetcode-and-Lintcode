public class Solution2 {
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
        
        double res = 1.0;
        while (n > 0) {
            if (n % 2 != 0) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.1, 3));
        System.out.println(Integer.toBinaryString(13));
    }
}
