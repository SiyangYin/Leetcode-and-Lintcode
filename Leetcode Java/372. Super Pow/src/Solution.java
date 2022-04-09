public class Solution {
    public int superPow(int a, int[] b) {
        int phin = 1140, x = 0;
        for (int i = 0; i < b.length; i++) {
            x = x * 10 + b[i];
            x %= phin;
        }
        
        int res = 1;
        a %= 1337;
        while (x > 0) {
            if ((x & 1) == 1) {
                res = (res * a) % 1337;
            }
            x >>= 1;
            a = a * a % 1337;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(1337 == 7 * 191);
        // System.out.println(new Solution().superPow(1, new int[]{4, 3, 3, 8, 5, 2}));
        System.out.println(new Solution().superPow(2, new int[]{1, 0}));
        System.out.println(6 * 190);
    }
}
