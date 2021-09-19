public class Solution {
    /**
     * @param dividend: the dividend
     * @param divisor:  the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        int sign = (dividend < 0 ? -1 : 1) * (divisor < 0 ? -1 : 1);
        long x = dividend, y = divisor;
        x = Math.abs(x);
        y = Math.abs(y);
        
        long res = 0;
        while (x >= y) {
            int t = 0;
            long z = y;
            while (x >= z) {
                z <<= 1;
                t++;
            }
            
            res += 1L << t - 1;
            x -= y << t - 1;
        }
        
        res *= sign;
        return res < Integer.MIN_VALUE ? Integer.MIN_VALUE : res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().divide(Integer.MIN_VALUE, 1));
    }
}
