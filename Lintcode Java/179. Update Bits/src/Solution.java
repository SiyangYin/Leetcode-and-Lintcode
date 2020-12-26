public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param i: A bit position
     * @param j: A bit position
     * @return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int ones = ~0 >>> (32 - (j - i + 1));
        
        n = n & (-1 - (ones << i));
        n += m << i;
        
        return n;
    }
    
    public static void main(String[] args) {
        // System.out.println(Integer.toBinaryString(1));
        // System.out.println(Integer.toBinaryString(-1));
        int res = new Solution().updateBits(1, -1, 0, 31);
        System.out.println(res);
        // System.out.println(Integer.toBinaryString(res));
        // System.out.println(Integer.toBinaryString(-1).length());
    }
}
