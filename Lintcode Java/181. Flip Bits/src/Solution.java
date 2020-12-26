public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public int bitSwapRequired(int a, int b) {
        // write your code here
        int c = a ^ b, res = 0;
        while (c != 0) {
            c -= lowbit(c);
            res++;
        }
        
        return res;
    }
    
    private int lowbit(int x) {
        return x & (-x);
    }
}
