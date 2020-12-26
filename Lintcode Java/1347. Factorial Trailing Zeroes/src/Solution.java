public class Solution {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int trailingZeroes(int n) {
        // write your code here
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        
        return res;
    }
}
