public class Solution {
    /**
     * @param x: an integer
     * @param y: an integer
     * @return: return an integer, denote the Hamming Distance between two integers
     */
    public int hammingDistance(int x, int y) {
        // write your code here
        int z = x ^ y;
        int res = 0;
        while (z != 0) {
            z -= lowbit(z);
            res++;
        }
        
        return res;
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
}
