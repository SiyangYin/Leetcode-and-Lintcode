public class Solution2 {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        
        int sign = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        int res = 0;
        while (x != 0) {
            int a = x % 10;
            if (res > (Integer.MAX_VALUE - a) / 10) {
                return 0;
            }
            
            res = res * 10 + a;
            x /= 10;
        }
        
        return sign * res;
    }
}
