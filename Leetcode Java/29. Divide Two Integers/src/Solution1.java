import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == -1) {
            return -dividend;
        }
        int dividendSign = -1;
        if (dividend >= 0) {
            dividendSign = 1;
            dividend = -dividend;
        }
        int divisorSign = -1;
        if (divisor > 0) {
            divisorSign = 1;
            divisor = -divisor;
        }
        int q = 0;
        while (dividend <= divisor) {
            dividend -= divisor;
            q++;
        }
        return dividendSign * divisorSign * q;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().divide(12, 3));
        // System.out.println(new Solution().divide(7, -3));
        // System.out.println(new Solution().divide(-2147483648, -1));
        System.out.println(new Solution1().divide(-2147483648, 1));
    }
}
