public class Solution3 {
    public double myPow(double x, int n) {
        if (x > 1 && n == Integer.MIN_VALUE) return 0;
        else if (x == 0 || x == 1) return x;
        else if (n == 0) return 1;
        else if (x == -1) n %= 2;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.1, 3));
        System.out.println(Integer.toBinaryString(13));
    }
}
