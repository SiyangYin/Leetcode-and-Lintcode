public class Solution {
    /**
     * @param n: an unsigned integer
     * @return: the number of ’1' bits
     */
    public int hammingWeight(int n) {
        // write your code here
        int res = 0;
        while (n != 0) {
            res++;
            n -= lowbit(n);
        }
        
        return res;
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
}
