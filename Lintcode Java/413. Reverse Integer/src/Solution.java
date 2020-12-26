public class Solution {
    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }
        
        long res = 0;
        int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);
        while (n > 0) {
            res *= 10;
            res += n % 10;
            n /= 10;
        }
        
        return res > Integer.MAX_VALUE ? 0 : (int) (res * sign);
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().reverseInteger(123));
        System.out.println(new Solution().reverseInteger(1534236469));
    }
}
