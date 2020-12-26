public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend < 0) {
            dividend = -dividend;
            sign *= -1;
        }
        if (divisor < 0) {
            divisor = -divisor;
            sign *= -1;
        }
        
        int count = 0;
        while (dividend > 0) {
            dividend -= divisor;
            count++;
        }
        if (dividend < 0) {
            count--;
        }
        
        return sign * count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().divide(12, 3));
        System.out.println(new Solution().divide(7, -3));
    }
}
