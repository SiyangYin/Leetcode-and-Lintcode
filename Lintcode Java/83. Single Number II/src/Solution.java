public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumberII(int[] A) {
        // write your code here
        int[] bits = new int[32];
        for (int i : A) {
            int ind = 0;
            while (i != 0) {
                bits[ind++] += i & 1;
                i >>= 1;
            }
        }
        
        int res = 0;
        for (int i = 0; i < bits.length; i++) {
            res += (bits[i] % 3) << i;
        }
        
        return res;
    }
}