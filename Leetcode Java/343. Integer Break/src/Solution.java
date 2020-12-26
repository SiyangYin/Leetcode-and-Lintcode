public class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        
        int twos = 0, threes = 0;
        if (n % 3 == 0) {
            threes = n / 3;
        } else if (n % 3 == 1) {
            threes = n / 3 - 1;
            twos = 2;
        } else {
            threes = n / 3;
            twos = 1;
        }
        
        int res = 1;
        res <<= twos;
        for (int i = 0; i < threes; i++) {
            res *= 3;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(10));
    }
}
