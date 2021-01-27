import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int divide(int x, int y) {
        boolean isNeg = false;
        if (x < 0 && y > 0 || x > 0 && y < 0) {
            isNeg = true;
        }
        
        List<Long> list = new ArrayList<>();
        long a = Math.abs((long) x), b = Math.abs((long) y);
        for (long i = b; i <= a; i += i) {
            list.add(i);
        }
        
        long res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (a >= list.get(i)) {
                a -= list.get(i);
                res += 1L << i;
            }
        }
        
        if (isNeg) {
            res = -res;
        }
        
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            res = Integer.MAX_VALUE;
        }
        
        return (int) res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().divide(12, 3));
        // System.out.println(new Solution().divide(7, -3));
        // System.out.println(new Solution().divide(-2147483648, -1));
        System.out.println(new Solution().divide(-2147483648, 1));
    }
}
