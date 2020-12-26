public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while (xor != 0) {
            xor -= lowbit(xor);
            res++;
        }
        
        return res;
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
}
